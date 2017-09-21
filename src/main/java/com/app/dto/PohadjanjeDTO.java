package com.app.dto;

import com.app.model.Pohadjanje;
import com.app.model.Predmet;
import com.app.model.StudijskiProgram;

public class PohadjanjeDTO {
	
	private long id;
	private StudentDTO student;
	private StudijskiProgramDTO studijskiProgram;
	
	public PohadjanjeDTO(Pohadjanje p){
		id = p.getId();
		student = new StudentDTO(p.getStudent());
		studijskiProgram = new StudijskiProgramDTO(p.getStudijskiProgram());
	}
	
	public PohadjanjeDTO(){}

	public PohadjanjeDTO(long id, StudentDTO student, StudijskiProgramDTO studijskiProgram) {
		super();
		this.id = id;
		this.student = student;
		this.studijskiProgram = studijskiProgram;
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

	public StudijskiProgramDTO getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgramDTO studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}
	
	
	

	

}
