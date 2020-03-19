package com.epam.rd.july2019.spring_internet_provider.models;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FavourRowMapper implements RowMapper<Favour> {

    @Override
    public Favour mapRow(ResultSet resultSet, int i) throws SQLException {

        Favour favour = new Favour();
        favour.setIdFavour(resultSet.getInt("favour_id"));
        favour.setNameFavour(resultSet.getString("favour_name"));
        return favour;

    }
}
