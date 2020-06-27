package singidunum.Projekat2017200219.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {

	@Id
	@Column(name = "professor_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String professorId;
	private String forename;  
	private String surname;
	private String jmbg;
	private String salary;
	private String email;
	
	public Professor() {
		super();
	}

	public Professor(String professorId, String forename, String surname, String jmbg, String salary, String email) {
		super();
		this.professorId = professorId;
		this.forename = forename;
		this.surname = surname;
		this.jmbg = jmbg;
		this.salary = salary;
		this.email = email;
	}

	public String getProfessorId() {
		return professorId;
	}

	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Professor [" + "professorId=" + professorId + ", forename=" + forename + ", surname=" + surname + ", jmbg="
				+ jmbg + ", salary=" + salary + ", email=" + email + "]";
	}		
}