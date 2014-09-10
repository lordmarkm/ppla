package com.ppla.app.services.reports;

import java.util.List;

import com.ppla.core.dto.report.RollTagReportInfo;

public interface RollTagReportService {

    List<RollTagReportInfo> findByTags(String tags);

}
