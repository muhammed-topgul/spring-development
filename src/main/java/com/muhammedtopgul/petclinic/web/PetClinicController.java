package com.muhammedtopgul.petclinic.web;

/*
 * created by Muhammed Topgul
 * on 06/04/2021
 * at 22:10
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PetClinicController {

    @RequestMapping("/pcs")
    @ResponseBody
    public String welcome() {
        return "Welcome to PetClinic world!";
    }
}
