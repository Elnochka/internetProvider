package com.epam.rd.july2019.spring_internet_provider.controller;

import com.epam.rd.july2019.spring_internet_provider.aspects.NameTime;
import com.epam.rd.july2019.spring_internet_provider.models.Account;
import com.epam.rd.july2019.spring_internet_provider.models.Subscriber;
import com.epam.rd.july2019.spring_internet_provider.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SubscriberController {

    @Autowired
    private ServiceInterface<Subscriber> subscriberService;

    @Autowired
    private ServiceInterface<Account> accountService;

    @GetMapping(value = "/subscribers")
    @NameTime
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("subscriberView");
        List<Subscriber> list = subscriberService.queryElements();
        modelAndView.addObject("subscriberList", list);
        return modelAndView;
    }

    @GetMapping(value = "/createSubscriber")
    @NameTime
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("subscriberCreateView");
        Subscriber subscriber = new Subscriber();
        List<Account> listAccount = accountService.queryElements();
        modelAndView.addObject("listAccount", listAccount);
        modelAndView.addObject("subscriberForm", subscriber);
        return modelAndView;
    }

    @PostMapping(value = "/createSubscriber")
    @NameTime
    public ModelAndView save(@Valid @ModelAttribute("subscriberForm") Subscriber subscriber, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new ModelAndView("subscriberCreateView");
        }
        model.addAttribute("subscriberName", subscriber.getNameSubscriber());
        model.addAttribute("account", subscriber.getAccount());
        model.addAttribute("blocked", subscriber.isBlocked());
        subscriberService.insertElement(subscriber);
        return new ModelAndView("redirect:/subscribers");
    }

    @GetMapping(value = "/editSubscriber")
    @ResponseBody
    @NameTime
    public ModelAndView find(@RequestParam String idSubscriber){
        ModelAndView modelAndView = new ModelAndView("subscriberEditView");
        Subscriber subscriber = subscriberService.findElementId(Integer.parseInt(idSubscriber));
        List<Account> listAccount = accountService.queryElements();
        modelAndView.addObject("listAccount", listAccount);
        modelAndView.addObject("subscriberForm", subscriber);
        return modelAndView;
    }

    @PostMapping(value = "/editSubscriber")
    @NameTime
    public ModelAndView update(@Valid @ModelAttribute("subscriberForm") Subscriber subscriber, BindingResult result, ModelMap model){
        if (result.hasErrors()) {
            return new ModelAndView("subscriberEditView");
        }
        subscriberService.updateElement(subscriber);
        return new ModelAndView("redirect:/subscribers");
    }

    @GetMapping(value = "/deleteSubscriber")
    @ResponseBody
    @NameTime
    public ModelAndView delete(@RequestParam String idSubscriber){
        subscriberService.deleteElement(Integer.parseInt(idSubscriber));
        return new ModelAndView("redirect:/subscribers");
    }
}
