package repository.interfaces;

import java.util.List;

public interface TaskRepository<T> {
    T create(T task);
    T findById(int id);
    List<T> findAll();
    void update(T task);
    void delete(int id);
}

