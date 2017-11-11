package com.sv.udb.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sv.udb.dao.TiposDAO;
import com.sv.udb.dao.TiposDAOImpl;
import com.sv.udb.modelos.Tipos;

public class TestTipos {

	@Autowired
    private TiposDAO tiposDAO;

	@Test
	@Transactional
	public void testTipos() {
		Tipos objeTipo = new Tipos();
		objeTipo.setNomb_tipo("Desde Test");
		TiposDAOImpl obje = new TiposDAOImpl();
		obje.guarTipo(objeTipo);
	}

}
