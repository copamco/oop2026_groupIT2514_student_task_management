package entities;

public class TaskFactory {
    //Factory Pattern
    public static Task createTodoTask(int id, String title) {
        return new Task(id, title, TaskStatus.TODO, 1, 1);
    }

    public static Task createDoneTask(int id, String title) {
        return new Task(id, title, TaskStatus.DONE, 1, 1);
    }
    //Factory Pattern
}
