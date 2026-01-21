package repository1.impl;

import entities.Project;
import repository1.interfaces.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository {

    private List<Project> projects = new ArrayList<>();

    @Override
    public void create(Project project) {
        projects.add(project);
    }

    @Override
    public Project findById(int id) {
        for (Project project : projects) {
            if (project.getId() == id) {
                return project;
            }
        }
        return null;
    }

    @Override
    public List<Project> findAll() {
        return projects;
    }
}

