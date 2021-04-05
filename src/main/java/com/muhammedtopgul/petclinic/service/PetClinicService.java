package com.muhammedtopgul.petclinic.service;

/*
 * created by Muhammed Topgul
 * on 05/04/2021
 * at 23:50
 */

import com.muhammedtopgul.petclinic.entity.OwnerEntity;
import com.muhammedtopgul.petclinic.exception.OwnerNotFoundException;

import java.util.List;

public interface PetClinicService {

    List<OwnerEntity> findOwners();

    List<OwnerEntity> findOwners(String lastName);

    OwnerEntity findOwner(Long id) throws OwnerNotFoundException;

    void createOwner(OwnerEntity entity);

    void updateOwner(OwnerEntity entity);

    void deleteOwner(Long id);
}
