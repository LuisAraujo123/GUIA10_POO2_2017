package com.sv.udb.servicios;

import java.util.List;

import com.sv.udb.modelos.Tipos;

public interface TiposService {
	public void guarTipo(Tipos tipo);	 
    public List<Tipos> consTodo(); 
    public void elimTipo(Integer codiTipo); 
    public Tipos actuTipo(Tipos tipo); 
    public Tipos consTipo(int codiTipo);
}
