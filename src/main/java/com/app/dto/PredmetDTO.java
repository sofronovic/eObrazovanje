package com.app.dto;

import com.app.model.Predmet;

public class PredmetDTO {
	
	private Long id;
	private String oznaka;
	private String naziv;
	private int ects;
	private StudijskiProgramDTO studijskiProgram;
	
	public PredmetDTO(Predmet predmet){
		id = predmet.getId();
		oznaka = predmet.getOznaka();
		naziv = predmet.getNaziv();
		ects = predmet.getECTS();
		studijskiProgram = new StudijskiProgramDTO(predmet.getStudijskiProgram());
	}
	
	public PredmetDTO(){}
	
	public PredmetDTO(Long id, String oznaka, String naziv, int ECTS, StudijskiProgramDTO studijskiProgram) {
		super();
		this.id = id;
		this.oznaka = oznaka;
		this.naziv = naziv;
		this.ects = ECTS;
		this.studijskiProgram = studijskiProgram;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		return ects;
	}

	public void setECTS(int ECTS) {
		this.ects = ECTS;
	}

	public StudijskiProgramDTO getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgramDTO studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}
	
	

}
