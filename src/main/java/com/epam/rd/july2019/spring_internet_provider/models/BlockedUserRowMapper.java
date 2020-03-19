package com.epam.rd.july2019.spring_internet_provider.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BlockedUserRowMapper implements RowMapper<BlockedUser> {
    @Override
    public BlockedUser mapRow(ResultSet resultSet, int i) throws SQLException {
        BlockedUser blockedUser = new BlockedUser();
        blockedUser.setIdBlockedSubscriber(resultSet.getInt("subscriber_id"));
        blockedUser.setIdBlockedTariff(resultSet.getInt("tariff_id"));
        blockedUser.setIdBlockedAccount(resultSet.getInt("account_id"));
        return blockedUser;
    }
}
