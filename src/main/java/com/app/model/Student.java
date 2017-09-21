package com.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("student")
public class Student extends Korisnik {
	
	@Id
	@GeneratedValue
	private Long id;
	
	//@Column(unique = true, nullable = false)
	private String indeks;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Dokument> dokumenta = new ArrayList<Dokument>();
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Uplata> uplate = new ArrayList<Uplata>();
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Pohadjanje> pohadjanja = new ArrayList<Pohadjanje>(); 

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Ispit> ispiti =  new ArrayList<Ispit>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public List<Dokument> getDokumenta() {
		return dokumenta;
	}

	public void setDokumenta(List<Dokument> dokumenta) {
		this.dokumenta = dokumenta;
	}

	public List<Uplata> getUplate() {
		return uplate;
	}

	public void setUplate(List<Uplata> uplate) {
		this.uplate = uplate;
	}

	public List<Pohadjanje> getPohadjanja() {
		return pohadjanja;
	}

	public void setPredmeti(List<Pohadjanje> pohadjanja) {
		this.pohadjanja = pohadjanja;
	}

	public List<Ispit> getIspiti() {
		return ispiti;
	}

	public void setIspiti(List<Ispit> ispiti) {
		this.ispiti = ispiti;
	}

	

	public Student(String userName, String password, String ime, String prezime, String email) {
		super(userName, password, ime, prezime, email);
		// TODO Auto-generated constructor stub
	}

	public Student() {
		
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", indeks=" + indeks + ", dokumenta=" + dokumenta + ", uplate=" + uplate
				+ ", pohadjanja=" + pohadjanja + ", ispiti=" + ispiti +  "]";
	}
	
	
}
	