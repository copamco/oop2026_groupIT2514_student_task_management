package repository.interfaces;

import java.util.List;

public interface ProjectRepository<T> {

    void create(T project);

    T findById(int id);

    List<T> findAll();
}

