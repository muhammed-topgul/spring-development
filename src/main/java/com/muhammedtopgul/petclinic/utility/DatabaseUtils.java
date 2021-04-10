package com.muhammedtopgul.petclinic.utility;

/*
 * created by Muhammed Topgul
 * on 10/04/2021
 * at 20:03
 */

import com.muhammedtopgul.petclinic.entity.OwnerEntity;
import lombok.experimental.UtilityClass;
import org.springframework.jdbc.core.RowMapper;

@UtilityClass
public class DatabaseUtils {
    public static final RowMapper<OwnerEntity> rowMapper = (resultSet, i) -> {
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setId(resultSet.getLong("id"));
        ownerEntity.setFirstName(resultSet.getString("first_name"));
        ownerEntity.setLastName(resultSet.getString("last_name"));
        return ownerEntity;
    };
}
