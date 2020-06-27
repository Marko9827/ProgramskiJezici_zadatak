package singidunum.Projekat2017200219.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import singidunum.Projekat2017200219.entity.Student;
import singidunum.Projekat2017200219.repository.StudentRepository;

@RestController
public class StudensController {

    @Autowired
    private StudentRepository repository;

    @CrossOrigin
    @GetMapping("/studenti")
    public List<Student> getAllStudents() {
        return (List<Student>) repository.findAll();
    }

    @CrossOrigin
    @GetMapping("/studenti/{id}")
    public List<Student> getOneStudent(@PathVariable String id) {
        List<Student> studentsList = new ArrayList<>();
        for (Student s : repository.findAll()) {
            if (s.getStudentsId().toLowerCase().contentEquals(id.toLowerCase())) {
                studentsList.add(s);
            }
        }
        return studentsList;
    }

    @CrossOrigin
    @GetMapping("/studenti/jmbg/{jmbg}")
    public List<Student> getOneStudentByJmbg(@PathVariable String jmbg) {
        List<Student> studentList = new ArrayList<>();
        for (Student s : repository.findAll()) {
            if (s.getJmbg().toLowerCase().contentEquals(jmbg.toLowerCase())) {
                studentList.add(s);
            }
        }
        return studentList;
    }

    @CrossOrigin
    @GetMapping("/studenti/id/{id}")
    public List<Student> getOneStudentById(@PathVariable String id) {
        List<Student> studentList = new ArrayList<>();
        for (Student s : repository.findAll()) {
            if (s.getStudentsId().toLowerCase().contentEquals(id.toLowerCase())) {
                studentList.add(s);
            }
        }
        return studentList;
    }
    
     @CrossOrigin
    @GetMapping("/studenti/ime/{ime}")
    public List<Student> getOneStudentByName(@PathVariable String ime) {
        List<Student> studentList = new ArrayList<>();
        for (Student s : repository.findAll()) {
            if (s.getForename().toLowerCase().contentEquals(ime.toLowerCase())) {
                studentList.add(s);
            }
        }
        return studentList;
    }

    @CrossOrigin
    @GetMapping("/studenti/prezime/{prezime}")
    public List<Student> getOneStudentByPrezime(@PathVariable String prezime) {
        List<Student> studentList = new ArrayList<>();
        for (Student s : repository.findAll()) {
            if (s.getSurname().toLowerCase().contentEquals(prezime.toLowerCase())) {
                studentList.add(s);
            }
        }
        return studentList;
    }
    
    @CrossOrigin
    @PostMapping("/studenti")
    public Student createStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    @CrossOrigin
    @DeleteMapping("/studenti/{id}")
    public boolean deleteStudent(@PathVariable int id) {
        repository.delete(id);
        return true;
    }

    @CrossOrigin
    @DeleteMapping("/studenti")
    public boolean deleteAll() {
        repository.deleteAll();
        return true;
    }

    @CrossOrigin
    @PutMapping("/studenti/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return repository.save(student);
    }
}
