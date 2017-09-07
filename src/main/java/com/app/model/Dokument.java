package com.app.model;

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
public class Dokument {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String naziv;
	
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

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Dokument(long id, String naziv, Student student) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.student = student;
	}

	public Dokument() {
		// TODO Auto-generated constructor stub
	}
	
}
