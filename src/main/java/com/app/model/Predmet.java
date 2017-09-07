package com.app.model;

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
public class Predmet {
	
	@GeneratedValue
	@Id
	private long id;

	@Column
	private String oznaka;
	
	@Column
	private String naziv;
	
	@Column
	private int ECTS;
	
	@OneToMany(mappedBy = "predmet", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<PohadjanjePredmeta> pohadjanjePredmeta = new ArrayList<PohadjanjePredmeta>();
	
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
		return ECTS;
	}
	public void setECTS(int eCTS) {
		ECTS = eCTS;
	}
	public List<PohadjanjePredmeta> getPohadjanjePredmeta() {
		return pohadjanjePredmeta;
	}
	public void setPohadjanjePredmeta(List<PohadjanjePredmeta> pohadjanjePredmeta) {
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}
	public List<PredavanjePredmeta> getPredavanjePredmeta() {
		return predavanjePredmeta;
	}
	public void setPredavanjePredmeta(List<PredavanjePredmeta> predavanjePredmeta) {
		this.predavanjePredmeta = predavanjePredmeta;
	}
	public Predmet(long id, String oznaka, String naziv, int eCTS, List<PohadjanjePredmeta> pohadjanjePredmeta,
			List<PredavanjePredmeta> predavanjePredmeta) {
		super();
		this.id = id;
		this.oznaka = oznaka;
		this.naziv = naziv;
		this.ECTS = eCTS;
		this.pohadjanjePredmeta = pohadjanjePredmeta;
		this.predavanjePredmeta = predavanjePredmeta;
	}
	
	

}
