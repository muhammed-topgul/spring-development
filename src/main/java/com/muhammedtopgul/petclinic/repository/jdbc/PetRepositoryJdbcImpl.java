package com.muhammedtopgul.petclinic.repository.jdbc;

/*
 * created by Muhammed Topgul
 * on 10/04/2021
 * at 20:22
 */

import com.muhammedtopgul.petclinic.entity.PetEntity;
import com.muhammedtopgul.petclinic.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "petJdbcRepository")
@RequiredArgsConstructor
public class PetRepositoryJdbcImpl implements PetRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public PetEntity findById(Long id) {
        return null;
    }

    @Override
    public List<PetEntity> findByOwnerId(Long ownerId) {
        return null;
    }

    @Override
    public void create(PetEntity entity) {

    }

    @Override
    public PetEntity update(PetEntity entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteByOwnerId(Long ownerId) {
        String sql = "delete from t_pet where owner_id = ?";
        jdbcTemplate.update(sql, ownerId);
        // @Transactional
        // checked exception ise commit
        // unchecked exception ise rollback yapar
        // if (true) throw new RuntimeException("Testing Rollback...");
    }
}
