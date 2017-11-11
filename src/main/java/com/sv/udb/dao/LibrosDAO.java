package com.sv.udb.dao;

import java.util.List;

import com.sv.udb.modelos.Libros;

public interface LibrosDAO {
	public void guarLibr(Libros libr);
	public List<Libros> consTodo();
	public void elimLibr(Integer codiLibr);
	public Libros actuLibr(Libros libr);
	public Libros consLibr(int codiLibr);
}
