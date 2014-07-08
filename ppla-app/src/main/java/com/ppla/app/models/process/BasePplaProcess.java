package com.ppla.app.models.process;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import com.ppla.app.models.PplaPerson;
import com.ppla.app.models.PplaWorkOrder;
import com.tyrael.process.mgt.models.process.Process;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
public abstract class BasePplaProcess extends Process<PplaPerson, PplaWorkOrder> {

//    @Override
//    public PplaPerson getActor() {
//        return super.getActor();
//    }
//
//    @Override
//    public PplaWorkOrder getWorkOrder() {
//        return super.getWorkOrder();
//    }

}
