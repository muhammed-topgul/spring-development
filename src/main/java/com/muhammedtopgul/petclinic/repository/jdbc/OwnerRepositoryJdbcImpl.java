package com.muhammedtopgul.petclinic.repository.jdbc;

/*
 * created by Muhammed Topgul
 * on 10/04/2021
 * at 19:52
 */

import com.muhammedtopgul.petclinic.entity.OwnerEntity;
import com.muhammedtopgul.petclinic.repository.OwnerRepository;
import com.muhammedtopgul.petclinic.utility.DatabaseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ownerRepository")
@RequiredArgsConstructor
public class OwnerRepositoryJdbcImpl implements OwnerRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<OwnerEntity> findAll() {
        String sql = "select id, first_name, last_name from t_owner";
        return jdbcTemplate.query(sql, DatabaseUtils.rowMapper);
    }

    @Override
    public OwnerEntity findById(Long id) {
        String sql = "select id, first_name, last_name from t_owner where id = ?";
        return DataAccessUtils.singleResult(jdbcTemplate.query(sql, DatabaseUtils.rowMapper, id));
    }

    @Override
    public List<OwnerEntity> findByLastName(String lastName) {
        String sql = "select id, first_name, last_name from t_owner where last_name like ?";
        return jdbcTemplate.query(sql, DatabaseUtils.rowMapper, "%" + lastName + "%");
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
