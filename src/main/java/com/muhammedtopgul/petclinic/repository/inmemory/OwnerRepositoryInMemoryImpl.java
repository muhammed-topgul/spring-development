package com.muhammedtopgul.petclinic.repository.inmemory;

/*
 * created by Muhammed Topgul
 * on 05/04/2021
 * at 23:55
 */

import com.muhammedtopgul.petclinic.entity.OwnerEntity;
import com.muhammedtopgul.petclinic.repository.OwnerRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OwnerRepositoryInMemoryImpl implements OwnerRepository {

    private final Map<Long, OwnerEntity> owners = new HashMap<>();

    public OwnerRepositoryInMemoryImpl() {
        OwnerEntity owner1 = new OwnerEntity();
        owner1.setId(1L);
        owner1.setFirstName("Muhammed");
        owner1.setLastName("Topgül");
        owners.put(owner1.getId(), owner1);

        OwnerEntity owner2 = new OwnerEntity();
        owner2.setId(2L);
        owner2.setFirstName("Merve");
        owner2.setLastName("Destur");
        owners.put(owner2.getId(), owner2);

        OwnerEntity owner3 = new OwnerEntity();
        owner3.setId(3L);
        owner3.setFirstName("Orhan");
        owner3.setLastName("Topgül");
        owners.put(owner3.getId(), owner3);

        OwnerEntity owner4 = new OwnerEntity();
        owner4.setId(4L);
        owner4.setFirstName("Hüseyin");
        owner4.setLastName("Topgül");
        owners.put(owner4.getId(), owner4);
    }

    @Override
    public List<OwnerEntity> findAll() {
        return new ArrayList<>(owners.values());
    }

    @Override
    public OwnerEntity findById(Long id) {
        return owners.get(id);
    }

    @Override
    public List<OwnerEntity> findByLastName(String lastName) {
        return owners.values()
                .stream()
                .filter(owner -> owner.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    @Override
    public void create(OwnerEntity entity) {
        entity.setId(new Date().getTime());
        owners.put(entity.getId(), entity);
    }

    @Override
    public OwnerEntity update(OwnerEntity entity) {
        return owners.replace(entity.getId(), entity);
    }

    @Override
    public void delete(Long id) {
        owners.remove(id);
    }
}
