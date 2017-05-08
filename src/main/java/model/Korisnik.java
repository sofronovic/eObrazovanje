package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn
public abstract class Korisnik {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true, nullable = false)
	private String userName;
	@Column
	private String password;
	@Column
	private String ime;
	@Column
	private String prezime;
	@Column
	private Date datumRodjenja;
	@Column
	private String email;
	@Column
	private boolean isAdmin;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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



	public Date getDatumRodjenja() {
		return datumRodjenja;
	}



	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Korisnik(long id, String ime, String prezime, Date datumRodjenja, String email) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.email = email;
	}

	public Korisnik() {
		super();
	}

	
	
}
