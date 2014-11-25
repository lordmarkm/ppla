package com.ppla.quickbooks.unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ppla.app.models.PplaSalesOrder;
import com.ppla.app.services.PplaSalesOrderService;
import com.ppla.quickbooks.entity.generated.ModifiedDateRangeFilter;
import com.ppla.quickbooks.entity.generated.SalesOrderQueryRqType;
import com.ppla.quickbooks.util.QBDateAdapter;

@Service
public class SalesOrderQueryComposer {

    @Autowired
    private PplaSalesOrderService service;

    @Autowired
    private QBDateAdapter dateAdapter;

    public SalesOrderQueryRqType createSalesOrderQuery() {
        ModifiedDateRangeFilter soDateFilter = new ModifiedDateRangeFilter();
        //soDateFilter.setFromModifiedDate("2014-09-19T16:57:59+08:00");
        soDateFilter.setFromModifiedDate(getLastModified());
        SalesOrderQueryRqType salesOrderQuery = new SalesOrderQueryRqType();
        salesOrderQuery.getOwnerID().add("0");
        salesOrderQuery.setRequestID("12345");
        salesOrderQuery.setModifiedDateRangeFilter(soDateFilter);
        salesOrderQuery.setIncludeLineItems("true");

        return salesOrderQuery;
    }

    private String getLastModified() {
        PageRequest page = new PageRequest(0, 1, Direction.DESC, "timeModified");
        Page<PplaSalesOrder> results = service.findAll(page);

        if (results.getContent().size() > 0) {
            PplaSalesOrder latestEdited = results.getContent().get(0);
            return dateAdapter.format(latestEdited.getTimeModified());
        }

        return "2004-09-19T16:57:59+08:00";
    }

}
