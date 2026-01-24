import db.DatabaseConnection;
import entities.Project;
import entities.Task;
import entities.TaskStatus;

import java.sql.Connection;


import static db.connect.*;

public class Main {
  public static void main(String[] args) {
//        try (Connection connection = DatabaseConnection.getConnection()) {
//
//            createTableIfNeeded(connection);
//
//            insertUser(connection, "Alice", "alice@example.com");
//            insertUser(connection, "Bob", "bob@example.com");
//            insertUser(connection, "robe", "bob2@example.com");
//            findUserByEmail(connection, "yera@gmail.com");
//            deleteUserById(connection, 2);
//            printAllUsers(connection);

//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    Project n1 = new Project(1,"n1","dwefwff");
    n1.toString();

    Task t1 = new Task(1,"task1", TaskStatus.IN_PROGRESS,2,1);


  }

}
