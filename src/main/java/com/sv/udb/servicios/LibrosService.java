package com.sv.udb.servicios;

import java.util.List;

import com.sv.udb.modelos.Libros;

public interface LibrosService {
	public void guarLibr(Libros libr);
	public List<Libros> consTodo();
	public void elimLibr(Integer codiLibr);
	public Libros actuLibr(Libros libr);
	public Libros consLibr(Integer codiLibr);
	
}
