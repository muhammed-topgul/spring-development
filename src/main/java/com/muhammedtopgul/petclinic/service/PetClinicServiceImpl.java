package com.muhammedtopgul.petclinic.service;

/*
 * created by Muhammed Topgul
 * on 05/04/2021
 * at 23:50
 */

import com.muhammedtopgul.petclinic.entity.OwnerEntity;
import com.muhammedtopgul.petclinic.exception.OwnerNotFoundException;
import com.muhammedtopgul.petclinic.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetClinicServiceImpl implements PetClinicService {

    private final OwnerRepository repository;

    @Override
    public List<OwnerEntity> findOwners() {
        return repository.findAll();
    }

    @Override
    public List<OwnerEntity> findOwners(String lastName) {
        return repository.findByLastName(lastName);
    }

    @Override
    public OwnerEntity findOwner(Long id) throws OwnerNotFoundException {
        OwnerEntity entity = repository.findById(id);

        if (entity == null)
            throw new OwnerNotFoundException("Owner bulunamadı");
        return entity;
    }

    @Override
    public void createOwner(OwnerEntity entity) {
        repository.create(entity);
    }

    @Override
    public void updateOwner(OwnerEntity entity) {
        repository.update(entity);
    }

    @Override
    public void deleteOwner(Long id) {
        repository.delete(id);
    }
}
