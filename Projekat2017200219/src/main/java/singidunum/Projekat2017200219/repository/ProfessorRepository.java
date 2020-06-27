package singidunum.Projekat2017200219.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import singidunum.Projekat2017200219.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    public Professor save(Professor students);
}
