package com.sv.udb.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sv.udb.modelos.Tipos;

@Repository
public class TiposDAOImpl implements TiposDAO {
	@Autowired
    private SessionFactory sessionFactory;
	public void guarTipo(Tipos tipo) {
		sessionFactory.getCurrentSession().saveOrUpdate(tipo);
	}

	@SuppressWarnings("unchecked")
	public List<Tipos> consTodo() {
		return sessionFactory.getCurrentSession().createQuery("from Tipos").list();
	}

	public void elimTipo(Integer codiTipo) {
		Tipos tipo = (Tipos) sessionFactory.getCurrentSession().load(
				Tipos.class, codiTipo);
        if (null != tipo) {
            this.sessionFactory.getCurrentSession().delete(tipo);
        }
	}

	public Tipos actuTipo(Tipos tipo) {
		sessionFactory.getCurrentSession().update(tipo);
        return tipo;
	}

	public Tipos consTipo(int codiTipo) {
		return (Tipos) sessionFactory.getCurrentSession().get(
				Tipos.class, codiTipo);
	}

}
