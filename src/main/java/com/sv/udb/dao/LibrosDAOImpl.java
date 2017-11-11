package com.sv.udb.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sv.udb.modelos.Libros;

@Repository
public class LibrosDAOImpl implements LibrosDAO {
	@Autowired
    private SessionFactory sessionFactory;
	public void guarLibr(Libros libr) {
		sessionFactory.getCurrentSession().saveOrUpdate(libr);
	}

	@SuppressWarnings("unchecked")
	public List<Libros> consTodo() {
		return sessionFactory.getCurrentSession().createQuery("from Libros").list();
	}

	public void elimLibr(Integer codiLibr) {
		Libros libr = (Libros) sessionFactory.getCurrentSession().load(
				Libros.class, codiLibr);
        if (null != libr) {
            this.sessionFactory.getCurrentSession().delete(libr);
        }
	}

	public Libros actuLibr(Libros libr) {
		sessionFactory.getCurrentSession().update(libr);
        return libr;
	}

	public Libros consLibr(int codiLibr) {
		return (Libros) sessionFactory.getCurrentSession().get(
				Libros.class, codiLibr);
	}

}