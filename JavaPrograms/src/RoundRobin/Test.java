package RoundRobin;

import java.util.Scanner;

/**
 * Created by Pedro on 7/4/2016.
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Quantum: ");
        int quantum = sc.nextInt();
        System.out.printf("Time processor runs:");
        int processTime = sc.nextInt();

        Task t1 = new Task("Crysis", 20);
        Task t2 = new Task("Word", 8);
        Task t3 = new Task("Blender", 16);
        Task t4 = new Task("Skype" , 12);

        TasksDoubleCircularList l = new TasksDoubleCircularList(quantum);

        l.addTask(t1);
        l.addTask(t2);
        l.addTask(t3);
        l.addTask(t4);

        l.process(processTime);
    }

}
