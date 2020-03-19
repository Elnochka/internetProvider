package com.epam.rd.july2019.spring_internet_provider.service;

import com.epam.rd.july2019.spring_internet_provider.dao.TariffFavourDao;
import com.epam.rd.july2019.spring_internet_provider.models.TariffFavour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TariffFavourService implements ServiceInterface<TariffFavour> {

    @Autowired
    private TariffFavourDao tariffFavourDao;

    @Override
    public List<TariffFavour> queryElements() {
        return tariffFavourDao.queryElements();
    }

    @Override
    public TariffFavour findElementName(String nameElement) {
        return null;
    }

    @Override
    public TariffFavour findElementId(Integer idElement) {
        TariffFavour obj = tariffFavourDao.findElementId(idElement);
        return obj;
    }

    @Override
    public void updateElement(TariffFavour element) {

    }

    @Override
    public void insertElement(TariffFavour element) {
        tariffFavourDao.insertElement(element);
    }

    @Override
    public void deleteElement(Integer idElement) {
        tariffFavourDao.deleteElement(idElement);
    }

    public List<TariffFavour> queryElementsUser(Integer idUser) {
        return tariffFavourDao.queryElementsUser(idUser);
    }
}

