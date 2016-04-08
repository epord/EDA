package RoundRobin;

/**
 * Created by Pedro on 7/4/2016.
 */
public class Task {
    private int timeRequired;
    private String taskName;

    public Task(String name, int timeRequired) {
        taskName = name;
        this.timeRequired = timeRequired;
    }

    public int getTimeLeft() {
        return timeRequired;
    }

    public void process(int time) {
        System.out.println("Processing " + taskName + ". " + "Time left: " + timeRequired + ".");
        timeRequired -= time;
    }

    public String toString() {
        return taskName;
    }
}
