/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author JMagoSV
 */
@Entity
@Table(name = "libros")
public class Libros implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "codi_libr")
    private Integer codiLibr;
    @Column(name = "nomb_libr")
    private String nombLibr;
    @Column(name = "auto_libr")
    private String autoLibr;
    @Column(name = "gene_libr")
    private String geneLibr;
    @Column(name = "anio_libr")
    private Integer anioLibr;
    @Column(name = "esta_libr")
    private Integer estaLibr;

    public Libros() {
    	
    }

    public Libros(String nombLibr) {
        this.nombLibr = nombLibr;
    }
    
    public Integer getCodiLibr() {
        return codiLibr;
    }

    public void setCodiLibr(Integer codiLibr) {
        this.codiLibr = codiLibr;
    }

    public String getNombLibr() {
        return nombLibr;
    }

    public void setNombLibr(String nombLibr) {
        this.nombLibr = nombLibr;
    }

    public String getAutoLibr() {
        return autoLibr;
    }

    public void setAutoLibr(String autoLibr) {
        this.autoLibr = autoLibr;
    }

    public String getGeneLibr() {
        return geneLibr;
    }

    public void setGeneLibr(String geneLibr) {
        this.geneLibr = geneLibr;
    }

    public Integer getAnioLibr() {
        return anioLibr;
    }

    public void setAnioLibr(Integer anioLibr) {
        this.anioLibr = anioLibr;
    }

    public Integer getEstaLibr() {
        return estaLibr;
    }

    public void setEstaLibr(Integer estaLibr) {
        this.estaLibr = estaLibr;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.Libros[ nombLibr=" + this.nombLibr + " ]";
    }
    
}
