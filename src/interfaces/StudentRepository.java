package interfaces;

import entity.Student;
import java.util.List;

public interface StudentRepository {

    Student create(Student student);

    Student findById(int id);

    List<Student> findAll();
}
