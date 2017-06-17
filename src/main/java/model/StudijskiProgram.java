package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class StudijskiProgram {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String naziv;
	
	@Column
	private int trajanje;
	
	@Column
	private String tipKursa;
	
	@OneToMany(mappedBy = "studijskiProgram", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Student> listaStudenata = new ArrayList<Student>();

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
	

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public String getTipKursa() {
		return tipKursa;
	}

	public void setTipKursa(String tipKursa) {
		this.tipKursa = tipKursa;
	}

	public List<Student> getListaStudenata() {
		return listaStudenata;
	}

	public void setListaStudenata(List<Student> listaStudenata) {
		this.listaStudenata = listaStudenata;
	}

	public StudijskiProgram(long id, String naziv, int trajanje, String tipKursa, List<Student> listaStudenata) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.trajanje = trajanje;
		this.tipKursa = tipKursa;
		this.listaStudenata = listaStudenata;
	}

	
	public StudijskiProgram() {}
}
