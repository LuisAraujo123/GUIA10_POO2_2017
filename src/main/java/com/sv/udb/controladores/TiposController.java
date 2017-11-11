package com.sv.udb.controladores;

import java.io.Console;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sv.udb.modelos.Tipos;
import com.sv.udb.servicios.TiposService;

@Controller
@RequestMapping(value = {"/tipos"})
public class TiposController {
	private static final Logger logger = Logger.getLogger(Tipos.class);
 
    public TiposController() {
        System.out.println("TiposController()");
    }
 
    @Autowired
    private TiposService tiposService;
 
    @RequestMapping(value = "/")
    public ModelAndView listTipos(ModelAndView model) throws IOException {
    	List<Tipos> listTipo = tiposService.consTodo();
        model.addObject("listTipo", listTipo);
        model.setViewName("tipos/home");
        return model;
    }
    
    @RequestMapping(value = "/nuevoTipo", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
    	Tipos tipo = new Tipos();
        model.addObject("objeTipo", tipo);
        model.setViewName("tipos/tipoForm");
        return model;
    }
    
    @RequestMapping(value = "/guardarTipo", method = RequestMethod.POST)
    public ModelAndView guarTipo(@ModelAttribute Tipos tipo) {
        if (tipo.getCodi_tipo() == null) { // Si es 0 hay que crearlo
        	tiposService.guarTipo(tipo);
        } else {
        	tiposService.actuTipo(tipo);
        }
        return new ModelAndView("redirect:/tipos/");
    }
    
    @RequestMapping(value = "/editarTipo", method = RequestMethod.GET)
    public ModelAndView editarTipo(HttpServletRequest request) {
        int codi_tipo = Integer.parseInt(request.getParameter("codi"));
        Tipos tipo = tiposService.consTipo(codi_tipo);
        ModelAndView model = new ModelAndView("tipos/tipoForm");
        model.addObject("objeTipo", tipo);
        return model;
    }
    
    @RequestMapping(value = "/eliminarTipo", method = RequestMethod.GET)
    public ModelAndView eliminarTipo(HttpServletRequest request) {
        int codi_tipo = Integer.parseInt(request.getParameter("codi"));
        tiposService.elimTipo(codi_tipo);
        return new ModelAndView("redirect:/tipos/");
    }
}
