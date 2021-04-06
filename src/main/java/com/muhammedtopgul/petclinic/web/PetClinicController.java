package com.muhammedtopgul.petclinic.web;

/*
 * created by Muhammed Topgul
 * on 06/04/2021
 * at 22:10
 */

import com.muhammedtopgul.petclinic.service.PetClinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class PetClinicController {

    private final PetClinicService petClinicService;

    @RequestMapping("/owners")
    public ModelAndView getOwners() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("owners", petClinicService.findOwners());
        modelAndView.setViewName("owners");
        return modelAndView;
    }

    @RequestMapping("/pcs")
    @ResponseBody
    public String welcome() {
        return "Welcome to PetClinic world!";
    }
}
