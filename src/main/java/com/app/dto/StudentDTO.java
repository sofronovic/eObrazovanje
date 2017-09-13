package com.app.dto;

import java.util.Date;

import com.app.model.Student;

public class StudentDTO {
	
	private long id;
	private String indeks;
	private String userName;
	private String password;
	private String ime;
	private String prezime;
	private String email;
	
	public StudentDTO(Student student){
		super();
		this.id = student.getId();
		this.indeks = student.getIndeks();
		this.userName = student.getUserName();
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

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", indeks=" + indeks + ", userName=" + userName + ", password=" + password
				+ ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + "]";
	}

	
	

}
