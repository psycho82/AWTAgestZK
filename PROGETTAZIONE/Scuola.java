package it.awta.awtagest;

// Generated 8-feb-2011 1.13.48 by Hibernate Tools 3.4.0.CR1

/**
 * Scuola generated by hbm2java
 */
public class Scuola implements java.io.Serializable {

	private Integer scId;
	private String scNome;
	private String scIndirizzo;
	private String scComune;
	private String scProvincia;
	private String scRegione;
	private String scNazione;
	private String scNote;

	public Scuola() {
	}

	public Scuola(String scNome, String scIndirizzo, String scComune,
			String scProvincia, String scRegione, String scNazione,
			String scNote) {
		this.scNome = scNome;
		this.scIndirizzo = scIndirizzo;
		this.scComune = scComune;
		this.scProvincia = scProvincia;
		this.scRegione = scRegione;
		this.scNazione = scNazione;
		this.scNote = scNote;
	}

	public Integer getScId() {
		return this.scId;
	}

	public void setScId(Integer scId) {
		this.scId = scId;
	}

	public String getScNome() {
		return this.scNome;
	}

	public void setScNome(String scNome) {
		this.scNome = scNome;
	}

	public String getScIndirizzo() {
		return this.scIndirizzo;
	}

	public void setScIndirizzo(String scIndirizzo) {
		this.scIndirizzo = scIndirizzo;
	}

	public String getScComune() {
		return this.scComune;
	}

	public void setScComune(String scComune) {
		this.scComune = scComune;
	}

	public String getScProvincia() {
		return this.scProvincia;
	}

	public void setScProvincia(String scProvincia) {
		this.scProvincia = scProvincia;
	}

	public String getScRegione() {
		return this.scRegione;
	}

	public void setScRegione(String scRegione) {
		this.scRegione = scRegione;
	}

	public String getScNazione() {
		return this.scNazione;
	}

	public void setScNazione(String scNazione) {
		this.scNazione = scNazione;
	}

	public String getScNote() {
		return this.scNote;
	}

	public void setScNote(String scNote) {
		this.scNote = scNote;
	}
}
