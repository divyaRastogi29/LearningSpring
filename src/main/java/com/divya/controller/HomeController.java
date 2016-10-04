package com.divya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping({"/","/homepage"})
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String test(HttpServletResponse response) throws IOException{
		return  "home";
	}
}
