package com.epam.rd.july2019.spring_internet_provider.controller;

import com.epam.rd.july2019.spring_internet_provider.aspects.NameTime;
import com.epam.rd.july2019.spring_internet_provider.models.Favour;
import com.epam.rd.july2019.spring_internet_provider.models.Subscriber;
import com.epam.rd.july2019.spring_internet_provider.models.Tariff;
import com.epam.rd.july2019.spring_internet_provider.models.TariffFavour;
import com.epam.rd.july2019.spring_internet_provider.service.*;
import com.epam.rd.july2019.spring_internet_provider.web.dto.SubscriberViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TariffFavourController {

    @Autowired
    private TariffFavourService tariffFavourService;
    @Autowired
    private ServiceInterface<Subscriber> subscriberService;
    @Autowired
    private ServiceInterface<Tariff> tariffService;
    @Autowired
    private ServiceInterface<Favour> favourService;

    @GetMapping(value = "/tariffFavours")
    @NameTime
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("tariffFavourView");
        List<TariffFavour> list = tariffFavourService.queryElements();
        modelAndView.addObject("tariffFavourList", list);
        return modelAndView;
    }

    @GetMapping(value = "/createTariffFavour")
    @NameTime
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("tariffFavourCreateView");
        TariffFavour tariffFavour = new TariffFavour();
        List<Subscriber> subscriberList = subscriberService.queryElements();
        List<Tariff> tariffList = tariffService.queryElements();
        List<Favour> favourList = favourService.queryElements();
        modelAndView.addObject("tariffList", tariffList);
        modelAndView.addObject("favourList", favourList);
        modelAndView.addObject("subscriberList", subscriberList);
        modelAndView.addObject("tariffFavourForm", tariffFavour);
        return modelAndView;
    }

    @PostMapping(value = "/createTariffFavour")
    @NameTime
    public ModelAndView save(@ModelAttribute("tariffFavourForm") TariffFavour tariffFavour, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new ModelAndView("errorView");
        }
        model.addAttribute("tariffId", tariffFavour.getIdTariff());
        model.addAttribute("subscriberId", tariffFavour.getIdSubscriber());
        model.addAttribute("favourId", tariffFavour.getIdFavour());
        tariffFavourService.insertElement(tariffFavour);
        return new ModelAndView("redirect:/tariffFavours");
    }

    @GetMapping(value = "/deleteTariffFavour")
    @ResponseBody
    @NameTime
    public ModelAndView delete(@RequestParam String idTariffFavour, HttpServletRequest request){
        tariffFavourService.deleteElement(Integer.parseInt(idTariffFavour));
        HttpSession session = request.getSession(false);
        SubscriberViewDto elementUser = (SubscriberViewDto)session.getAttribute("subscriberSession");
        if ("Administrator".equals(elementUser.getName())) {
            return new ModelAndView("redirect:/tariffFavours");
        }
        else {
            return new ModelAndView("redirect:/tariffFavoursUser");
        }
    }

    @RequestMapping (value = "/tariffFavoursUser")
    @NameTime
    public ModelAndView listUser(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("tariffFavourUserView");
        HttpSession session = request.getSession(false);
        SubscriberViewDto elementUser = (SubscriberViewDto)session.getAttribute("subscriberSession");
        Integer idSubscriber = elementUser.getId();
        List<TariffFavour> elementList = tariffFavourService.queryElementsUser(idSubscriber);
        modelAndView.addObject("tariffFavourListUser", elementList);
        return modelAndView;
    }

    @GetMapping(value = "/createTariffFavourUser")
    @NameTime
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("tariffFavourCreateUserView");
        TariffFavour tariffFavour = new TariffFavour();
        HttpSession session = request.getSession(false);
        SubscriberViewDto elementUser = (SubscriberViewDto)session.getAttribute("subscriberSession");
        Integer idSubscriber = elementUser.getId();
        List<Subscriber> subscriberList = new ArrayList<Subscriber>();
        Subscriber subscriber = subscriberService.findElementId(idSubscriber);
        subscriberList.add(subscriber);
        List<Tariff> tariffList = tariffService.queryElements();
        List<Favour> favourList = favourService.queryElements();
        modelAndView.addObject("tariffList", tariffList);
        modelAndView.addObject("favourList", favourList);
        modelAndView.addObject("subscriberList", subscriberList);
        modelAndView.addObject("tariffFavourForm", tariffFavour);
        return modelAndView;
    }

    @PostMapping(value = "/createTariffFavourUser")
    @NameTime
    public ModelAndView saveUser(@ModelAttribute("tariffFavourForm") TariffFavour tariffFavour, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new ModelAndView("errorView");
        }
        model.addAttribute("tariffId", tariffFavour.getIdTariff());
        model.addAttribute("subscriberId", tariffFavour.getIdSubscriber());
        model.addAttribute("favourId", tariffFavour.getIdFavour());
        tariffFavourService.insertElement(tariffFavour);
        return new ModelAndView("redirect:/tariffFavoursUser");
    }
}
