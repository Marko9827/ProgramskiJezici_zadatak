package singidunum.Projekat2017200219.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

	@Id
	@Column(name = "subject_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String subjectId;
	private String name;
	@Column(name = "year_of_studies")
	private int yearOfStudies;
	private String description;
	private int professorId;
	
	public Subject() {
		super();
	}
	
	public Subject(String subjectId, String name, int yearOfStudies, String description, int professorId) {
		super();
		this.subjectId = subjectId;
		this.name = name;
		this.yearOfStudies = yearOfStudies;
		this.description = description;
		this.professorId = professorId;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfStudies() {
		return yearOfStudies;
	}

	public void setYearOfStudies(int yearOfStudies) {
		this.yearOfStudies = yearOfStudies;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int proffesorId) {
		this.professorId = proffesorId;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", name=" + name + ", yearOfStudies=" + yearOfStudies
				+ ", description=" + description + ", professorId=" + professorId + "]";
	}

   
}