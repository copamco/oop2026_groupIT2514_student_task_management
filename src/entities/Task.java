package entities;

public class Task {
    private int id;
    private String title;
    private TaskStatus status;
    private int projectId;
    private int assignedStudentId;

    public Task(int id, String title, TaskStatus status, int projectId, int assignedStudentId) {
        this.id = id;
        setTitle(title);
        setStatus(status);
        this.projectId = projectId;
        this.assignedStudentId = assignedStudentId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Task title cannot be empty");
        }
        this.title = title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
        this.status = status;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getAssignedStudentId() {
        return assignedStudentId;
    }

    @Override
    public String toString() {
        return "Task{id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", projectId=" + projectId +
                ", assignedStudentId=" + assignedStudentId +
                '}';
    }
}