package com.divya.controller;

import com.divya.data.SpittleRepository;
import com.divya.model.Spittle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by divya on 28/9/16.
 */

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository ;
    private static final Logger LOG = LoggerFactory.getLogger(SpittleController.class);

    @Autowired
    public SpittleController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(@RequestParam(value = "max",defaultValue = "999999999") long max,
                           @RequestParam(value = "count", defaultValue = "20") int count, Model model){
        LOG.info("\nRequest comes to GET spittles");
        List<Spittle> spittles = spittleRepository.findSpittles(max , count);
        model.addAttribute("spittleList", spittles);
        LOG.info("\nList of Spittles is as follows : "+spittles);
        return "spittles" ;

    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittle(@RequestParam("spittleId") long spittleId, Model model){
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

    @RequestMapping(value = {"/{spittleId}"},method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId , Model model){
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

    @RequestMapping(value="/count", method = RequestMethod.GET)
    public String count(Model model){
        model.addAttribute("count",spittleRepository.spittleCount());
        return "count";
    }

    @RequestMapping(value = "/addSpittle" , method = RequestMethod.GET)
    public String addSpittle(@RequestParam(value = "message") String message , Model model){
        spittleRepository.addSpittle(message);
        model.addAttribute("message",message);
        return "default";
    }

    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String showRegistrationForm(){
        return "registerForm" ;
    }

    /*@RequestMapping(value = "/register" , method = RequestMethod.POST)
    public String processRegistration(@Validated Spitter spitter , Errors errors) {

        if(errors.hasErrors())
            return "registerForm" ;
        spittleRepository.saveSpittr(spitter);
        return "redirect:/spittles/"+ spitter.getUserName();
    }

    @RequestMapping(value = "/{username}" , method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username , Model model){
        Spitter spitter = spittleRepository.findByUserName(username);
        model.addAttribute("spitter" , spitter) ;
        return "profile" ;
    }*/

}
