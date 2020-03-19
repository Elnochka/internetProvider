package com.epam.rd.july2019.spring_internet_provider.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TariffRowMapper implements RowMapper<Tariff> {
    @Override
    public Tariff mapRow(ResultSet resultSet, int i) throws SQLException {
        Tariff tariff = new Tariff();
        tariff.setIdTariff(resultSet.getInt("tariff_id"));
        tariff.setNameTariff(resultSet.getString("tariff_name"));
        tariff.setPrice(resultSet.getDouble("tariff_price"));
        tariff.setPathFile(resultSet.getString("path_file"));
        return tariff;
    }
}
