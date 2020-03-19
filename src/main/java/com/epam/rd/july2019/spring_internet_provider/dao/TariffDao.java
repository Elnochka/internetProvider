package com.epam.rd.july2019.spring_internet_provider.dao;

import com.epam.rd.july2019.spring_internet_provider.models.Tariff;
import com.epam.rd.july2019.spring_internet_provider.models.TariffRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TariffDao implements DaoI<Tariff> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String QUERY_ELEMENTS = "Select * from tariffs";
    private static final String QUERY_FIND_ELEMENT_NAME = "Select * from tariffs where tariff_name = ? ";
    private static final String QUERY_FIND_ELEMENT_ID = "Select * from tariffs where tariff_id = ? ";
    private static final String QUERY_UPDATE_ELEMENT = "Update tariffs set tariff_name = ?, tariff_price = ?, path_file = ? where tariff_id = ? ";
    private static final String QUERY_INSERT_ELEMENT = "Insert into tariffs(tariff_name, tariff_price, path_file) values (?, ?, ?)";
    private static final String QUERY_DELETE_ELEMENT = "Delete from tariffs where tariff_id = ?";

    @Override
    public List<Tariff> queryElements() {
        RowMapper<Tariff> rowMapper = new TariffRowMapper();
        return this.jdbcTemplate.query(QUERY_ELEMENTS, rowMapper);
    }

    @Override
    public Tariff findElementName(String nameElement) {
        RowMapper<Tariff> rowMapper = new TariffRowMapper();
        Tariff tariff = jdbcTemplate.queryForObject(QUERY_FIND_ELEMENT_NAME, rowMapper, nameElement);
        return tariff;
    }

    @Override
    public Tariff findElementId(Integer idElement) {
        RowMapper<Tariff> rowMapper = new TariffRowMapper();
        Tariff tariff = jdbcTemplate.queryForObject(QUERY_FIND_ELEMENT_ID, rowMapper, idElement);
        return tariff;
    }

    @Override
    public void updateElement(Tariff element) {
        jdbcTemplate.update(QUERY_UPDATE_ELEMENT, element.getNameTariff(), element.getPrice(), element.getPathFile(), element.getIdTariff());
    }

    @Override
    public void insertElement(Tariff element) {
        jdbcTemplate.update(QUERY_INSERT_ELEMENT, element.getNameTariff(), element.getPrice(), element.getPathFile());

    }

    @Override
    public void deleteElement(Integer idElement) {
        jdbcTemplate.update(QUERY_DELETE_ELEMENT, idElement);

    }

}
