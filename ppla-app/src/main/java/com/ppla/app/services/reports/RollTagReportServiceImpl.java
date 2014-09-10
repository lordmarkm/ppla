package com.ppla.app.services.reports;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.ppla.app.models.material.ProcessMaterialStack;
import com.ppla.app.services.ProcessMaterialStackService;
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

    @Override
    public List<RollTagReportInfo> findByTags(String tags) {
        List<ProcessMaterialStack> stacks = Lists.newArrayList();
        for (String tag : tags.split(",")) {
            stacks.add(pmsService.findByTag(tag));
        }
        return toDto(stacks);
    }

}
