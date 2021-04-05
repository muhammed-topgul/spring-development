package com.muhammedtopgul.petclinic.config;

/*
 * created by Muhammed Topgul
 * on 05/04/2021
 * at 23:05
 */

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
public class PetClinicConfiguration {

    private final ApplicationProperties applicationProperties;

    @PostConstruct
    public void init() {
        System.out.println("Display owners with pets: " + applicationProperties.isDisplayOwnersWithPets());
    }
}
