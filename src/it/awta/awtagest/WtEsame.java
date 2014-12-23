package it.awta.awtagest;

// Generated 15-mar-2011 0.22.01 by Hibernate Tools 3.4.0.CR1

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * WtEsame generated by hbm2java
 */
public class WtEsame implements java.io.Serializable {

	private int esId;
	private Soggetto soggetto;
	private String esAttestato;
	private String esGrado;
	private Date esData;
	private String esInsSifu;
	private String esCitta;
	private SimpleDateFormat formatter = new SimpleDateFormat("EEE dd MMMM yyyy");

	public WtEsame() {
	}

	public WtEsame(int esId, Soggetto soggetto) {
		this.esId = esId;
		this.soggetto = soggetto;
	}

	public WtEsame(int esId, Soggetto soggetto, String esAttestato,
			String esGrado, Date esData, String esInsSifu, String esCitta) {
		this.esId = esId;
		this.soggetto = soggetto;
		this.esAttestato = esAttestato;
		this.esGrado = esGrado;
		this.esData = esData;
		this.esInsSifu = esInsSifu;
		this.esCitta = esCitta;
	}

	public int getEsId() {
		return this.esId;
	}

	public void setEsId(int esId) {
		this.esId = esId;
	}

	public Soggetto getSoggetto() {
		return this.soggetto;
	}

	public void setSoggetto(Soggetto soggetto) {
		this.soggetto = soggetto;
	}

	public String getEsAttestato() {
		return this.esAttestato;
	}

	public void setEsAttestato(String esAttestato) {
		this.esAttestato = esAttestato;
	}

	public String getEsGrado() {
		return this.esGrado;
	}

	public void setEsGrado(String esGrado) {
		this.esGrado = esGrado;
	}

	public Date getEsData() {
		return this.esData;
	}
	public String getEsDataString() {
		return formatter.format(this.esData);
	}
	public void setEsData(Date esData) {
		this.esData = esData;
	}

	public String getEsInsSifu() {
		return this.esInsSifu;
	}

	public void setEsInsSifu(String esInsSifu) {
		this.esInsSifu = esInsSifu;
	}

	public String getEsCitta() {
		return this.esCitta;
	}

	public void setEsCitta(String esCitta) {
		this.esCitta = esCitta;
	}

}