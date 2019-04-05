package com.task.urlMinimizator.controllers;

import com.task.urlMinimizator.beans.Url;
import com.task.urlMinimizator.service.UrlServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;
import java.util.List;

@Controller
@RequestMapping(value = "/urls")
public class UrlController {
    private static final String PAGE_JSP = "index";
    private final UrlServiceInf urlServiceInf;

    @Autowired
    public UrlController(UrlServiceInf urlServiceInf) {
        this.urlServiceInf = urlServiceInf;
    }

    @RequestMapping(value = "/addUrl", method = RequestMethod.POST)
    public ModelAndView addUrl(@RequestParam("url")String url, @RequestParam("countOfDays") int count,
                                @RequestParam("isActive") boolean isActive, HttpServletRequest request) throws UnknownHostException {
        ModelAndView result = new ModelAndView(PAGE_JSP);
        urlServiceInf.createUrl(url, count, isActive, request.getHeader("User-Agent"));

        return result;
    }

    @RequestMapping(value = "/deleteUrl", method = RequestMethod.DELETE)
    public ModelAndView removeUrl(@ModelAttribute("url") Url url) {
        ModelAndView result = new ModelAndView(PAGE_JSP);
        urlServiceInf.deleteUrl(url);

        return result;
    }


    @RequestMapping(value = "/updateUrl", method = RequestMethod.PUT)
    public ModelAndView updateUrl(@ModelAttribute("url")Url url) {
        ModelAndView result = new ModelAndView(PAGE_JSP);
        urlServiceInf.updateUrl(url);

        return result;
    }

    @GetMapping
    public ModelAndView getUrlInfo(@ModelAttribute("url") Url url) {
        ModelAndView result = new ModelAndView(PAGE_JSP);
        if (url != null) {
            result.addObject("url", url);
        }

        return result;
    }

    @GetMapping(value = "/viewAllUrls")
    public ModelAndView viewAllUsers() {
        ModelAndView result = new ModelAndView();
        List<Url> urlList = urlServiceInf.getAllUrls();

        result.addObject("urls", urlList);
        result.setViewName(PAGE_JSP);

        return result;
    }

}
