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
public class Ispit {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String tip;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	//@JoinColumn(name = "student_id", referencedColumnName = "student_id")
	@JsonIgnore
	private Student student;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	//@JoinColumn(name = "pohadjanjePredmeta_id", referencedColumnName = "pohadjanjePredmeta_id")
	@JsonIgnore
	private Pohadjanje pohadjanjePredmeta;
	
	@Column
	private int ocena;
	
	@Column
	private float bodovi;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Pohadjanje getPohadjanjePredmeta() {
		return pohadjanjePredmeta;
	}

	public void setPohadjanjePredmeta(Pohadjanje pohadjanjePredmeta) {
		this.pohadjanjePredmeta = pohadjanjePredmeta;
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

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Ispit(long id, String tip, Student student, Pohadjanje pohadjanjePredmeta, int ocena, float bodovi) {
		super();
		this.id = id;
		this.tip = tip;
		this.student = student;
		this.pohadjanjePredmeta = pohadjanjePredmeta;
		this.ocena = ocena;
		this.bodovi = bodovi;
	}

	public Ispit() {
		// TODO Auto-generated constructor stub
	}
	
	

	
}
