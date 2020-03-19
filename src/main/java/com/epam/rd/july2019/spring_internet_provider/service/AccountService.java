package com.epam.rd.july2019.spring_internet_provider.service;

import com.epam.rd.july2019.spring_internet_provider.dao.AccountDao;
import com.epam.rd.july2019.spring_internet_provider.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements ServiceInterface<Account> {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> queryElements() {
        return accountDao.queryElements();
    }

    @Override
    public Account findElementName(String nameElement) {
        return null;
    }

    @Override
    public Account findElementId(Integer idElement) {
        Account obj = accountDao.findElementId(idElement);
        return obj;
    }

    @Override
    public void updateElement(Account element) {
        accountDao.updateElement(element);
    }

    @Override
    public void insertElement(Account element) {
        accountDao.insertElement(element);
    }

    @Override
    public void deleteElement(Integer idElement) {
        accountDao.deleteElement(idElement);
    }

    public Account findElementNameInt(Long nameElement) {
        Account obj = accountDao.findElementNameInt(nameElement);
        return obj;
    }
}
