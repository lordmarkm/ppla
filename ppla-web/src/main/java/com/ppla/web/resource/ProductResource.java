package com.ppla.web.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.security.Principal;
import java.util.List;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.ppla.app.models.PplaProduct;
import com.ppla.app.services.PplaProductService;
import com.ppla.core.dto.ProductInfo;
import com.tyrael.commons.dto.PageInfo;
import com.tyrael.commons.models.Product;

@RestController
@RequestMapping("/product")
public class ProductResource {

    private static final Logger LOG = LoggerFactory.getLogger(ProductResource.class);

    @Autowired
    private Mapper mapper;

    @Autowired
    private PplaProductService products;

    @RequestMapping(method = GET)
    public ResponseEntity<PageInfo<ProductInfo>> findAll(Principal principal,
            @RequestParam int page,
            @RequestParam int count) {

        LOG.debug("Product query. Principal={}, page={}, count={}", principal, page, count);

        PageRequest pageRequest = new PageRequest(page - 1, count);

        Page<PplaProduct> results = products.findAll(pageRequest);
        List<ProductInfo> productInfos = Lists.newArrayList();

        for (Product product : results) {
            productInfos.add(toProductInfo(product));
        }

        PageInfo<ProductInfo> pageResponse = new PageInfo<>();
        pageResponse.setData(productInfos);
        pageResponse.setTotal(results.getTotalElements());

        return new ResponseEntity<>(pageResponse, OK);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<ProductInfo> findOne(Principal principal, @PathVariable Long id) {

        LOG.info("Product request. id={}", id);

        ProductInfo productInfo = toProductInfo(products.findOne(id));
        LOG.info("Found product. product={}", productInfo);

        return new ResponseEntity<>(productInfo, OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<ProductInfo> save(Principal principal, 
            @RequestBody ProductInfo productInfo) {

        LOG.debug("Save request. Principal={}, Product={}", principal, productInfo);

        PplaProduct product = mapper.map(productInfo, PplaProduct.class);
        ProductInfo saved = toProductInfo(products.save(product));

        return new ResponseEntity<>(saved, OK);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<ProductInfo> delete(Principal principal, @PathVariable Long id) {
        LOG.debug("Delete request. Principal={}, Product={}", principal, id);

        PplaProduct product = products.findOne(id);
        product.setDeleted(Boolean.TRUE);
        ProductInfo saved = toProductInfo(products.save(product));

        return new ResponseEntity<>(saved, OK);
    }

    private ProductInfo toProductInfo(Product product) {
        return mapper.map(product, ProductInfo.class);
    }
}
