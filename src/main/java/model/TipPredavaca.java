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
public class TipPredavaca {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String naziv;
	
	@OneToMany(mappedBy = "tipPredavaca", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Predavac> listaPredavaca = new ArrayList<Predavac>();

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

	public List<Predavac> getListaPredavaca() {
		return listaPredavaca;
	}

	public void setListaPredavaca(List<Predavac> listaPredavaca) {
		this.listaPredavaca = listaPredavaca;
	}

	public TipPredavaca(long id, String naziv, List<Predavac> listaPredavaca) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.listaPredavaca = listaPredavaca;
	}
	
	public TipPredavaca() {}
	
}
