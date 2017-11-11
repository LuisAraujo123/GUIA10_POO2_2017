package com.sv.udb.controladores;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/home"})
public class LoginController {
	
	@RequestMapping(value = "/")
	public ModelAndView home(ModelAndView model) throws IOException {
		model.setViewName("home/index");
		return model;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView model) throws IOException {
		model.setViewName("home/login");
		return model;
	}
	
	@RequestMapping(value = "/denegado")
	public ModelAndView denegado(ModelAndView model) throws IOException {
		model.setViewName("home/denegado");
		return model;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null)
		{
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/home/";
	}
	
	
}
