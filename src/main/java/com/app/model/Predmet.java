package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Predmet {
	
	@GeneratedValue
	@Id
	private long id;

	@Column
	private String oznaka;
	
	@Column
	private String naziv;
	
	@Column
	private int ects;

	@ManyToOne
	@JsonIgnore
	private StudijskiProgram studijskiProgram;
	
	@OneToMany(mappedBy = "predmet", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<PredavanjePredmeta> predavanjePredmeta = new ArrayList<PredavanjePredmeta>();;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOznaka() {
		return oznaka;
	}
	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getECTS() {
		return ects;
	}
	public void setECTS(int ECTS) {
		this.ects = ECTS;
	}

	public List<PredavanjePredmeta> getPredavanjePredmeta() {
		return predavanjePredmeta;
	}
	public void setPredavanjePredmeta(List<PredavanjePredmeta> predavanjePredmeta) {
		this.predavanjePredmeta = predavanjePredmeta;
	}
	
	
	
	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}
	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}
	public Predmet(long id, String oznaka, String naziv, int ECTS, List<Pohadjanje> pohadjanjePredmeta,
			List<PredavanjePredmeta> predavanjePredmeta, StudijskiProgram studijskiProgram) {
		super();
		this.id = id;
		this.oznaka = oznaka;
		this.naziv = naziv;
		this.ects = ECTS;
		this.predavanjePredmeta = predavanjePredmeta;
		this.studijskiProgram = studijskiProgram;
	}
	public Predmet(long id, String oznaka, String naziv, int ECTS, StudijskiProgram studijskiProgram,
			List<PredavanjePredmeta> predavanjePredmeta) {
		super();
		this.id = id;
		this.oznaka = oznaka;
		this.naziv = naziv;
		this.ects = ECTS;
		this.studijskiProgram = studijskiProgram;
		this.predavanjePredmeta = predavanjePredmeta;
	}
	
	public Predmet(){}
	@Override
	public String toString() {
		return "Predmet [id=" + id + ", oznaka=" + oznaka + ", naziv=" + naziv + ", ECTS=" + ects
				+ ", studijskiProgram=" + studijskiProgram + ", predavanjePredmeta=" + predavanjePredmeta + "]";
	}
	
	
}
