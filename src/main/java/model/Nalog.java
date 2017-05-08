package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Nalog {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = true)
	private boolean admin;
	
	@OneToOne
	@JoinColumn(name = "student_id", referencedColumnName = "student_id")
	private Student student;

	@OneToOne
	@JoinColumn(name = "predavac_id", referencedColumnName = "predavac_id")
	private Predavac predavac;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Predavac getPredavac() {
		return predavac;
	}

	public void setPredavac(Predavac predavac) {
		this.predavac = predavac;
	}

	public Nalog(long id, String username, String password, boolean admin, Student student, Predavac predavac) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.admin = admin;
		this.student = student;
		this.predavac = predavac;
	}
}
