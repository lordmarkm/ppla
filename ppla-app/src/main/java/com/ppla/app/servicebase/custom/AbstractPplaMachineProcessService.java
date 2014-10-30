package com.ppla.app.servicebase.custom;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.ppla.app.models.machine.Machine;
import com.ppla.app.models.process.MachineProcess;
import com.ppla.app.servicebase.BasePplaMachineProcessService;
import com.ppla.app.servicebase.BasePplaMachineService;
import com.ppla.core.dto.machine.MachineInfo;
import com.ppla.core.dto.process.BasePplaProcessInfo;
import com.ppla.core.dto.process.MachineProcessInfo;
import com.tyrael.commons.dto.PageInfo;

public class AbstractPplaMachineProcessService
    <E extends MachineProcess<M, ?>,
    D extends BasePplaProcessInfo,
    R extends BasePplaMachineProcessService<E>,
    M extends Machine<E>,
    MR extends BasePplaMachineService<M>> 
    
    extends AbstractPplaProcessService<E, D, R> {

    @Autowired
    protected MR machineRepo;

    @Autowired
    protected R machineProcessRepo;

    private Class<M> machineClass;

    @PostConstruct
    public void init() {
        Class<?>[] genericTypes = GenericTypeResolver.resolveTypeArguments(getClass(), AbstractPplaMachineProcessService.class);
        machineClass = (Class<M>) genericTypes[3];
    }

    public D startMachineProcessInfo(MachineProcessInfo processInfo) {
        E process = super.start((D) processInfo);

        //Set process as machine's current process
        M machine = toMachine(processInfo.getMachine());
        machine.setCurrentProcess(process);
        machineRepo.save(machine);

        return toDto(process);
    }

    public D endMachineProcessInfo(MachineProcessInfo processInfo) {
        E process = super.end((D) processInfo);

        //Make machine available
        M machine = toMachine(processInfo.getMachine());
        machine.setCurrentProcess(null);
        machineRepo.save(machine);

        return toDto(process);
    }

    protected M toMachine(MachineInfo machineInfo) {
        return mapper.map(machineInfo, machineClass);
    }

    public PageInfo<D> pageInfoByMachineId(Long machineId, PageRequest page) {
        Page<E> entities = machineProcessRepo.findByMachine_Id(machineId, page);

        PageInfo<D> results = new PageInfo<>();
        results.setData(toDto(entities.getContent()));
        results.setTotal(entities.getTotalElements());

        return results;
    }
}
