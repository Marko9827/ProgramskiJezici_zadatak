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

import singidunum.Projekat2017200219.entity.Professor;
import singidunum.Projekat2017200219.repository.ProfessorRepository;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @CrossOrigin
    @GetMapping("/profesori")
    public List<Professor> getAllProfessors() {
        return (List<Professor>) repository.findAll();
    }
 
    @CrossOrigin
    @GetMapping("/profesori/id/{id}")
    public List<Professor> getOneProfessor_id(@PathVariable String id) {
        List<Professor> professorsList = new ArrayList<>();
        for (Professor p : repository.findAll()) {
            if (p.getProfessorId().toLowerCase().contentEquals(id.toLowerCase())) {
                professorsList.add(p);
            }
        }
        return professorsList;
    } 
    
     @CrossOrigin
    @GetMapping("/profesori/{id}")
    public List<Professor> getOneProfessor(@PathVariable String id) {
        List<Professor> professorsList = new ArrayList<>();
        for (Professor p : repository.findAll()) {
            if (p.getProfessorId().toLowerCase().contentEquals(id.toLowerCase())) {
                professorsList.add(p);
            }
        }
        return professorsList;
    } 
    
    @CrossOrigin
    @GetMapping("/profesori/ime/{ime}")
    public List<Professor> getOneProfessorName(@PathVariable String ime){
        List<Professor> professorList = new ArrayList<>();
        for (Professor p : repository.findAll()) {
            if (p.getForename().toLowerCase().contentEquals(ime.toLowerCase())) {
                professorList.add(p);
            }
        }
        return professorList;
    }
    
    @CrossOrigin
    @GetMapping("/profesori/email/{email}")
    public List<Professor> getOneProfessorEmail(@PathVariable String email){
        List<Professor> professorList = new ArrayList<>();
        for (Professor p : repository.findAll()) {
            if (p.getEmail().toLowerCase().contentEquals(email.toString())) {
                professorList.add(p);
            }
        }
        return professorList;
    }
     
    
    
     @CrossOrigin
    @GetMapping("/profesori/plata/{plata}")
    public List<Professor> getOneProfessorByPlata(@PathVariable String plata) {
        List<Professor> professorsList = new ArrayList<>();
        for (Professor p : repository.findAll()) {
            if (p.getSalary().toLowerCase().contentEquals(plata.toLowerCase())) {
                professorsList.add(p);
            }
        }
        return professorsList;
    }
    
       

    

    @CrossOrigin
    @PostMapping("/profesori")
    public Professor createProfessor(@RequestBody Professor professor) {
        return repository.save(professor);
    }

    @CrossOrigin
    @DeleteMapping("/profesori/{id}")
    public boolean deleteProfessor(@PathVariable int id) {
        repository.delete(id);
        return true;
    }

    @CrossOrigin
    @DeleteMapping("/professors")
    public boolean deleteAll() {
        repository.deleteAll();
        return true;
    }
    
   

    @CrossOrigin
    @PutMapping("/professors/{id}")
    public Professor updateProfessor(@PathVariable int id, @RequestBody Professor professor) {
        return repository.save(professor);
    }
    
   
}
