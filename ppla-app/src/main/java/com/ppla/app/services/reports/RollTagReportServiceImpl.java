package com.ppla.app.services.reports;

import static com.ppla.core.reference.DateUtil.formatDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.ppla.app.models.PplaOrderItem;
import com.ppla.app.models.PplaWorkOrder;
import com.ppla.app.models.material.ProcessMaterialStack;
import com.ppla.app.models.process.ExtrusionProcess;
import com.ppla.app.services.PplaOrderItemService;
import com.ppla.app.services.PplaWorkOrderService;
import com.ppla.app.services.ProcessMaterialStackService;
import com.ppla.app.services.process.ExtrusionProcessService;
import com.ppla.core.dto.report.RollTagReportInfo;
import com.tyrael.commons.mapper.service.MappingService;

/**
 * @author mbmartinez
 */
@Service
@Transactional(readOnly = true)
public class RollTagReportServiceImpl extends MappingService<ProcessMaterialStack, RollTagReportInfo>
    implements RollTagReportService {

    @Autowired
    private ProcessMaterialStackService pmsService;

    @Autowired
    private PplaWorkOrderService woService;

    @Autowired
    private PplaOrderItemService orderService;

    @Autowired
    private ExtrusionProcessService extService;

    @Override
    public List<RollTagReportInfo> printTags(Long extrusionProcessId, String tags) {
        List<ProcessMaterialStack> stacks = Lists.newArrayList();
        for (String tag : tags.split(",")) {
            ProcessMaterialStack pms = pmsService.findByTag(tag);
            if (null != pms) {
                stacks.add(pms);
            }
        }
        List<RollTagReportInfo> reportDtos = toDto(stacks);

        ExtrusionProcess process = extService.findOne(extrusionProcessId);

        for (RollTagReportInfo reportDto : reportDtos) {
            PplaWorkOrder workorder = woService.findByTrackingNo(reportDto.getWorkorderTrackingNo());
            List<PplaOrderItem> orders = orderService.findByWorkOrder(workorder);
            if (orders.size() > 0) {
                PplaOrderItem order = orders.get(0);
                reportDto.setProduct(order.getProduct().getName());
                reportDto.setProductDescription(order.getProduct().getDescription());
            }

            if (null != process) {
                reportDto.setActor(process.getActor().getName().toString());
                reportDto.setDateStarted(formatDate(process.getDateStarted()));
                reportDto.setEndActor(process.getEndActor().getName().toString());
                reportDto.setDateCompleted(formatDate(process.getDateCompleted()));
                reportDto.setRemarks(process.getRemarks());
            }
        }

        return reportDtos;
    }

}
