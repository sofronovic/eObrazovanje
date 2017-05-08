package dto;

import model.Student;

public class StudentDTO {
	
	private long id;
	private String indeks;
	
	public StudentDTO(Student student){
		id = student.getId();
		indeks = student.getIndeks();
	}
	
	public StudentDTO() {}

	public StudentDTO(long id, String indeks) {
		super();
		this.id = id;
		this.indeks = indeks;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIndeks() {
		return indeks;
	}
	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}
	
	

}
