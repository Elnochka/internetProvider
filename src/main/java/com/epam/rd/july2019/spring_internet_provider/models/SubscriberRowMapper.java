package com.epam.rd.july2019.spring_internet_provider.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscriberRowMapper implements RowMapper<Subscriber> {
    @Override
    public Subscriber mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setIdAccount(resultSet.getInt("account_id"));
        account.setAccount(resultSet.getLong("account"));
        account.setBalance(resultSet.getDouble("balance"));
        Subscriber subscriber = new Subscriber();
        subscriber.setIdSubscriber(resultSet.getInt("subscriber_id"));
        subscriber.setNameSubscriber(resultSet.getString("subscriber_name"));
        subscriber.setAccount(resultSet.getInt("account_id"));
        subscriber.setBlocked(resultSet.getBoolean("subscriber_blocked"));
        subscriber.setAccountObject(account);
        return subscriber;
    }
}
