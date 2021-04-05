package com.muhammedtopgul.petclinic.repository;

/*
 * created by Muhammed Topgul
 * on 05/04/2021
 * at 23:45
 */

import com.muhammedtopgul.petclinic.entity.OwnerEntity;

import java.util.List;

public interface OwnerRepository {

    List<OwnerEntity> findAll();

    OwnerEntity findById(Long id);

    List<OwnerEntity> findByLastName(String lastName);

    void create(OwnerEntity entity);

    OwnerEntity update(OwnerEntity entity);

    void delete(Long id);
}
