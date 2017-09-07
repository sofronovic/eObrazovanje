package com.app.dto;

import com.app.model.Student;
import com.app.model.StudijskiProgram;

public class StudijskiProgramDTO {

	private long id;
	private String naziv;
	private int trajanje;
	private String tipKursa;
	
	public StudijskiProgramDTO(StudijskiProgram studijskiProgram){
		id = studijskiProgram.getId();
		naziv = studijskiProgram.getNaziv();
		trajanje = studijskiProgram.getTrajanje();
		tipKursa = studijskiProgram.getTipKursa();
	}

	public StudijskiProgramDTO(){}

	public StudijskiProgramDTO(long id, String naziv, int trajanje, String tipKursa) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.trajanje = trajanje;
		this.tipKursa = tipKursa;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public String getTipKursa() {
		return tipKursa;
	}

	public void setTipKursa(String tipKursa) {
		this.tipKursa = tipKursa;
	}
	
	
	
}
