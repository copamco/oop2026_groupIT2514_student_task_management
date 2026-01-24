package repository.interfaces;

import entities.Comment;
import java.util.List;

public interface CommentRepository {
    Comment create(Comment comment);
    Comment findById(int id);
    List<Comment> findAll();
    void update(Comment comment);
    void delete(int id);
}

