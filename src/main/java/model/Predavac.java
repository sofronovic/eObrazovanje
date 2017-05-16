package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
public class Predavac extends Korisnik{
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "tipPredavaca_id", referencedColumnName = "tipPredavaca_id")
	private TipPredavaca tipPredavaca;

	@OneToMany(mappedBy = "predavac", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<PredavanjePredmeta> listaPredmeta = new ArrayList<PredavanjePredmeta>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Predavac(long id, String ime, String prezime, Date datumRodjenja, String email, long id2,
			TipPredavaca tipPredavaca, List<PredavanjePredmeta> listaPredmeta) {
		super(id, ime, prezime, datumRodjenja, email);
		id = id2;
		this.tipPredavaca = tipPredavaca;
		this.listaPredmeta = listaPredmeta;
	}

	public Predavac(){
		
	}
	
	
	
	
}
