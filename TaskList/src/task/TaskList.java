package task;


import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list;

    public TaskList() {
        list = new ArrayList<>();
    }

    public void add(Task task) {
        list.add(task);
    }

    public Task getAndRemoveNextTask() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return "task.TaskList{" +
                "list=" + list +
                '}';
    }
}
