package com.ppla.web.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baldy.commons.web.controller.GenericController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author Mark
 */
@Controller
@RequestMapping("/manage")
public class ManagerController extends GenericController {

    private static Logger LOG = LoggerFactory.getLogger(ManagerController.class);

    @RequestMapping(method = GET)
    public ModelAndView browseSalesOrders(Principal principal) {
        LOG.debug("Manager browse request. principal={}", principal);
        return mav("manage");
    }

}
