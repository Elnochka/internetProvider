package com.epam.rd.july2019.spring_internet_provider.dao;

import com.epam.rd.july2019.spring_internet_provider.models.Favour;
import com.epam.rd.july2019.spring_internet_provider.models.FavourRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class FavourDao implements DaoI<Favour> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String QUERY_ELEMENTS = "Select * from favours";
    private static final String QUERY_FIND_ELEMENT_NAME = "Select * from favours where favour_name = ? ";
    private static final String QUERY_FIND_ELEMENT_ID = "Select * from favours where favour_id = ? ";
    private static final String QUERY_UPDATE_ELEMENT = "Update favours set favour_name = ? where favour_id = ? ";
    private static final String QUERY_INSERT_ELEMENT = "Insert into favours(favour_name) values (?)";
    private static final String QUERY_DELETE_ELEMENT = "Delete from favours where favour_id = ?";

    @Override
    public List<Favour> queryElements() {
        RowMapper<Favour> rowMapper = new FavourRowMapper();
        return this.jdbcTemplate.query(QUERY_ELEMENTS, rowMapper);

    }

    @Override
    public Favour findElementName(String nameElement) {
        RowMapper<Favour> rowMapper = new FavourRowMapper();
        Favour favour = jdbcTemplate.queryForObject(QUERY_FIND_ELEMENT_NAME, rowMapper, nameElement);
        return favour;

    }

    @Override
    public Favour findElementId(Integer idElement) {
        RowMapper<Favour> rowMapper = new FavourRowMapper();
        Favour favour = jdbcTemplate.queryForObject(QUERY_FIND_ELEMENT_ID, rowMapper, idElement);
        return favour;

    }

    @Override
    public void updateElement(Favour element) {
        jdbcTemplate.update(QUERY_UPDATE_ELEMENT, element.getNameFavour(), element.getIdFavour());

    }

    @Override
    public void insertElement(Favour element) {
        jdbcTemplate.update(QUERY_INSERT_ELEMENT, element.getNameFavour());

    }

    @Override
    public void deleteElement(Integer idElement) {
        jdbcTemplate.update(QUERY_DELETE_ELEMENT, idElement);

    }

}
