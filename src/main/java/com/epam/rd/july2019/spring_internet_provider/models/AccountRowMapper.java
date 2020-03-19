package com.epam.rd.july2019.spring_internet_provider.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setIdAccount(resultSet.getInt("account_id"));
        account.setAccount(resultSet.getLong("account"));
        account.setBalance(resultSet.getDouble("balance"));
        return account;
    }
}
