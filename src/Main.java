import static db.connect.*;

import db.DatabaseConnection;
import entities.Project;
import entities.Task;
import entities.TaskStatus;
import entities.Comment;
import repository.impl.CommentRepositoryImpl;

import java.sql.Connection;


import static db.connect.*;

public class Main {
  public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {

            createTableIfNeeded(connection);

            insertUser(connection, "Alice", "alice@example.com");
            insertUser(connection, "Bob", "bob@example.com");
            insertUser(connection, "robe", "bob2@example.com");
            findUserByEmail(connection, "yera@gmail.com");
            deleteUserById(connection, 2);
            printAllUsers(connection);

        } catch (Exception e) {
            e.printStackTrace();
        }

  }

}