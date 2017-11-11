package com.sv.udb.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.udb.dao.LibrosDAO;
import com.sv.udb.modelos.Libros;

@Service
@Transactional
public class LibrosServiceImpl implements LibrosService {
	
	@Autowired
    private LibrosDAO librosDAO;
	
	@Override
	public List<Libros> consTodo() {
		return librosDAO.consTodo();
	}

	@Override
	public void guarLibr(Libros libr) {
		librosDAO.guarLibr(libr);
	}

	@Override
	public void elimLibr(Integer codiLibr) {
		librosDAO.elimLibr(codiLibr);
	}

	@Override
	public Libros actuLibr(Libros libr) {
		return librosDAO.actuLibr(libr);
	}

	@Override
	public Libros consLibr(Integer codiLibr) {
		return librosDAO.consLibr(codiLibr);
	}
	

}
