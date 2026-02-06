package entities;
import repository.interfaces.Task_toStringWhereInt;

import java.util.List;
import java.util.stream.Collectors;

public class Task_toStringWhere implements Task_toStringWhereInt {
    //Lambda / Functional Interface
    @Override
    public List<Task> Task_toStringWhereInt(List<Task> tasks) {
        return tasks.stream()
                .filter(task -> task.getStatus() == TaskStatus.TODO)
                .toList();
    }
    //Lambda / Functional Interface
}