package com.app.dto;

import java.util.Date;

import com.app.model.Student;

public class StudentDTO {
	
	private long id;
	private String indeks;
	private String username;
	private String password;
	private String ime;
	private String prezime;
	private String email;
	
	public StudentDTO(Student student){
		super();
		this.id = student.getId();
		this.indeks = student.getIndeks();
		this.username = student.getEmail();
		this.password = student.getPassword();
		this.ime = student.getIme();
		this.prezime = student.getPrezime();
		this.email = student.getEmail();
	}
	
	public StudentDTO() {}

	public StudentDTO(long id, String indeks) {
		super();
		this.id = id;
		this.indeks = indeks;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIndeks() {
		return indeks;
	}
	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	

}
