package com.epam.rd.july2019.spring_internet_provider.controller;

import com.epam.rd.july2019.spring_internet_provider.aspects.NameTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/logout")
public class LogoutController {

    @GetMapping()
    @NameTime
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return new ModelAndView("index");
    }
}
