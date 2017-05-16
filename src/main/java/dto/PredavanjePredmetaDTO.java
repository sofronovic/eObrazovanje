package dto;

import model.PredavanjePredmeta;

public class PredavanjePredmetaDTO {

	private long id;
	//private PredavacDTO predavac;
	private PredmetDTO predmet;
	
	public PredavanjePredmetaDTO(PredavanjePredmeta p)
	{
		id = p.getId();
		//predavac = new PredavacDTO(p.getPredavac());
		predmet = new PredmetDTO(p.getPredmet());
	}
	
	public PredavanjePredmetaDTO(){}

	public PredavanjePredmetaDTO(long id, PredmetDTO predmet) {
		super();
		this.id = id;
		this.predmet = predmet;
		//this.predavac = predavac;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PredmetDTO getPredmet() {
		return predmet;
	}

	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}
	
	
	
}
