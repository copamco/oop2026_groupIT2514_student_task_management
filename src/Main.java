import entities.TaskStatus;
import entities.Task;
import entities.Task_toStringWhere;
import repository.interfaces.Task_toStringWhereInt;
import entities.TaskFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //New Feature
        List<Task> tasks = List.of(
                new Task(1, "work", TaskStatus.IN_PROGRESS, 1, 1),
                new Task(2, "work", TaskStatus.TODO,        2, 1),
                new Task(3, "work", TaskStatus.TODO,        3, 1),
                new Task(4, "work", TaskStatus.DONE,        4, 1),
                new Task(5, "work", TaskStatus.DONE,        5, 1),
                TaskFactory.createTodoTask(2,"work")
        );
        //New Feature
        //Singleton
        Task mainTask = TaskFactory.createTodoTask(1, "work");
        Task mainTask = TaskFactory.createTodoTask(1, "work");
        //Singleton
        Task_toStringWhereInt service = new Task_toStringWhere();

        List<Task> todoTasks = service.Task_toStringWhereInt(tasks);

        for (Task task : todoTasks) {
            System.out.println(task);
        }
//
//      System.out.println(n1.getId());
//      System.out.println(n3.getId());


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
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        PrintUsersWhere n1 = new PrintUsersWhere() {
//            @Override
//            public void PrintAllUsersWhere(int id) {
//                System.out.println("здраствуите введите id по которому надо вывести имя ");
//                Scanner name = new Scanner(System.in);
//                int username = name.nextInt();
//            }
//        };

  }

}