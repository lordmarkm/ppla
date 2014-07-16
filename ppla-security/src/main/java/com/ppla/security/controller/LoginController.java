package com.ppla.security.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.baldy.commons.web.controller.GenericController;

/**
 * @author mbmartinez
 */
@Controller
@RequestMapping("/auth")
public class LoginController extends GenericController {

    @RequestMapping(value = "/login", method = GET)
    public ModelAndView login(@RequestParam(required=false) String msg) {
        return mav("login")
            .addObject("msg", msg);
    }

}
