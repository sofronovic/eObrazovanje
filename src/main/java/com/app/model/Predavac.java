package com.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("Predavac")
@PrimaryKeyJoinColumn(name = "id")
public class Predavac extends Korisnik{
	
/*	@Id
	@GeneratedValue
	private Long predavac_id;*/
	
	@ManyToOne
	@JsonIgnore
	private TipPredavaca tipPredavaca;

	@OneToMany(mappedBy = "predavac", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<PredavanjePredmeta> listaPredmeta = new ArrayList<PredavanjePredmeta>();

/*	public long getId() {
		return predavac_id;
	}

	public void setId(long id) {
		this.predavac_id = id;
	}*/

	public TipPredavaca getTipPredavaca() {
		return tipPredavaca;
	}

	public void setTipPredavaca(TipPredavaca tipPredavaca) {
		this.tipPredavaca = tipPredavaca;
	}


	public List<PredavanjePredmeta> getListaPredmeta() {
		return listaPredmeta;
	}

	public void setListaPredmeta(List<PredavanjePredmeta> listaPredmeta) {
		this.listaPredmeta = listaPredmeta;
	}

	

	public Predavac(String userName, String password, String ime, String prezime, Date datumRodjenja, String email) {
		super(userName, password, ime, prezime, email);
		// TODO Auto-generated constructor stub
	}

	public Predavac(String userName, String password, String ime, String prezime, Date datumRodjenja, String email,
			TipPredavaca tipPredavaca, List<PredavanjePredmeta> listaPredmeta) {
		super(userName, password, ime, prezime, email);
		this.tipPredavaca = tipPredavaca;
		this.listaPredmeta = listaPredmeta;
	}

	public Predavac(){
		
	}
	
	
	
	
}
