package com.muhammedtopgul.petclinic.repository.jpa;

/*
 * created by Muhammed Topgul
 * on 10/04/2021
 * at 20:56
 */

import com.muhammedtopgul.petclinic.entity.PetEntity;
import com.muhammedtopgul.petclinic.repository.PetRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository(value = "petJpaRepository")
public class PetRepositoryJpaImpl implements PetRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public PetEntity findById(Long id) {
        return entityManager.find(PetEntity.class, id);
    }

    @Override
    public List<PetEntity> findByOwnerId(Long ownerId) {
        return entityManager.createQuery("select p from PetEntity p where p.owner.id = :ownerId", PetEntity.class)
                .setParameter("ownerId", ownerId)
                .getResultList();
    }

    @Override
    public void create(PetEntity entity) {
        entityManager.persist(entity);
    }

    @Override
    public PetEntity update(PetEntity entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.getReference(PetEntity.class, id));
    }

    @Override
    public void deleteByOwnerId(Long ownerId) {
        entityManager.createQuery("delete from PetEntity p where p.owner.id = :ownerId")
                .setParameter("ownerId", ownerId)
                .executeUpdate();
    }
}
