package com.muhammedtopgul.petclinic.repository.jpa;

/*
 * created by Muhammed Topgul
 * on 10/04/2021
 * at 20:56
 */

import com.muhammedtopgul.petclinic.entity.OwnerEntity;
import com.muhammedtopgul.petclinic.repository.OwnerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "ownerJpaRepository")
public class OwnerRepositoryJpaImpl implements OwnerRepository {
    @Override
    public List<OwnerEntity> findAll() {
        return null;
    }

    @Override
    public OwnerEntity findById(Long id) {
        return null;
    }

    @Override
    public List<OwnerEntity> findByLastName(String lastName) {
        return null;
    }

    @Override
    public void create(OwnerEntity entity) {

    }

    @Override
    public OwnerEntity update(OwnerEntity entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
