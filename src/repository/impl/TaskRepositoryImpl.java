package repository.impl;

import entities.Task;
import repository.interfaces.TaskRepository;
import db.DatabaseConnection;
import db.connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {

    private final Connection connection;

    public TaskRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Task create(Task task) {
        String sql = "INSERT INTO tasks(title, status, project_id, assigned_student_id) " +
                "VALUES (?, ?, ?, ?) RETURNING id";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getStatus().name()); // enum -> string
            stmt.setInt(3, task.getProjectId());
            stmt.setInt(4, task.getAssignedStudentId());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                task.setId(rs.getInt("id"));
            }
            return task;

        } catch (SQLException e) {
            throw new RuntimeException("ошибка в созданий заданий", e);
        }
    }

    @Override
    public Task findById(int id) {
        String sql = "SELECT * FROM tasks WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Task(
                        rs.getInt("id"),
                        rs.getString("title"),
                        entities.TaskStatus.valueOf(rs.getString("status")),
                        rs.getInt("project_id"),
                        rs.getInt("assigned_student_id")
                );
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("заданий не найдена", e);
        }
    }

    @Override
    public List<Task> findAll() {
        String sql = "SELECT * FROM tasks";
        List<Task> tasks = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tasks.add(new Task(
                        rs.getInt("id"),
                        rs.getString("title"),
                        entities.TaskStatus.valueOf(rs.getString("status")),
                        rs.getInt("project_id"),
                        rs.getInt("assigned_student_id")
                ));
            }
            return tasks;

        } catch (SQLException e) {
            throw new RuntimeException("ошибка в получений заданий", e);
        }
    }

    @Override
    public void update(Task task) {
        String sql = "UPDATE tasks SET title = ?, status = ?, project_id = ?, assigned_student_id = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getStatus().name());
            stmt.setInt(3, task.getProjectId());
            stmt.setInt(4, task.getAssignedStudentId());
            stmt.setInt(5, task.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("ошибка в обновлений заданий", e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("заданйи не смог самоуничтожиться", e);
        }
    }
}

