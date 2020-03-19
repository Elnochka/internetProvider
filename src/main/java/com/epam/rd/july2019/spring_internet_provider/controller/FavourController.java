package com.epam.rd.july2019.spring_internet_provider.controller;

import com.epam.rd.july2019.spring_internet_provider.aspects.NameTime;
import com.epam.rd.july2019.spring_internet_provider.models.Favour;
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
public class FavourController {

    @Autowired
    private ServiceInterface<Favour> favourService;

    @GetMapping(value = "/favours")
    @NameTime
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("favourView");
        List<Favour> list = favourService.queryElements();
        modelAndView.addObject("favourList", list);
        return modelAndView;
    }

    @GetMapping(value = "/createFavour")
    @NameTime
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("favourCreateView");
        Favour favour = new Favour();
        modelAndView.addObject("favourForm", favour);
        return modelAndView;
    }

    @PostMapping(value = "/createFavour")
    @NameTime
    public ModelAndView save(@Valid @ModelAttribute("favourForm") Favour favour, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
           return new ModelAndView("favourCreateView");
        }
        model.addAttribute("favourName", favour.getNameFavour());
        favourService.insertElement(favour);
        return new ModelAndView("redirect:/favours");
    }

    @GetMapping(value = "/editFavour")
    @ResponseBody
    @NameTime
    public ModelAndView find(@RequestParam String idFavour){
        ModelAndView modelAndView = new ModelAndView("favourEditView");
        Favour favour = favourService.findElementId(Integer.parseInt(idFavour));

        modelAndView.addObject("favourForm", favour);
        return modelAndView;
    }

    @PostMapping(value = "/editFavour")
    @NameTime
    public ModelAndView update(@Valid @ModelAttribute("favourForm") Favour favour, BindingResult result, ModelMap model){
        if (result.hasErrors()) {
            return new ModelAndView("favourEditView");
        }
        favourService.updateElement(favour);
        return new ModelAndView("redirect:/favours");
    }

    @GetMapping(value = "/deleteFavour")
    @ResponseBody
    @NameTime
    public ModelAndView delete(@RequestParam String idFavour){
        favourService.deleteElement(Integer.parseInt(idFavour));
        return new ModelAndView("redirect:/favours");
    }

}
