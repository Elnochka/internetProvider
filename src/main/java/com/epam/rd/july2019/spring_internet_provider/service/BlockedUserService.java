package com.epam.rd.july2019.spring_internet_provider.service;

import com.epam.rd.july2019.spring_internet_provider.dao.BlockedUserDao;
import com.epam.rd.july2019.spring_internet_provider.models.BlockedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockedUserService {

    @Autowired
    private BlockedUserDao blockedUserDao;

    public List<BlockedUser> getBlockedElement(){
        return blockedUserDao.getBlockedElement();

    }

}
