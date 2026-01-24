package entities;

public class Comment {
    private int id;
    private String text;
    private int taskId;
    private int authorStudentId;

    public Comment(int id, String text, int taskId, int authorStudentId) {
        this.id = id;
        setText(text);
        this.taskId = taskId;
        this.authorStudentId = authorStudentId;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Comment text cannot be empty");
        }
        this.text = text;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getAuthorStudentId() {
        return authorStudentId;
    }

    @Override
    public String toString() {
        return "Comment{id=" + id +
                ", text='" + text + '\'' +
                ", taskId=" + taskId +
                ", authorStudentId=" + authorStudentId +
                '}';
    }
}