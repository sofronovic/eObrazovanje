package com.app.dto;

import com.app.model.Racun;

public class RacunDTO {
	
	private long id;
	private String brojRacuna;
	private String brojModela;
	private String pozivNaBroj;
	private float stanje;
	
	
	
	public RacunDTO(Racun racun){
		id = racun.getId();
		brojRacuna = racun.getBrojRacuna();
		brojModela = racun.getBrojModela();
		pozivNaBroj = racun.getPozivNaBroj();
		stanje = racun.getStanje();
	}
	
	public RacunDTO(){}

	public RacunDTO(long id, String brojRacuna, String brojModela, String pozivNaBroj, float stanje) {
		super();
		this.id = id;
		this.brojRacuna = brojRacuna;
		this.brojModela = brojModela;
		this.pozivNaBroj = pozivNaBroj;
		this.stanje = stanje;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getBrojModela() {
		return brojModela;
	}

	public void setBrojModela(String brojModela) {
		this.brojModela = brojModela;
	}

	public String getPozivNaBroj() {
		return pozivNaBroj;
	}

	public void setPozivNaBroj(String pozivNaBroj) {
		this.pozivNaBroj = pozivNaBroj;
	}

	public float getStanje() {
		return stanje;
	}

	public void setStanje(float stanje) {
		this.stanje = stanje;
	}


	
	
	
	
	
}
