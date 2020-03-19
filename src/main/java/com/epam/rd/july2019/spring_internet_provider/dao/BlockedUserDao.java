package com.epam.rd.july2019.spring_internet_provider.dao;

import com.epam.rd.july2019.spring_internet_provider.models.BlockedUser;
import com.epam.rd.july2019.spring_internet_provider.models.BlockedUserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BlockedUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String BLOCKED_QUERY = "select a.subscriber_id, a.tariff_id, d.account_id  from  tariffs_favours a  " +
            "    left join tariffs c on a.tariff_id = c.tariff_id " +
            "    left join subscribers d on a.subscriber_id = d.subscriber_id " +
            "    group by a.subscriber_id, a.tariff_id, d.account_id ";

    public List<BlockedUser> getBlockedElement() {
        RowMapper<BlockedUser> rowMapper = new BlockedUserRowMapper();
        return this.jdbcTemplate.query(BLOCKED_QUERY, rowMapper);
    }
}
