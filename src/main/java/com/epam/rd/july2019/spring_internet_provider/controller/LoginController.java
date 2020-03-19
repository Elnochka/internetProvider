package com.epam.rd.july2019.spring_internet_provider.controller;

import com.epam.rd.july2019.spring_internet_provider.aspects.NameTime;
import com.epam.rd.july2019.spring_internet_provider.service.SubscriberService;
import com.epam.rd.july2019.spring_internet_provider.web.dto.SubscriberViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private SubscriberService subscriberService;

    @GetMapping()
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @PostMapping()
    @NameTime
    public ModelAndView loginUser(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        SubscriberViewDto subscriberViewDto = subscriberService.login(name);
        HttpSession session = request.getSession(true);
        session.setAttribute("subscriberSession", subscriberViewDto);
        if (subscriberViewDto.getName().equals("Administrator")) {
            return new ModelAndView("homePage");
        } else {
            return new ModelAndView("userPage");
        }
    }
}
