package repository.interfaces;

import java.util.List;
    //Generic Repository
    public interface CommentRepository<T> {

    T create(T comment);

    T findById(int id);

    List<T> findAll();

    void update(T comment);

    void delete(int id);
    //Generic Repository
}
