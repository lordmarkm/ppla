package com.ppla.quickbooks.service.custom;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.google.common.collect.Lists;
import com.ppla.app.models.PplaProduct;
import com.ppla.app.models.material.ProcessMaterial;
import com.ppla.app.models.material.RawMaterial;
import com.ppla.app.services.PplaProductService;
import com.ppla.app.services.ProcessMaterialService;
import com.ppla.app.services.RawMaterialService;
import com.ppla.core.reference.MaterialSource;
import com.ppla.quickbooks.dto.InventoryItemInfo;
import com.ppla.quickbooks.entity.InventoryItem;
import com.ppla.quickbooks.reference.PplaInventoryType;
import com.ppla.quickbooks.service.InventoryItemService;
import com.tyrael.commons.mapper.dto.PageInfo;
import com.tyrael.commons.mapper.service.MappingService;

/**
 * @author Mark
 */
public class InventoryItemServiceCustomImpl extends MappingService<InventoryItem, InventoryItemInfo>
    implements InventoryItemServiceCustom {

    private static Logger LOG = LoggerFactory.getLogger(InventoryItemServiceCustomImpl.class);

    private static final String longTimeAgo = "1987-03-04T00:00:00+08:00";

    @Autowired
    private InventoryItemService service;

    @Autowired
    private RawMaterialService rawMaterialService;

    @Autowired
    private ProcessMaterialService procMaterialService;

    @Autowired
    private PplaProductService productService;

    @Override
    public String getLastModifiedDate() {
        String lastModifiedDate = null;

        PageRequest page = new PageRequest(0, 1, Direction.DESC, "timeModified");
        List<InventoryItem> itemz = service.findAll(page).getContent();
        if (itemz.size() == 0) {
            lastModifiedDate = longTimeAgo;
        } else {
            InventoryItem lastModifiedItem = itemz.get(0);
            lastModifiedDate = ObjectUtils.toString(lastModifiedItem.getTimeModified());
        }

        return lastModifiedDate;
    }

    @Override
    public PageInfo<InventoryItemInfo> pageInfo(PageRequest pageRequest) {
        Page<InventoryItem> results = service.findAll(pageRequest);
        List<InventoryItemInfo> infos = Lists.newArrayList();
        for (InventoryItem wo : results) {
            InventoryItemInfo woInfo = mapper.map(wo, InventoryItemInfo.class);
            infos.add(woInfo);
        }

        PageInfo<InventoryItemInfo> pageResponse = new PageInfo<>();
        pageResponse.setData(infos);
        pageResponse.setTotal(results.getTotalElements());
        return pageResponse;
    }

    @Override
    public InventoryItemInfo saveInfo(InventoryItemInfo itemInfo) {
        InventoryItem oldItem = service.findOne(itemInfo.getId());
        clearOrDisablePplaClass(oldItem);

        InventoryItem item = service.save(toEntity(itemInfo));
        createOrEnablePplaClass(item);

        return toDto(item);
    }

    private void createOrEnablePplaClass(InventoryItem item) {
        PplaInventoryType type = item.getType();
        String listId = item.getListId();

        switch(item.getType()) {
        case RAW_MATERIAL:
            LOG.debug("Creating or updating raw material with list id={}", listId);
            RawMaterial rawMat = rawMaterialService.findByInventoryItemListId(listId);
            if (null != rawMat) {
                mapper.map(item, rawMat);
                rawMat.setDeleted(false);
            } else {
                rawMat = mapper.map(item, RawMaterial.class);
                rawMat.setInventoryItemListId(listId);
            }
            rawMaterialService.save(rawMat);
            break;
        case EXTRUSION_OUTPUT:
        case MIXING_OUTPUT:
            LOG.debug("Creating or updating process material with list id={}", listId);
            ProcessMaterial procMat = procMaterialService.findByInventoryItemListId(listId);
            if (null != procMat) {
                mapper.map(item, procMat);
                procMat.setDeleted(false);
            } else {
                procMat = mapper.map(item, ProcessMaterial.class);
                procMat.setSource(determineProcessMaterialSource(type));
                procMat.setInventoryItemListId(listId);
            }
            procMaterialService.save(procMat);
            break;
        case PRODUCT:
            LOG.debug("Creating or updating product with list id={}", listId);
            PplaProduct product = productService.findByInventoryItemListId(listId);
            if (null != product) {
                mapper.map(item, product);
                product.setDeleted(false);
            } else {
                product = mapper.map(item, PplaProduct.class);
                product.setInventoryItemListId(listId);
            }
            productService.save(product);
            break;
        case UNCLASSIFIED:
            LOG.debug("Changing from unclassified. No clear or disable necessary.");
        default:
            throw new IllegalArgumentException("Unrecognized item type. type=" + type);
        }
    }

    private void clearOrDisablePplaClass(InventoryItem oldItem) {
        switch(oldItem.getType()) {
        case RAW_MATERIAL:
            RawMaterial rawMat = rawMaterialService.findByInventoryItemListId(oldItem.getListId());
            if (null != rawMat) {
                LOG.debug("Deleting raw material with id={}", rawMat.getId());
                rawMat.setDeleted(true);
                rawMaterialService.save(rawMat);
            }
            break;
        case EXTRUSION_OUTPUT:
        case MIXING_OUTPUT:
            ProcessMaterial procMat = procMaterialService.findByInventoryItemListId(oldItem.getListId());
            if (null != procMat) {
                LOG.debug("Deleting process material with id={}", procMat.getId());
                procMat.setDeleted(true);
                procMaterialService.save(procMat);
            }
            break;
        case PRODUCT:
            PplaProduct product = productService.findByInventoryItemListId(oldItem.getListId());
            if (null != product) {
                LOG.debug("Deleting product with id={}", product.getId());
                product.setDeleted(true);
                productService.save(product);
            }
            break;
        case UNCLASSIFIED:
            LOG.debug("Changing from unclassified. No clear or disable necessary.");
        default:
            throw new IllegalArgumentException("Unrecognized item type. type=" + oldItem.getType());
        }
    }

    private MaterialSource determineProcessMaterialSource(PplaInventoryType type) {
        switch(type) {
        case EXTRUSION_OUTPUT: return MaterialSource.EXTRUSION;
        case MIXING_OUTPUT: return MaterialSource.MIXING;
        default:
            throw new IllegalArgumentException("Unsupported process material inventory type: " + type);
        }
    }
}
