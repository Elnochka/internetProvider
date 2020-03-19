package com.epam.rd.july2019.spring_internet_provider.controller;

import com.epam.rd.july2019.spring_internet_provider.aspects.NameTime;
import com.epam.rd.july2019.spring_internet_provider.models.Tariff;
import com.epam.rd.july2019.spring_internet_provider.service.ServiceInterface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class TariffController {

    @Autowired
    private ServiceInterface<Tariff> tariffService;
    @Autowired
    private ServletContext context;

    private static final Logger LOGGER = LoggerFactory.getLogger(TariffController.class);

    @GetMapping(value = "/tariffs")
    @ResponseBody
    @NameTime
    public ModelAndView list(@RequestParam Map<String,String> allParams){
        ModelAndView modelAndView = new ModelAndView("tariffView");
        List<Tariff> list = tariffService.queryElements();
        if (allParams.get("sorting") != null) {
            list = getSortList(list, allParams.get("sorting"));
        }
        modelAndView.addObject("sortList", allParams.get("sorting"));
        modelAndView.addObject("tariffList", list);
        return modelAndView;
    }

    @GetMapping(value = "/createTariff")
    @NameTime
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("tariffCreateView");
        Tariff tariff = new Tariff();
        modelAndView.addObject("tariffForm", tariff);
        return modelAndView;
    }

    @PostMapping(value = "/createTariff")
    @NameTime
    public ModelAndView save(@Valid @ModelAttribute("tariffForm") Tariff tariff, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new ModelAndView("tariffCreateView");
        }
        model.addAttribute("tariffName", tariff.getNameTariff());
        model.addAttribute("price", tariff.getPrice());
        model.addAttribute("pathFile", tariff.getPathFile());
        tariffService.insertElement(tariff);
        return new ModelAndView("redirect:/tariffs");
    }

    @GetMapping(value = "/editTariff")
    @ResponseBody
    @NameTime
    public ModelAndView find(@RequestParam String idTariff){
        ModelAndView modelAndView = new ModelAndView("tariffEditView");
        Tariff tariff = tariffService.findElementId(Integer.parseInt(idTariff));
        modelAndView.addObject("tariffForm", tariff);
        return modelAndView;
    }

    @PostMapping(value = "/editTariff")
    @NameTime
    public ModelAndView update(@Valid @ModelAttribute("tariffForm") Tariff tariff, BindingResult result, ModelMap model){
        if (result.hasErrors()) {
            return new ModelAndView("tariffEditView");
        }
        tariffService.updateElement(tariff);
        return new ModelAndView("redirect:/tariffs");
    }

    @GetMapping(value = "/deleteTariff")
    @ResponseBody
    @NameTime
    public ModelAndView delete(@RequestParam String idTariff){
        tariffService.deleteElement(Integer.parseInt(idTariff));
        return new ModelAndView("redirect:/tariffs");
    }

    @GetMapping(value = "/downloadFile")
    @ResponseBody
    @NameTime
    public ModelAndView download(@RequestParam String idTariff, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Tariff element = tariffService.findElementId(Integer.parseInt(idTariff));
        if(element == null) {
            return new ModelAndView("redirect:/tariffs");
        }
        String fileNameRead = element.getPathFile();
        Path fileRead = Paths.get(fileNameRead);
        if (!Files.isRegularFile(fileRead)) {
            LOGGER.info("A file is not exist!");
        }
        String mimeType = context.getMimeType(fileNameRead);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setContentLengthLong(Files.size(fileRead));
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", fileRead.getFileName());
        response.setHeader(headerKey, headerValue);
        FileInputStream inStream = new FileInputStream(fileNameRead);
        OutputStream outStream = response.getOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        inStream.close();
        outStream.close();
        return new ModelAndView("redirect:/tariffs");


    }

//    @GetMapping(value = "/downloadFile")
//    @ResponseBody
//    public ModelAndView uploadFileHandler(@RequestParam String idTariff) throws IOException {
////                             @RequestParam("file") MultipartFile file) {
//        Tariff element = tariffService.findElementId(Integer.parseInt(idTariff));
//        if(element == null) {
//            return new ModelAndView("redirect:/tariffs");
//        }
//        String fileNameRead = element.getPathFile();
////        Path fileRead = Paths.get(fileNameRead);
////        File file = new File("src/test/resources/input.txt");
//        FileInputStream input = new FileInputStream(fileNameRead);
//        MultipartFile file = new MockMultipartFile(fileNameRead, input);
//
//////        Path path = Paths.get("/path/to/the/file.txt");
//////        String name = "file.txt";
//////        String originalFileName = "file.txt";
////        String contentType = "text/plain";
////        Long content = null;
////        try {
////            content = Files.size(fileRead);
////        } catch (final IOException e) {
////        }
////        MultipartFile file = new MockMultipartFile(fileNameRead,
////                fileNameRead, contentType, content);
//
////        MultipartFile file = fileRead;
//
//        if (!file.isEmpty()) {
////            try {
//                byte[] bytes = file.getBytes();
//
//                // Creating the directory to store file
////                String rootPath = System.getProperty("catalina.home");
////                File dir = new File(rootPath + File.separator + "tmpFiles");
////                if (!dir.exists())
////                    dir.mkdirs();
////
////                // Create the file on server
////                File serverFile = new File(dir.getAbsolutePath()
////                        + File.separator + name);
//                BufferedOutputStream stream = new BufferedOutputStream(
//                        new FileOutputStream(fileNameRead));
//                stream.write(bytes);
//                stream.close();
//
////                logger.info("Server File Location="
////                        + serverFile.getAbsolutePath());
//
//                return new ModelAndView("redirect:/tariffs");
////            } catch (Exception e) {
////                return new ModelAndView("redirect:/tariffs");
////            }
//        } else {
//            return new ModelAndView("redirect:/tariffs");
////            return "You failed to upload " + name
////                    + " because the file was empty.";
//        }
//    }

    @NameTime
    private List<Tariff> getSortList(List<Tariff> tariffList, String sortList){

        Comparator<Tariff> maxPrice = (o1, o2) -> {
            return (Double.compare(o2.getPrice(), o1.getPrice()));
        };
        Comparator<Tariff> minPrice = (o1, o2) -> {
            return (Double.compare(o1.getPrice(), o2.getPrice()));
        };
        Comparator<Tariff> nameSortA = (o1, o2) -> {
            return (o1.getNameTariff().compareTo(o2.getNameTariff()));
        };
        Comparator<Tariff> nameSortZ = (o1, o2) -> {
            return (o2.getNameTariff().compareTo(o1.getNameTariff()));
        };

        if ("maxPrice".equals(sortList)) {
            tariffList = tariffList.stream()
                    .sorted(maxPrice)
                    .collect(Collectors.toList());
        }

        if ("minPrice".equals(sortList)) {
            tariffList = tariffList.stream()
                    .sorted(minPrice)
                    .collect(Collectors.toList());
        }

        if ("sortAz".equals(sortList)) {
            tariffList = tariffList.stream()
                    .sorted(nameSortA)
                    .collect(Collectors.toList());
        }

        if ("sortZa".equals(sortList)) {
            tariffList = tariffList.stream()
                    .sorted(nameSortZ)
                    .collect(Collectors.toList());
        }

        return tariffList;
    }
}
