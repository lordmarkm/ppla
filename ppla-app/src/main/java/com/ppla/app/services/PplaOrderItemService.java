package com.ppla.app.services;

import java.util.List;

import com.ppla.app.models.PplaOrderItem;
import com.ppla.app.models.PplaProduct;
import com.ppla.app.models.PplaWorkOrder;
import com.ppla.app.servicebase.BasePplaService;
import com.ppla.app.services.custom.PplaOrderItemServiceCustom;

public interface PplaOrderItemService extends BasePplaService<PplaOrderItem, Long>,
    PplaOrderItemServiceCustom {

    List<PplaOrderItem> findByProduct(PplaProduct product);
    List<PplaOrderItem> findByWorkOrder(PplaWorkOrder workorder);
    PplaOrderItem findByTxnLineId(String txnLineId);

}
