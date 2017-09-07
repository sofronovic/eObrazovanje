package com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "korisnik")
public abstract class Korisnik {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true, nullable = false)
	private String userName;
	@Column
	private String password;
	@Column
	private String ime;
	@Column
	private String prezime;
/*	@Column
	private Date datumRodjenja;*/
	@Column
	private String email;
	
	

	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getIme() {
		return ime;
	}



	public void setIme(String ime) {
		this.ime = ime;
	}



	public String getPrezime() {
		return prezime;
	}



	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


/*
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}



	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}*/



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Korisnik(String userName, String password,String ime, String prezime, String email) {
		super();
		this.userName = userName;
		this.password= password;
		this.ime = ime;
		this.prezime = prezime;
//		this.datumRodjenja = datumRodjenja;
		this.email = email;
	}

	public Korisnik() {
		super();
	}

	
	
}
