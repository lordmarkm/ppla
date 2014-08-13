package com.ppla.app.servicebase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.process.BasePplaProcess;

/**
 * @author mbmartinez
 * @param <P> process type
 */
public interface BasePplaProcessService<P extends BasePplaProcess> 
    extends JpaRepository<P, Long> {

    List<P> findByWorkOrder_TrackingNo(String trackingNo);
    List<P> findByWorkOrder_TrackingNoIn(List<String> trackingNoList);

}
