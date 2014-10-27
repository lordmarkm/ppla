package com.ppla.quickbooks.unmarshaller;

import java.util.List;

import com.ppla.quickbooks.entity.generated.SalesOrderLineRet;
import com.ppla.quickbooks.entity.generated.SalesOrderQueryRsType;
import com.ppla.quickbooks.entity.generated.SalesOrderRet;

public class SalesorderQueryResponseProcessor {

    public void processSalesOrderQueryResponse(SalesOrderQueryRsType salesOrderQueryRsType) {
        List<SalesOrderRet> salesOrders = salesOrderQueryRsType.getSalesOrderRet();
        for (SalesOrderRet salesOrder : salesOrders) {
            processSalesOrder(salesOrder);
        }
    }

    private void processSalesOrder(SalesOrderRet salesOrder) {
        List<Object> inventoryElements = salesOrder.getSalesOrderLineRetOrSalesOrderLineGroupRet();
        for (Object inventoryElement : inventoryElements) {
            if (inventoryElement instanceof SalesOrderLineRet) {
                processSalesOrderLineRet((SalesOrderLineRet) inventoryElement);
            }
        }
    }

    private void processSalesOrderLineRet(SalesOrderLineRet inventoryElement) {
        // TODO Auto-generated method stub
        
    }

}
