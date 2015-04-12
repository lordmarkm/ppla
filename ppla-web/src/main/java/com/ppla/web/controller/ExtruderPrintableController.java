package com.ppla.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baldy.commons.web.controller.GenericController;
import com.ppla.app.services.process.ExtrusionProcessService;
import com.ppla.core.dto.process.ExtrusionProcessInfo;

@Controller
public class ExtruderPrintableController extends GenericController {

    @Autowired
    private ExtrusionProcessService extService;

    @RequestMapping("/extruderprint/{processId}")
    public ModelAndView extruderPrint(Principal principal, @PathVariable Long processId) {
        ExtrusionProcessInfo process = extService.findOneInfo(processId);
        return mav("extruder_printable")
                .addObject("process", process);
    }

}
