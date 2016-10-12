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
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value="/addSpitter" , method = RequestMethod.GET)
    public String addSpitter(@RequestParam(value="firstName") String firstName , Model model){
        LOG.info("\nRequest comes for adding Spitter");
        Spitter spitter = new Spitter();
        spitter.setFirstName(firstName);
        spitter.setLastName("Rastogi");
        spitter.setUserName(firstName.substring(0,4));
        hibernateDao.saveSpittr(spitter);
        LOG.info("\nSpitter added : "+spitter);
        model.addAttribute("message","Spitter added to table");
        return "default";
    }
}
