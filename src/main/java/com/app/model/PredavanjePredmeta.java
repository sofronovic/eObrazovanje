package com.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PredavanjePredmeta {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	//@JoinColumn(name = "predavac_id", referencedColumnName = "predavac_id")
	@JsonIgnore
	private Predavac predavac;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	//@JoinColumn(name = "predmet_id", referencedColumnName = "predmet_id")
	@JsonIgnore
	private Predmet predmet;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Predavac getPredavac() {
		return predavac;
	}

	public void setPredavac(Predavac predavac) {
		this.predavac = predavac;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public PredavanjePredmeta(long id, Predavac predavac, Predmet predmet) {
		super();
		this.id = id;
		this.predavac = predavac;
		this.predmet = predmet;
	}
	public PredavanjePredmeta(){}

}
