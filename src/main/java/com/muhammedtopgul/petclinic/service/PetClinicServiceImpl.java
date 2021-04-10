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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PetClinicServiceImpl implements PetClinicService {

    @Autowired
    @Qualifier("ownerJpaRepository")
    private OwnerRepository ownerRepository;

    @Autowired
    @Qualifier("petJpaRepository")
    private PetRepository petRepository;

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
        petRepository.deleteByOwnerId(id);
        ownerRepository.delete(id);
    }
}
