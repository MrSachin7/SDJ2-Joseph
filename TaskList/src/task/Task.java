package task;

public class Task {
    private String text;
    private Long estimatedTime;

    public Task(String text, Long estimatedTime) {
        this.text = text;
        this.estimatedTime = estimatedTime;
    }

    public String getText() {
        return text;
    }

    public Long getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Long estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    @Override
    public String toString() {
        return "task.Task{" +
                "text='" + text + '\'' +
                ", estimatedTime=" + estimatedTime +
                '}';
    }
}
