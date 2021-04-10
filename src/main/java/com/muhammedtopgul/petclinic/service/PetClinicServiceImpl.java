package com.muhammedtopgul.petclinic.service;

/*
 * created by Muhammed Topgul
 * on 05/04/2021
 * at 23:50
 */

import com.muhammedtopgul.petclinic.entity.OwnerEntity;
import com.muhammedtopgul.petclinic.exception.OwnerNotFoundException;
import com.muhammedtopgul.petclinic.repository.OwnerRepository;
import com.muhammedtopgul.petclinic.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PetClinicServiceImpl implements PetClinicService {

    private final OwnerRepository ownerJdbcRepository;
    private final PetRepository petJdbcRepository;

    @Override
    public List<OwnerEntity> findOwners() {
        return ownerJdbcRepository.findAll();
    }

    @Override
    public List<OwnerEntity> findOwners(String lastName) {
        return ownerJdbcRepository.findByLastName(lastName);
    }

    @Override
    public OwnerEntity findOwner(Long id) throws OwnerNotFoundException {
        OwnerEntity entity = ownerJdbcRepository.findById(id);

        if (entity == null)
            throw new OwnerNotFoundException("Owner bulunamadı");
        return entity;
    }

    @Override
    public void createOwner(OwnerEntity entity) {
        ownerJdbcRepository.create(entity);
    }

    @Override
    public void updateOwner(OwnerEntity entity) {
        ownerJdbcRepository.update(entity);
    }

    @Override
    public void deleteOwner(Long id) {
        petJdbcRepository.deleteByOwnerId(id);
        ownerJdbcRepository.delete(id);
    }
}
