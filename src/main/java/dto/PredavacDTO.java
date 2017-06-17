package dto;

import model.Predavac;

public class PredavacDTO {
	
	private long id;
	private TipPredavacaDTO tipPredavaca;
	
	public PredavacDTO(Predavac predavac){
		id = predavac.getId();
		tipPredavaca = new PredavacDTO(predavac.getTipPredavaca());
	}
	
	public PredavacDTO(){}

	public PredavacDTO(long id, TipPredavacaDTO tipPredavaca) {
		super();
		this.id = id;
		this.tipPredavaca = tipPredavaca;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TipPredavacaDTO getTipPredavaca() {
		return tipPredavaca;
	}

	public void setTipPredavaca(TipPredavacaDTO tipPredavaca) {
		this.tipPredavaca = tipPredavaca;
	}
	
	
}
