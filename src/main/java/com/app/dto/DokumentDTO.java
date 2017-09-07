package com.app.dto;

import com.app.model.Dokument;

public class DokumentDTO {
	
	private long id;
	private String naziv;
	private StudentDTO student;
	
	public DokumentDTO(Dokument dokument){
		id = dokument.getId();
		naziv = dokument.getNaziv();
		student = new StudentDTO(dokument.getStudent());
	}
	
	public DokumentDTO(){}
	
	public DokumentDTO(long id, String naziv, StudentDTO student) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.student = student;
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

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	
	

}
