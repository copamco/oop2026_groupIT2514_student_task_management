package repository.interfaces;

import entities.Project;
import java.util.List;

public interface ProjectRepository {

    void create(Project project);

    Project findById(int id);

    List<Project> findAll();
}

