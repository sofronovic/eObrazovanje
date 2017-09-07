package com.app.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("Admin")
@PrimaryKeyJoinColumn(name = "id")
public class Administrator extends Korisnik {

	@Id
	@GeneratedValue
	private Long id;



	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Administrator(String userName, String password, String ime, String prezime,
			String email) {
		super(userName, password, ime, prezime, email);
		// TODO Auto-generated constructor stub
	}



	public Administrator(String userName, String password, String ime, String prezime, String email,
			Long id) {
		super(userName, password, ime, prezime, email);
		this.id = id;
	}

	
}
