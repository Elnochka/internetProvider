package com.epam.rd.july2019.spring_internet_provider.dao;

import com.epam.rd.july2019.spring_internet_provider.models.TariffFavour;
import com.epam.rd.july2019.spring_internet_provider.models.TariffFavourRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TariffFavourDao implements DaoI<TariffFavour> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String QUERY_ELEMENTS = "select * from  tariffs_favours a " +
            " left join favours b on a.favour_id = b.favour_id " +
            " left join tariffs c on a.tariff_id = c.tariff_id " +
            " left join subscribers d on a.subscriber_id = d.subscriber_id ";
    private static final String QUERY_FIND_ELEMENT_ID = "Select * from tariffs_favours a where a.tf_id = ? ";
    private static final String QUERY_INSERT_ELEMENT = "Insert into tariffs_favours(subscriber_id, tariff_id, favour_id) values (?, ?, ?)";
    private static final String QUERY_DELETE_ELEMENT = "Delete from tariffs_favours where tf_id = ?";
    private static final String QUERY_ELEMENT_USER = "select * from  tariffs_favours a " +
            " left join favours b on a.favour_id = b.favour_id " +
            " left join tariffs c on a.tariff_id = c.tariff_id " +
            " left join subscribers d on a.subscriber_id = d.subscriber_id  where a.subscriber_id = ? ";

    @Override
    public List<TariffFavour> queryElements() {
        RowMapper<TariffFavour> rowMapper = new TariffFavourRowMapper();
        return this.jdbcTemplate.query(QUERY_ELEMENTS, rowMapper);
    }

    @Override
    public TariffFavour findElementName(String nameElement) {
        return null;
    }

    @Override
    public TariffFavour findElementId(Integer idElement) {
        RowMapper<TariffFavour> rowMapper = new TariffFavourRowMapper();
        TariffFavour tariffFavour = jdbcTemplate.queryForObject(QUERY_FIND_ELEMENT_ID, rowMapper, idElement);
        return tariffFavour;
    }

    @Override
    public void updateElement(TariffFavour element) {

    }

    @Override
    public void insertElement(TariffFavour element) {
        jdbcTemplate.update(QUERY_INSERT_ELEMENT, element.getIdSubscriber(), element.getIdTariff(), element.getIdFavour());

    }

    @Override
    public void deleteElement(Integer idElement) {
        jdbcTemplate.update(QUERY_DELETE_ELEMENT, idElement);

    }

    public List<TariffFavour> queryElementsUser(int idUser) {
        RowMapper<TariffFavour> rowMapper = new TariffFavourRowMapper();
        return jdbcTemplate.query(QUERY_ELEMENT_USER, rowMapper, idUser);

    }

}
