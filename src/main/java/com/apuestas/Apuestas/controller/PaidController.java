package com.apuestas.Apuestas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaidController {
    @RequestMapping(value = "/pagos_tajeta", method = RequestMethod.GET)
    public ModelAndView paid() {
        ModelAndView model = new ModelAndView();
        model.setViewName("user/paid");
        return model;
    }
}
