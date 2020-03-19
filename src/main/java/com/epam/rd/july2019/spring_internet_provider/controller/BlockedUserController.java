package com.epam.rd.july2019.spring_internet_provider.controller;

import com.epam.rd.july2019.spring_internet_provider.aspects.NameTime;
import com.epam.rd.july2019.spring_internet_provider.models.Account;
import com.epam.rd.july2019.spring_internet_provider.models.BlockedUser;
import com.epam.rd.july2019.spring_internet_provider.models.Subscriber;
import com.epam.rd.july2019.spring_internet_provider.models.Tariff;
import com.epam.rd.july2019.spring_internet_provider.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/blockedUser")
public class BlockedUserController {

    @Autowired
    private BlockedUserService blockedUserService;
    @Autowired
    private ServiceInterface<Subscriber> subscriberService;
    @Autowired
    private ServiceInterface<Account> accountService;
    @Autowired
    private ServiceInterface<Tariff> tariffService;

    @PostMapping
    @NameTime
    public ModelAndView blocked(){
        List<BlockedUser> elementList = getListBlockedUser();
        loadBlockedUser(elementList);
        return new ModelAndView("homePage");
    }

    @NameTime
    private List<BlockedUser> getListBlockedUser(){
        List<BlockedUser> blockedUsers = new ArrayList<BlockedUser>();
        List<BlockedUser> elementList = blockedUserService.getBlockedElement();
        for(BlockedUser element: elementList){
            Subscriber subscriber = subscriberService.findElementId(element.getIdBlockedSubscriber());
            boolean blockedUser = subscriber.isBlocked();
            Account account = accountService.findElementId(element.getIdBlockedAccount());
            double balanceUser = account.getBalance();
            Tariff tariff = tariffService.findElementId(element.getIdBlockedTariff());
            double priceUser = tariff.getPrice();
            if ((balanceUser - priceUser) >= 0 ){
                balanceUser = (balanceUser - priceUser);
                blockedUser = false;
            } else {
                blockedUser = true;
            }
            BlockedUser blockedU = new BlockedUser(subscriber.getIdSubscriber(), blockedUser, priceUser, balanceUser);
            blockedUsers.add(blockedU);
        }
        return blockedUsers;
    }

    @NameTime
    private void loadBlockedUser(List<BlockedUser> blockedUsers){
        for(BlockedUser element: blockedUsers) {
            Subscriber subscriber = subscriberService.findElementId(element.getIdBlockedSubscriber());
            subscriber.setBlocked(element.isUserBlocked());
            subscriber.setIdSubscriber(subscriber.getIdSubscriber());
            subscriber.setAccount(subscriber.getAccountObject().getIdAccount());
            subscriber.setNameSubscriber(subscriber.getNameSubscriber());
            subscriber.setAccountObject(subscriber.getAccountObject());
            Account account = accountService.findElementId(subscriber.getAccountObject().getIdAccount());
            account.setIdAccount(subscriber.getAccountObject().getIdAccount());
            account.setAccount(subscriber.getAccountObject().getAccount());
            account.setBalance(element.getUserBalance());
            accountService.updateElement(account);
            subscriberService.updateElement(subscriber);
        }
    }
}
