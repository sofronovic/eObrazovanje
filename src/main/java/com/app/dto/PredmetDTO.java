package com.app.dto;

import com.app.model.Predmet;

public class PredmetDTO {
	
	private long id;
	private String oznaka;
	private String naziv;
	private int ECTS;
	
	public PredmetDTO(Predmet predmet){
		id = predmet.getId();
		oznaka = predmet.getOznaka();
		naziv = predmet.getNaziv();
		ECTS = predmet.getECTS();
	}
	
	public PredmetDTO(){}
	
	public PredmetDTO(long id, String oznaka, String naziv, int ECTS) {
		super();
		this.id = id;
		this.oznaka = oznaka;
		this.naziv = naziv;
		this.ECTS = ECTS;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getECTS() {
		return ECTS;
	}

	public void setECTS(int eCTS) {
		ECTS = eCTS;
	}
	
	

}
