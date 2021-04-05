package com.muhammedtopgul.petclinic.config;

/*
 * created by Muhammed Topgul
 * on 05/04/2021
 * at 22:59
 */

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "petclinic")
@Getter
@Setter
public class ApplicationProperties {

    private boolean displayOwnersWithPets = false;
}
