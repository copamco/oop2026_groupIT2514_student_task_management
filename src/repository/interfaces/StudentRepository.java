package repository.interfaces;

import java.util.List;

public interface StudentRepository<T> {

    T create(T student);

    T findById(int id);

    List<T> findAll();
}
