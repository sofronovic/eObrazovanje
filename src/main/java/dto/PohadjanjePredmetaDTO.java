package dto;

import model.PohadjanjePredmeta;
import model.Predmet;

public class PohadjanjePredmetaDTO {
	
	private long id;
	private StudentDTO student;
	private PredmetDTO predmet;
	
	public PohadjanjePredmetaDTO(PohadjanjePredmeta p){
		id = p.getId();
		student = new StudentDTO(p.getStudent());
		predmet = new PredmetDTO(p.getPredmet());
	}
	
	public PohadjanjePredmetaDTO(){}

	public PohadjanjePredmetaDTO(long id, StudentDTO student, PredmetDTO predmet) {
		super();
		this.id = id;
		this.student = student;
		this.predmet = predmet;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public PredmetDTO getPredmet() {
		return predmet;
	}

	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}
	

	

}
