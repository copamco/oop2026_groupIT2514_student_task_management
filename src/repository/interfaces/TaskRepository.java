package repository.interfaces;

import entities.Task;
import java.util.List;

public interface TaskRepository {
    Task create(Task task);
    Task findById(int id);
    List<Task> findAll();
    void update(Task task);
    void delete(int id);
}

