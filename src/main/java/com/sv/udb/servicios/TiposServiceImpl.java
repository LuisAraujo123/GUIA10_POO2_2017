package com.sv.udb.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sv.udb.dao.TiposDAO;
import com.sv.udb.modelos.Tipos;

@Service
@Transactional
public class TiposServiceImpl implements TiposService {
	
	@Autowired
    private TiposDAO tiposDAO;
	
	@Override
	public void guarTipo(Tipos tipo) {
		tiposDAO.guarTipo(tipo);		
	}

	@Override
	public List<Tipos> consTodo() {
		return tiposDAO.consTodo();
	}

	@Override
	public void elimTipo(Integer codiTipo) {
		tiposDAO.elimTipo(codiTipo);
		
	}

	@Override
	public Tipos actuTipo(Tipos tipo) {
		return tiposDAO.actuTipo(tipo);
	}

	@Override
	public Tipos consTipo(int codiTipo) {
		return tiposDAO.consTipo(codiTipo);
	}
	

}
