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
public class Pohadjanje {
	
	@Id
	@GeneratedValue
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	//@JoinColumn(name = "student_id", referencedColumnName = "student_id")
	@JsonIgnore
	private Student student;
	
/*	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	//@JoinColumn(name = "predmet_id", referencedColumnName = "predmet_id")
	@JsonIgnore
	private Predmet predmet;*/
	
	@ManyToOne
	@JsonIgnore
	private StudijskiProgram studijskiProgram;
	

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
	
	

	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public Pohadjanje(long id, Student student, StudijskiProgram studijskiProgram) {
		super();
		this.id = id;
		this.student = student;
		this.studijskiProgram = studijskiProgram;
	}
	
	
}
