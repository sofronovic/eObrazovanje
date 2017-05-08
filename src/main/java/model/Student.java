package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "osoba_id")
public class Student extends Korisnik {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique = true, nullable = false)
	private String indeks;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Dokument> dokumenta = new ArrayList<Dokument>();
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Uplata> uplate = new ArrayList<Uplata>();
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<PohadjanjePredmeta> predmeti = new ArrayList<PohadjanjePredmeta>();
	//manytomany
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Ispit> ispiti =  new ArrayList<Ispit>();
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "studijskiProgram_id", referencedColumnName = "studijskiProgram_id")
	private StudijskiProgram studijskiProgram;

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

	public List<PohadjanjePredmeta> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<PohadjanjePredmeta> predmeti) {
		this.predmeti = predmeti;
	}

	public List<Ispit> getIspiti() {
		return ispiti;
	}

	public void setIspiti(List<Ispit> ispiti) {
		this.ispiti = ispiti;
	}

	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public Student(long id, String ime, String prezime, Date datumRodjenja, String email, long id2, String indeks,
			List<Dokument> dokumenta, List<Uplata> uplate, List<PohadjanjePredmeta> predmeti, List<Ispit> ispiti,
			StudijskiProgram studijskiProgram) {
		super(id, ime, prezime, datumRodjenja, email);
		this.id = id2;
		this.indeks = indeks;
		this.dokumenta = dokumenta;
		this.uplate = uplate;
		this.predmeti = predmeti;
		this.ispiti = ispiti;
		this.studijskiProgram = studijskiProgram;
	}
	
}
	