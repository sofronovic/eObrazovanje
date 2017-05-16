package dto;

import model.PredavanjePredmeta;

public class PredavanjePredmetaDTO {
	
	private long id;
	private PredavacDTO predavac;
	private PredmetDTO predmet;
	
	public PredavanjePredmetaDTO(){}
	
	public PredavanjePredmetaDTO(PredavanjePredmeta pp){
		id = pp.getId();
		predavac = new PredavacDTO(pp.getPredavac());
		predmet = new PredmetDTO(pp.getPredmet());
	}

	public PredavanjePredmetaDTO(long id, PredavacDTO predavac, PredmetDTO predmet) {
		super();
		this.id = id;
		this.predavac = predavac;
		this.predmet = predmet;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PredavacDTO getPredavac() {
		return predavac;
	}

	public void setPredavac(PredavacDTO predavac) {
		this.predavac = predavac;
	}

	public PredmetDTO getPredmet() {
		return predmet;
	}

	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}
	
	
	
	
	
}
