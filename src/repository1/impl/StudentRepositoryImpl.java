package repository1.impl;

import entity.Student;
import repository1.interfaces.StudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    private final Connection connection;

    public StudentRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Student create(Student student) {
        String sql = "INSERT INTO students(name, email) VALUES (?, ?) RETURNING id";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                student.setId(rs.getInt("id"));
            }
            return student;

        } catch (SQLException e) {
            throw new RuntimeException("Error creating student", e);
        }
    }

    @Override
    public Student findById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Student not found", e);
        }
    }

    @Override
    public List<Student> findAll() {
        String sql = "SELECT * FROM students";
        List<Student> students = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                ));
            }
            return students;

        } catch (SQLException e) {
            throw new RuntimeException("Error fetching students", e);
        }
    }
}

