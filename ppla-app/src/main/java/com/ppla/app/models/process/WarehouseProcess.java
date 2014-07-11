package com.ppla.app.models.process;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "WAREHOUSE_PROCESS")
@DiscriminatorValue("WAREHOUSE")
public class WarehouseProcess extends BasePplaProcess {

}
