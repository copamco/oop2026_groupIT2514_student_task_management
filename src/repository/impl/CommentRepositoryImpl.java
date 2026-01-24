package repository.impl;

import entities.Comment;
import repository.interfaces.CommentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository {

    private final Connection connection;

    public CommentRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Comment create(Comment comment) {
        String sql = "INSERT INTO comments(task_id, student_id, text) VALUES (?, ?, ?) RETURNING id";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, comment.getTaskId());
            stmt.setInt(2, comment.getStudentId());
            stmt.setString(3, comment.getText());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                comment.setId(rs.getInt("id"));
            }
            return comment;

        } catch (SQLException e) {
            throw new RuntimeException("Error creating comment", e);
        }
    }

    @Override
    public Comment findById(int id) {
        String sql = "SELECT * FROM comments WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Comment(
                        rs.getInt("id"),
                        rs.getInt("task_id"),
                        rs.getInt("student_id"),
                        rs.getString("text")
                );
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Comment not found", e);
        }
    }

    @Override
    public List<Comment> findAll() {
        String sql = "SELECT * FROM comments";
        List<Comment> comments = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                comments.add(new Comment(
                        rs.getInt("id"),
                        rs.getInt("task_id"),
                        rs.getInt("student_id"),
                        rs.getString("text")
                ));
            }
            return comments;

        } catch (SQLException e) {
            throw new RuntimeException("Error fetching comments", e);
        }
    }

    @Override
    public void update(Comment comment) {
        String sql = "UPDATE comments SET task_id = ?, student_id = ?, text = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, comment.getTaskId());
            stmt.setInt(2, comment.getStudentId());
            stmt.setString(3, comment.getText());
            stmt.setInt(4, comment.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error updating comment", e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM comments WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting comment", e);
        }
    }
}

