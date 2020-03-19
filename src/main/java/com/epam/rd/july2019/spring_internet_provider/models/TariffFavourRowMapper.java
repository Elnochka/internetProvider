package com.epam.rd.july2019.spring_internet_provider.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TariffFavourRowMapper implements RowMapper<TariffFavour> {
    @Override
    public TariffFavour mapRow(ResultSet resultSet, int i) throws SQLException {
        TariffFavour tariffFavour = new TariffFavour();
        Subscriber subscriber = new Subscriber();
        Tariff tariff = new Tariff();
        Favour favour = new Favour();
        subscriber.setIdSubscriber(resultSet.getInt("subscriber_id"));
        subscriber.setNameSubscriber(resultSet.getString("subscriber_name"));
        subscriber.setAccount(resultSet.getInt("account_id"));
        tariff.setIdTariff(resultSet.getInt("tariff_id"));
        tariff.setNameTariff(resultSet.getString("tariff_name"));
        tariff.setPrice(resultSet.getDouble("tariff_price"));
        tariff.setPathFile(resultSet.getString("path_file"));
        favour.setIdFavour(resultSet.getInt("favour_id"));
        favour.setNameFavour(resultSet.getString("favour_name"));
        tariffFavour.setIdTariffFavour(resultSet.getInt("tf_id"));
        tariffFavour.setIdSubscriber(resultSet.getInt("subscriber_id"));
        tariffFavour.setIdTariff(resultSet.getInt("tariff_id"));
        tariffFavour.setIdFavour(resultSet.getInt("favour_id"));
        tariffFavour.setFavour(favour);
        tariffFavour.setTariff(tariff);
        tariffFavour.setSubscriber(subscriber);
        return tariffFavour;
    }
}
