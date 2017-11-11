package com.sv.udb.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sv.udb.modelos.Libros;
import com.sv.udb.servicios.LibrosService;

@Controller
@RequestMapping(value = {"/libros"})
public class LibrosController {
	private static final Logger logger = Logger.getLogger(Libros.class);
	 
    public LibrosController() {
        System.out.println("librsController()");
    }
 
    @Autowired
    private LibrosService librosService;
 
    @RequestMapping(value = "/")
    public ModelAndView listLibr(ModelAndView model) throws IOException {
    	List<Libros> listLibr = librosService.consTodo();
        model.addObject("listLibr", listLibr);
        model.setViewName("libros/home");
        return model;
    }
    
    @RequestMapping(value = "/nuevoLibr", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
    	Libros libr = new Libros();
        model.addObject("objeLibr", libr);
        model.setViewName("libros/librForm");
        return model;
    }
    
    @RequestMapping(value = "/guardarLibr", method = RequestMethod.POST)
    public ModelAndView guarLibr(@ModelAttribute Libros libr) {
        if (libr.getCodiLibr() == null) { // Si es 0 hay que crearlo
        	librosService.guarLibr(libr);
        } else {
        	librosService.actuLibr(libr);
        }
        return new ModelAndView("redirect:/libros/");
    }
    
    @RequestMapping(value = "/editarLibr", method = RequestMethod.GET)
    public ModelAndView editarLibr(HttpServletRequest request) {
        int codiLibr = Integer.parseInt(request.getParameter("codi"));
        Libros libr = librosService.consLibr(codiLibr);
        ModelAndView model = new ModelAndView("libros/librForm");
        model.addObject("objeLibr", libr);
        return model;
    }
    
    @RequestMapping(value = "/eliminarLibr", method = RequestMethod.GET)
    public ModelAndView eliminarLibr(HttpServletRequest request) {
        int codiLibr = Integer.parseInt(request.getParameter("codi"));
        librosService.elimLibr(codiLibr);
        return new ModelAndView("redirect:/libros/");
    }
}
