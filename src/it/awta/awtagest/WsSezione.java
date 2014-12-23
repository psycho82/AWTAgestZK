package it.awta.awtagest;

// Generated 15-mar-2011 0.22.01 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * WsSezione generated by hbm2java
 */
public class WsSezione implements java.io.Serializable {

	private int wssezId;
	private Sezione sezione;
	private Soggetto soggetto;
	private String wssezAttestato;
	private String wssezGrado;
	private Date wssezData;
	private String wssezInsSifu;
	private String wssezCitta;

	public WsSezione() {
	}

	public WsSezione(int wssezId) {
		this.wssezId = wssezId;
	}

	public WsSezione(int wssezId, Sezione sezione, Soggetto soggetto,
			String wssezAttestato, String wssezGrado, Date wssezData,
			String wssezInsSifu, String wssezCitta) {
		this.wssezId = wssezId;
		this.sezione = sezione;
		this.soggetto = soggetto;
		this.wssezAttestato = wssezAttestato;
		this.wssezGrado = wssezGrado;
		this.wssezData = wssezData;
		this.wssezInsSifu = wssezInsSifu;
		this.wssezCitta = wssezCitta;
	}

	public int getWssezId() {
		return this.wssezId;
	}

	public void setWssezId(int wssezId) {
		this.wssezId = wssezId;
	}

	public Sezione getSezione() {
		return this.sezione;
	}

	public void setSezione(Sezione sezione) {
		this.sezione = sezione;
	}

	public Soggetto getSoggetto() {
		return this.soggetto;
	}

	public void setSoggetto(Soggetto soggetto) {
		this.soggetto = soggetto;
	}

	public String getWssezAttestato() {
		return this.wssezAttestato;
	}

	public void setWssezAttestato(String wssezAttestato) {
		this.wssezAttestato = wssezAttestato;
	}

	public String getWssezGrado() {
		return this.wssezGrado;
	}

	public void setWssezGrado(String wssezGrado) {
		this.wssezGrado = wssezGrado;
	}

	public Date getWssezData() {
		return this.wssezData;
	}

	public void setWssezData(Date wssezData) {
		this.wssezData = wssezData;
	}

	public String getWssezInsSifu() {
		return this.wssezInsSifu;
	}

	public void setWssezInsSifu(String wssezInsSifu) {
		this.wssezInsSifu = wssezInsSifu;
	}

	public String getWssezCitta() {
		return this.wssezCitta;
	}

	public void setWssezCitta(String wssezCitta) {
		this.wssezCitta = wssezCitta;
	}

}
