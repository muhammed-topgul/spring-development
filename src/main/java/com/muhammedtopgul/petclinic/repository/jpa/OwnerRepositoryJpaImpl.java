package com.muhammedtopgul.petclinic.repository.jpa;

/*
 * created by Muhammed Topgul
 * on 10/04/2021
 * at 20:56
 */

import com.muhammedtopgul.petclinic.entity.OwnerEntity;
import com.muhammedtopgul.petclinic.repository.OwnerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository(value = "ownerJpaRepository")
public class OwnerRepositoryJpaImpl implements OwnerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<OwnerEntity> findAll() {
        return entityManager.createQuery("select o from OwnerEntity o", OwnerEntity.class).getResultList();
    }

    @Override
    public OwnerEntity findById(Long id) {
        return entityManager.find(OwnerEntity.class, id);
    }

    @Override
    public List<OwnerEntity> findByLastName(String lastName) {
        return entityManager.createQuery("select o from OwnerEntity o where o.lastName = :lastName", OwnerEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public void create(OwnerEntity entity) {
        entityManager.persist(entity);
    }

    @Override
    public OwnerEntity update(OwnerEntity entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.getReference(OwnerEntity.class, id));
    }
}
