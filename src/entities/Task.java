package entities;

public class Task {
    private int id;
    private String title;
    private TaskStatus status;
    private int projectId;
    private int assignedStudentId;

    public Task(int id, String title, TaskStatus status, int projectId, int assignedStudentId) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.projectId = projectId;
        this.assignedStudentId = assignedStudentId;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public TaskStatus getStatus() { return status; }
    public int getProjectId() { return projectId; }
    public int getAssignedStudentId() { return assignedStudentId; }

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setStatus(TaskStatus status) { this.status = status; }
    public void setProjectId(int projectId) { this.projectId = projectId; }
    public void setAssignedStudentId(int assignedStudentId) { this.assignedStudentId = assignedStudentId; }

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
