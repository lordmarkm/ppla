package com.ppla.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baldy.commons.web.controller.GenericController;

/**
 * @author Mark
 */
@Controller
@RequestMapping("/operations")
public class OperationsController extends GenericController {

    private static Logger LOG = LoggerFactory.getLogger(OperationsController.class);

    @RequestMapping(method = GET)
    public ModelAndView browseSalesOrders(Principal principal) {
        LOG.debug("Operations browse request. principal={}", principal);
        return mav("operations");
    }

}
