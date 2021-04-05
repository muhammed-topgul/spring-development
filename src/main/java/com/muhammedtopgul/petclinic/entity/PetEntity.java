package com.muhammedtopgul.petclinic.entity;

/*
 * created by Muhammed Topgul
 * on 05/04/2021
 * at 23:39
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class PetEntity {

    private Long id;

    private String name;

    private Date birthDate;

    //
    private OwnerEntity owner;
}
