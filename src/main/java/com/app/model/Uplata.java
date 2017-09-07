package com.app.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Uplata {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String opis;
	
	@Column
	private Date datum;
	
	@Column
	private String iznos;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	//@JoinColumn(name = "student_id", referencedColumnName = "student_id")
	@JsonIgnore
	private Student student;
	
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Uplata(long id, String opis, Date datum, String iznos, Student student) {
		super();
		this.id = id;
		this.opis = opis;
		this.datum = datum;
		this.iznos = iznos;
		this.student = student;
	}

	public Uplata(){}
	
}
