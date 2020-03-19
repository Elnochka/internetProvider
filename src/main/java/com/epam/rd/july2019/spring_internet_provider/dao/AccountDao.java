package com.epam.rd.july2019.spring_internet_provider.dao;

import com.epam.rd.july2019.spring_internet_provider.models.Account;
import com.epam.rd.july2019.spring_internet_provider.models.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AccountDao implements DaoI<Account> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String QUERY_ELEMENTS = "Select * from accounts";
    private static final String QUERY_FIND_ELEMENT_NAME = "Select * from accounts where account = ? ";
    private static final String QUERY_FIND_ELEMENT_ID = "Select * from accounts where account_id = ? ";
    private static final String QUERY_UPDATE_ELEMENT = "Update accounts set account = ?, balance = ? where account_id = ? ";
    private static final String QUERY_INSERT_ELEMENT = "Insert into accounts(account, balance) values (?, ?) ";
    private static final String QUERY_DELETE_ELEMENT = "Delete from accounts where account_id = ? ";

    @Override
    public List<Account> queryElements() {
        RowMapper<Account> rowMapper = new AccountRowMapper();
        return this.jdbcTemplate.query(QUERY_ELEMENTS, rowMapper);
    }

    @Override
    public Account findElementName(String nameElement) {
        return null;
    }

    @Override
    public Account findElementId(Integer idElement) {
        RowMapper<Account> rowMapper = new AccountRowMapper();
        Account account = jdbcTemplate.queryForObject(QUERY_FIND_ELEMENT_ID, rowMapper, idElement);
        return account;
    }

    @Override
    public void updateElement(Account element) {
        jdbcTemplate.update(QUERY_UPDATE_ELEMENT, element.getAccount(), element.getBalance(), element.getIdAccount());

    }

    @Override
    public void insertElement(Account element) {
        jdbcTemplate.update(QUERY_INSERT_ELEMENT, element.getAccount(), element.getBalance());

    }

    @Override
    public void deleteElement(Integer idElement) {
        jdbcTemplate.update(QUERY_DELETE_ELEMENT, idElement);

    }

    public Account findElementNameInt(Long nameElement) {
        RowMapper<Account> rowMapper = new AccountRowMapper();
        Account account = jdbcTemplate.queryForObject(QUERY_FIND_ELEMENT_NAME, rowMapper, nameElement);
        return account;
    }

}
