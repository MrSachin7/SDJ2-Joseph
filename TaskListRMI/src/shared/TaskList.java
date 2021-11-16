package shared;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public void add(Task task) {
        taskList.add(task);
    }

    public Task getAndRemoveNextTask(){
        return taskList.remove(0);
    }
    public int size(){
        return taskList.size();
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "taskList=" + taskList +
                '}';
    }
}
