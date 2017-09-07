package com.app.dto;
import java.util.Date;

import com.app.model.Uplata;

public class UplataDTO {
	
	private long id;
	private String opis;
	private Date datum;
	private String iznos;
	private StudentDTO student;
	
	
	public UplataDTO(Uplata uplata)
	{
		id = uplata.getId();
		opis = uplata.getOpis();
		datum = uplata.getDatum();
		iznos = uplata.getIznos();
		student = new StudentDTO(uplata.getStudent());
	}
	
	public UplataDTO(){}

	public UplataDTO(long id, String opis, Date datum, String iznos, StudentDTO student) {
		super();
		this.id = id;
		this.opis = opis;
		this.datum = datum;
		this.iznos = iznos;
		this.student = student;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getIznos() {
		return iznos;
	}

	public void setIznos(String iznos) {
		this.iznos = iznos;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	

}
