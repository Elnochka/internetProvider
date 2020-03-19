package com.epam.rd.july2019.spring_internet_provider.service;

import com.epam.rd.july2019.spring_internet_provider.dao.DaoI;
import com.epam.rd.july2019.spring_internet_provider.models.Tariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TariffService implements ServiceInterface<Tariff> {

    @Autowired
    private DaoI<Tariff> tariffDao;

    @Override
    public List<Tariff> queryElements() {
        return tariffDao.queryElements();
    }

    @Override
    public Tariff findElementName(String nameElement) {
        Tariff obj = tariffDao.findElementName(nameElement);
        return obj;
    }

    @Override
    public Tariff findElementId(Integer idElement) {
        Tariff obj = tariffDao.findElementId(idElement);
        return obj;
    }

    @Override
    public void updateElement(Tariff element) {
        tariffDao.updateElement(element);
    }

    @Override
    public void insertElement(Tariff element) {
        tariffDao.insertElement(element);
    }

    @Override
    public void deleteElement(Integer idElement) {
        tariffDao.deleteElement(idElement);
    }
}
