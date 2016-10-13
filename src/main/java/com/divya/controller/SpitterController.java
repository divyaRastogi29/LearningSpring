package com.divya.controller;

import com.divya.dao.HibernateDaoImpl;
import com.divya.model.Spitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by divya on 9/10/16.
 */

@Controller
@RequestMapping("/spitters")
public class SpitterController {

    private HibernateDaoImpl hibernateDao ;
    private static final Logger LOG = LoggerFactory.getLogger(SpitterController.class);

    @Autowired
    public SpitterController(HibernateDaoImpl hibernateDao){
        this.hibernateDao = hibernateDao ;
    }

    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String showRegistrationForm(){
        return "registerForm" ;
    }

    @RequestMapping(value="/addSpitter" , method = RequestMethod.POST)
    public String addSpitter(HttpServletRequest request, Model model){
        LOG.info("\nRequest comes for adding Spitter");
        Spitter spitter = new Spitter();
        spitter.setFirstName(request.getParameter("firstName"));
        spitter.setLastName(request.getParameter("lastName"));
        spitter.setUserName(request.getParameter("username"));
        spitter.setPassword(request.getParameter("password"));
        hibernateDao.saveSpittr(spitter);
        LOG.info("\nSpitter added : "+spitter);
        model.addAttribute("message","Spitter added to table");
        return "default";
    }
}
