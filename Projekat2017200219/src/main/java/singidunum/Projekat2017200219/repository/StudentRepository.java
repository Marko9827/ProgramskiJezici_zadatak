package singidunum.Projekat2017200219.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import singidunum.Projekat2017200219.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Student save(Student students);
}
