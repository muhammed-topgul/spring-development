package com.muhammedtopgul.petclinic.repository;

/*
 * created by Muhammed Topgul
 * on 05/04/2021
 * at 23:45
 */

import com.muhammedtopgul.petclinic.entity.PetEntity;

import java.util.List;

public interface PetRepository {

    PetEntity findById(Long id);

    List<PetEntity> findByOwnerId(Long ownerId);

    void create(PetEntity entity);

    PetEntity update(PetEntity entity);

    void delete(Long id);

    void deleteByOwnerId(Long ownerId);
}
