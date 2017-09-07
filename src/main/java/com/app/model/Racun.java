package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Racun {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String brojRacuna;
	
	@Column
	private String brojModela;
	
	@Column
	private String pozivNaBroj;
	
	@Column
	private float stanje;

	public Racun(long id, String brojRacuna, String brojModela, String pozivNaBroj, float stanje) {
		super();
		this.id = id;
		this.brojRacuna = brojRacuna;
		this.brojModela = brojModela;
		this.pozivNaBroj = pozivNaBroj;
		this.stanje = stanje;
	}
	
	public Racun(){}
	
	@Override
	public String toString() {
		return "Racun [id=" + id + ", brojRacuna=" + brojRacuna + ", brojModela=" + brojModela + ", pozivNaBroj="
				+ pozivNaBroj + ", stanje=" + stanje + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getBrojModela() {
		return brojModela;
	}

	public void setBrojModela(String brojModela) {
		this.brojModela = brojModela;
	}

	public String getPozivNaBroj() {
		return pozivNaBroj;
	}

	public void setPozivNaBroj(String pozivNaBroj) {
		this.pozivNaBroj = pozivNaBroj;
	}

	public float getStanje() {
		return stanje;
	}

	public void setStanje(float stanje) {
		this.stanje = stanje;
	}
	
	
	
	
}
