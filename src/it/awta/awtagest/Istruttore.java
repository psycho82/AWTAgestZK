package it.awta.awtagest;

// Generated 15-mar-2011 0.22.01 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Istruttore generated by hbm2java
 */
public class Istruttore implements java.io.Serializable {

	private Integer istId;
	private String istNome;
	private String istCognome;
	private String istGrado;
	private Set<Soggetto> soggettos = new HashSet<Soggetto>(0);

	public Istruttore() {
	}

	public Istruttore(String istGrado) {
		this.istGrado = istGrado;
	}

	public Istruttore(String istNome, String istCognome, String istGrado,
			Set<Soggetto> soggettos) {
		this.istNome = istNome;
		this.istCognome = istCognome;
		this.istGrado = istGrado;
		this.soggettos = soggettos;
	}

	public Integer getIstId() {
		return this.istId;
	}

	public void setIstId(Integer istId) {
		this.istId = istId;
	}

	public String getIstNome() {
		return this.istNome;
	}

	public void setIstNome(String istNome) {
		this.istNome = istNome;
	}

	public String getIstCognome() {
		return this.istCognome;
	}

	public void setIstCognome(String istCognome) {
		this.istCognome = istCognome;
	}

	public String getIstGrado() {
		return this.istGrado;
	}

	public void setIstGrado(String istGrado) {
		this.istGrado = istGrado;
	}

	public Set<Soggetto> getSoggettos() {
		return this.soggettos;
	}

	public void setSoggettos(Set<Soggetto> soggettos) {
		this.soggettos = soggettos;
	}

}