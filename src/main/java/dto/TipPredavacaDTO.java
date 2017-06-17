package dto;

import model.TipPredavaca;

public class TipPredavacaDTO {
	
	private long id;
	private String naziv;
	
	public TipPredavacaDTO(TipPredavaca tipPredavaca){
		id = tipPredavaca.getId();
		naziv = tipPredavaca.getNaziv();
	}
	
	public TipPredavacaDTO() {}

	public TipPredavacaDTO(long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}

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
	
	
	
}
