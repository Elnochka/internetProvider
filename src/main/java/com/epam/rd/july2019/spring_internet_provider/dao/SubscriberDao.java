package com.epam.rd.july2019.spring_internet_provider.dao;

import com.epam.rd.july2019.spring_internet_provider.models.SubscriberRowMapper;
import com.epam.rd.july2019.spring_internet_provider.models.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SubscriberDao implements DaoI<Subscriber> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String QUERY_ELEMENTS = "Select * from subscribers a left join accounts b on a.account_id = b.account_id";
    private static final String QUERY_FIND_ELEMENT_NAME = "Select * from subscribers a left join accounts b on a.account_id = b.account_id" +
            " where subscriber_name = ? ";
    private static final String QUERY_FIND_ELEMENT_ID = "Select * from subscribers a left join accounts b on a.account_id = b.account_id" +
            " where a.subscriber_id = ? ";
    private static final String QUERY_UPDATE_ELEMENT = "Update subscribers set subscriber_name = ?, subscriber_blocked = ?, account_id = ? where subscriber_id = ? ";
    private static final String QUERY_INSERT_ELEMENT = "Insert into subscribers(subscriber_name, subscriber_blocked, account_id) values (?, ?, ?)";
    private static final String QUERY_DELETE_ELEMENT = "Delete from subscribers where subscriber_id = ?";
    private static final String QUERY_FIND_ELEMENT_ID_ONLY = "Select * from subscribers where subscriber_id = ? ";

    @Override
    public List<Subscriber> queryElements() {
        RowMapper<Subscriber> rowMapper = new SubscriberRowMapper();
        return this.jdbcTemplate.query(QUERY_ELEMENTS, rowMapper);
    }

    @Override
    public Subscriber findElementName(String nameElement) {
        RowMapper<Subscriber> rowMapper = new SubscriberRowMapper();
        Subscriber subscriber = jdbcTemplate.queryForObject(QUERY_FIND_ELEMENT_NAME, rowMapper, nameElement);
        return subscriber;
    }

    @Override
    public Subscriber findElementId(Integer idElement) {
        RowMapper<Subscriber> rowMapper = new SubscriberRowMapper();
        Subscriber subscriber = jdbcTemplate.queryForObject(QUERY_FIND_ELEMENT_ID, rowMapper, idElement);
        return subscriber;
    }

    @Override
    public void updateElement(Subscriber element) {
        jdbcTemplate.update(QUERY_UPDATE_ELEMENT, element.getNameSubscriber(), element.isBlocked(), element.getAccount(), element.getIdSubscriber());

    }

    @Override
    public void insertElement(Subscriber element) {
        jdbcTemplate.update(QUERY_INSERT_ELEMENT, element.getNameSubscriber(), element.isBlocked(), element.getAccount());
    }

    @Override
    public void deleteElement(Integer idElement) {
        jdbcTemplate.update(QUERY_DELETE_ELEMENT, idElement);

    }

    public Subscriber findElementIdOnly(Integer idElement) {
        RowMapper<Subscriber> rowMapper = new SubscriberRowMapper();
        Subscriber subscriber = jdbcTemplate.queryForObject(QUERY_FIND_ELEMENT_ID, rowMapper, idElement);
        return subscriber;
    }
}
