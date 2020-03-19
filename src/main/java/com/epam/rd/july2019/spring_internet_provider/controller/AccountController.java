package com.epam.rd.july2019.spring_internet_provider.controller;

import com.epam.rd.july2019.spring_internet_provider.aspects.NameTime;
import com.epam.rd.july2019.spring_internet_provider.models.Account;
import com.epam.rd.july2019.spring_internet_provider.models.BlockedUser;
import com.epam.rd.july2019.spring_internet_provider.models.Subscriber;
import com.epam.rd.july2019.spring_internet_provider.models.Tariff;
import com.epam.rd.july2019.spring_internet_provider.service.*;
import com.epam.rd.july2019.spring_internet_provider.web.dto.SubscriberViewDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private ServiceInterface<Account> accountService;
    @Autowired
    private ServiceInterface<Subscriber> subscriberService;
    @Autowired
    private BlockedUserService blockedUserService;
    @Autowired
    private ServiceInterface<Tariff> tariffService;

    @GetMapping(value = "/accounts")
    @NameTime
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("accountView");
        List<Account> list = accountService.queryElements();
        modelAndView.addObject("accountList", list);
        return modelAndView;
    }

    @GetMapping(value = "/createAccount")
    @NameTime
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("accountCreateView");
        Account account = new Account();
        modelAndView.addObject("accountForm", account);
        return modelAndView;
    }

    @PostMapping(value = "/createAccount")
    @NameTime
    public ModelAndView save(@Valid @ModelAttribute("accountForm") Account account, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new ModelAndView("accountCreateView");
        }
        model.addAttribute("accountName", account.getAccount());
        model.addAttribute("balance", account.getBalance());
        accountService.insertElement(account);
        return new ModelAndView("redirect:/accounts");
    }

    @GetMapping(value = "/editAccount")
    @ResponseBody
    @NameTime
    public ModelAndView find(@RequestParam String idAccount){
        ModelAndView modelAndView = new ModelAndView("accountEditView");
        Account account = accountService.findElementId(Integer.parseInt(idAccount));
        modelAndView.addObject("accountForm", account);
        return modelAndView;
    }

    @PostMapping(value = "/editAccount")
    @NameTime
    public ModelAndView update(@Valid @ModelAttribute("accountForm") Account account, BindingResult result, ModelMap model){
        if (result.hasErrors()) {
            return new ModelAndView("accountEditView");
        }
        accountService.updateElement(account);
        return new ModelAndView("redirect:/accounts");
    }

    @GetMapping(value = "/deleteAccount")
    @ResponseBody
    @NameTime
    public ModelAndView delete(@RequestParam String idAccount){
        accountService.deleteElement(Integer.parseInt(idAccount));
        return new ModelAndView("redirect:/accounts");
    }

    @GetMapping(value = "/accountsUser")
    @NameTime
    public ModelAndView listUser(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("accountUserView");
        HttpSession session = request.getSession(false);
        SubscriberViewDto elementUser = (SubscriberViewDto)session.getAttribute("subscriberSession");
        Integer idSubscriber = elementUser.getId();
        List<Account> elementList = new ArrayList<Account>();
        Subscriber element = subscriberService.findElementId(idSubscriber);
        elementList.add(element.getAccountObject());
        modelAndView.addObject("element", element);
        modelAndView.addObject("accountList", elementList);
        return modelAndView;
    }

    @GetMapping(value = "/editAccountUser")
    @ResponseBody
    @NameTime
    public ModelAndView findUser(@RequestParam String idAccount){
        ModelAndView modelAndView = new ModelAndView("accountEditView");
        Account account = accountService.findElementId(Integer.parseInt(idAccount));
        modelAndView.addObject("accountForm", account);
        return modelAndView;
    }

    @PostMapping(value = "/editAccountUser")
    @NameTime
    public ModelAndView updateUser(@ModelAttribute("accountForm") Account account){
        accountService.updateElement(account);
        findBlockedUser(account.getIdAccount());
        return new ModelAndView("redirect:/accountsUser");
    }

    @NameTime
    private void findBlockedUser(Integer idAccount){
        List<BlockedUser> blockedUsers = new ArrayList<BlockedUser>();
        List<BlockedUser> elementList = blockedUserService.getBlockedElement();
        elementList = elementList.stream().filter(x -> x.getIdBlockedAccount().equals(idAccount))
                .collect(Collectors.toList());
        for(BlockedUser element: elementList) {
            Subscriber subscriber = subscriberService.findElementId(element.getIdBlockedSubscriber());
            boolean blockedUser = subscriber.isBlocked();
            Account account = accountService.findElementId(element.getIdBlockedAccount());
            double balanceUser = account.getBalance();
            Tariff tariff = tariffService.findElementId(element.getIdBlockedTariff());
            double priceUser = tariff.getPrice();
            if (blockedUser) {
                if ((balanceUser - priceUser) >= 0) {
                    balanceUser = (balanceUser - priceUser);
                    blockedUser = false;
                } else {
                    blockedUser = true;
                }
                BlockedUser blockedU = new BlockedUser(subscriber.getIdSubscriber(), blockedUser, priceUser, balanceUser);
                blockedUsers.add(blockedU);
            }
        }
        LOGGER.info(blockedUsers.toString());
        if (blockedUsers.size() > 0) {
            unblockedUser(blockedUsers);
        }
    }

    @NameTime
    private void unblockedUser(List<BlockedUser> blockedUsers){
        for(BlockedUser element: blockedUsers) {
            LOGGER.info(element.toString());
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
            LOGGER.info(account.toString());
        }
    }
}
