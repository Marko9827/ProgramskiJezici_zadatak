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

import singidunum.Projekat2017200219.entity.Subject;
import singidunum.Projekat2017200219.repository.SubjectRepository;

@RestController
public class SubjectController {

	@Autowired
	private SubjectRepository repository;
	
	@CrossOrigin
	@GetMapping("/predmeti")
	public List<Subject> getAllSubjects() {
		return (List<Subject>) repository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/predmeti/{id}")
        public List<Subject> getOneSubject(@PathVariable String id) {
		List<Subject> subjectsList = new ArrayList<>();
		for (Subject s : repository.findAll()) {
			if (s.getSubjectId().toLowerCase().equals(id.toLowerCase())) {
				subjectsList.add(s);
			}
		}
                
		return subjectsList;
	}
        
        @CrossOrigin
	@GetMapping("/predmeti/id/{id}")
        public List<Subject> getOnePredmet_id(@PathVariable String id) {
		List<Subject> subjectsList = new ArrayList<>();
		for (Subject s : repository.findAll()) {
			if (s.getSubjectId().toLowerCase().equals(id.toLowerCase())) {
				subjectsList.add(s);
			}
		}
                
		return subjectsList;
	}
        
        
        /*
	public Subject getOneSubject(@PathVariable int id) {
		return repository.findOne(id);
	} */
	
	@CrossOrigin
	@GetMapping("/predmeti/ime/{ime}")
	public List<Subject> getOneSubjectByName(@PathVariable String ime) {
		List<Subject> subjectsList = new ArrayList<>();
		for (Subject s : repository.findAll()) {
			if (s.getName().toLowerCase().equals(ime.toLowerCase())) {
				subjectsList.add(s);
			}
		}
		return subjectsList;
	}
	
	@CrossOrigin
	@PostMapping("/predmeti")
	public Subject createSubject(@RequestBody Subject subject){
		return repository.save(subject);
	}
	
	@CrossOrigin
	@DeleteMapping("/predmeti/{id}")
	public boolean deleteSubject(@PathVariable int id){
		repository.delete(id);
		return true;
	}
	
	@CrossOrigin
	@DeleteMapping("/predmeti")
	public boolean deleteAll(){
		repository.deleteAll();
		return true;
	}
	
	@CrossOrigin
	@PutMapping("/predmeti/{id}")
	public Subject updateSubject(@PathVariable int id, @RequestBody Subject subject){
		return repository.save(subject);
	}	
}