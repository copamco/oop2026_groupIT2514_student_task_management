package entities;

public class Comment {
    private int id;
    private int taskId;
    private int studentId;
    private String text;

    public Comment(int id, int taskId, int studentId, String text) {
        this.id = id;
        this.taskId = taskId;
        this.studentId = studentId;
        this.text = text;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getText() {
        return text;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
        public String toString() {
        return "Comment{id=" + id +
                ", taskId=" + taskId +
                ", studentId=" + studentId +
                ", text='" + text + '\'' +
                '}';
    }
}
