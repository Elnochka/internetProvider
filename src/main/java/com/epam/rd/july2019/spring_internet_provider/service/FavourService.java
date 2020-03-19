package com.epam.rd.july2019.spring_internet_provider.service;

import com.epam.rd.july2019.spring_internet_provider.dao.DaoI;
import com.epam.rd.july2019.spring_internet_provider.models.Favour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavourService implements ServiceInterface<Favour> {

    @Autowired
    private DaoI<Favour> favourDao;

    @Override
    public List<Favour> queryElements() {
        return favourDao.queryElements();
    }

    @Override
    public Favour findElementName(String nameElement) {
        Favour obj = favourDao.findElementName(nameElement);
        return obj;
    }

    @Override
    public Favour findElementId(Integer idElement) {
        Favour obj = favourDao.findElementId(idElement);
        return obj;
    }

    @Override
    public void updateElement(Favour element) {
        favourDao.updateElement(element);
    }

    @Override
    public void insertElement(Favour element) {
        favourDao.insertElement(element);
    }

    @Override
    public void deleteElement(Integer idElement) {
        favourDao.deleteElement(idElement);
    }

}
