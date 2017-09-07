package com.app.dto;

import com.app.model.Ispit;

public class IspitDTO {
	
	private long id;
	private String tip;
	private int ocena;
	private float bodovi;
	private StudentDTO student;
	private PohadjanjePredmetaDTO pohadjanjePredmeta;
	
	public IspitDTO(){}
	
	public IspitDTO(Ispit ispit){
		id = ispit.getId();
		tip = ispit.getTip();
		ocena = ispit.getOcena();
		bodovi = ispit.getBodovi();
		student = new StudentDTO(ispit.getStudent());
		pohadjanjePredmeta = new PohadjanjePredmetaDTO(ispit.getPohadjanjePredmeta());
		
	}
	
	public IspitDTO(long id, String tip, int ocena, float bodovi) {
		super();
		this.id = id;
		this.tip = tip;
		this.ocena = ocena;
		this.bodovi = bodovi;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public float getBodovi() {
		return bodovi;
	}

	public void setBodovi(float bodovi) {
		this.bodovi = bodovi;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public PohadjanjePredmetaDTO getPohadjanjePredmeta() {
		return pohadjanjePredmeta;
	}

	public void setPohadjanjePredmeta(PohadjanjePredmetaDTO pohadjanjePredmeta) {
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}
	
	

}
