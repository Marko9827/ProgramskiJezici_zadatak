package singidunum.Projekat2017200219.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import singidunum.Projekat2017200219.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    public Subject save(Subject subject);

}
