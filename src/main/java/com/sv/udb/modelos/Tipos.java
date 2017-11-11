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
@Table(name = "tipos")
public class Tipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "codi_tipo")
    private Integer codi_tipo;
    @Column (name = "nomb_tipo")
    private String nomb_tipo;

    public Tipos() {
    }

    public Integer getCodi_tipo() {
		return codi_tipo;
	}


	public void setCodi_tipo(Integer codi_tipo) {
		this.codi_tipo = codi_tipo;
	}


	public String getNomb_tipo() {
		return nomb_tipo;
	}


	public void setNomb_tipo(String nomb_tipo) {
		this.nomb_tipo = nomb_tipo;
	}
    
    public String toString() {
        return "com.sv.udb.modelos.Tipos[ codi_tipo=" + codi_tipo + " ]";
    }
    
}
