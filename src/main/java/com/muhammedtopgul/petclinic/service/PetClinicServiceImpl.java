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

    private final OwnerRepository ownerRepository;

    @Override
    public List<OwnerEntity> findOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public List<OwnerEntity> findOwners(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public OwnerEntity findOwner(Long id) throws OwnerNotFoundException {
        OwnerEntity entity = ownerRepository.findById(id);

        if (entity == null)
            throw new OwnerNotFoundException("Owner bulunamadı");
        return entity;
    }

    @Override
    public void createOwner(OwnerEntity entity) {
        ownerRepository.create(entity);
    }

    @Override
    public void updateOwner(OwnerEntity entity) {
        ownerRepository.update(entity);
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepository.delete(id);
    }
}
