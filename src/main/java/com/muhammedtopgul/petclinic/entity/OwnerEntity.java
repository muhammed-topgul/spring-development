package com.muhammedtopgul.petclinic.entity;

/*
 * created by Muhammed Topgul
 * on 05/04/2021
 * at 23:38
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(of = {"id", "firstName", "lastName"})
public class OwnerEntity {

    private Long id;

    private String firstName;

    private String lastName;

    //
    private Set<PetEntity> pets = new HashSet<>();
}
