package singidunum.Projekat2017200219.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students_t")
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String studentsId;
    private String forename;
    private String surname;
    private String jmbg;
    private int index;
    private String predmet_name;
    private String Fakultet;

    public Student() {
        super();
    }

    public Student(String studentsId, String forename, String surname, String jmbg, int index, String predmet_name, String fakultet) {
        super();
        this.studentsId = studentsId;
        this.forename = forename;
        this.surname = surname;
        this.jmbg = jmbg;
        this.index = index;
        this.predmet_name = predmet_name;
        this.Fakultet = Fakultet;
    }

    public String getStudentsId() {
        return studentsId;
    }

    public void setStudentsId(String studentsId) {
        this.studentsId = studentsId;
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getPredmet_name() {
        return predmet_name;
    }

    public void setPredmet_name(String predmet_name) {
        this.predmet_name = predmet_name;
    }

    public String getFaks() {
        return Fakultet;
    }

    public void setFaks(String Fakultet) {
        this.Fakultet = Fakultet;
    }

    @Override
    public String toString() {
        return "Students [" + "studentsId=" + studentsId + ", forename=" + forename + ", surname=" + surname + ", jmbg=" + jmbg + ", index=" + index + ", predmet_name=" + predmet_name + ", Fakultet=" + Fakultet + "]";
    }

}
