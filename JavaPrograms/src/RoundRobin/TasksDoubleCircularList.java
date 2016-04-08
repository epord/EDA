package RoundRobin;

/**
 * Created by Pedro on 7/4/2016.
 */
public class TasksDoubleCircularList {
    private Node<Task> beginning;
    private int size;
    private int quantum;

    public TasksDoubleCircularList(int quantum) {
        this.quantum = quantum;
    }

    public void process(int time){
        if (size == 0){
            System.out.println("No tasks to process.");
            return;
        }
        int i = 0;
        Node<Task> n = beginning;

        while (i < time) {
            n.getElem().process(quantum);
            if (n.getElem().getTimeLeft() <= 0) {
                if(size == 1) {
                    beginning = null;
                    System.out.println(n.getElem().toString() + " task finished.");
                    System.out.println("Finished all processes.");
                    size--;
                    return;
                }
                Node<Task> auxNode = n.getNext();
                n.getNext().setPrev(n.getPrev());
                n.getPrev().setNext(auxNode);
                System.out.println(n.getElem().toString() + " task finished.");
                size--;
            }
            n = n.getNext();
            i += quantum;
        }
    }

    public void addTask(Task t) {
        Node<Task> newNode = new Node<>(t);
        if (beginning == null) {
            beginning = newNode;
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            size++;
            return;
        }
        if (size == 1) {
            beginning.setNext(newNode);
            beginning.setPrev(newNode);
            newNode.setNext(beginning);
            newNode.setPrev(beginning);
            size++;
            return;
        }
        Node<Task> auxPrev = beginning.getPrev();
        beginning.setPrev(newNode);
        newNode.setNext(beginning);
        newNode.setPrev(auxPrev);
        auxPrev.setNext(newNode);
        size++;
    }

    public String toString() {
       if(size == 0) {
           return "No curent tasks.";
       }
        String s = "";
        Node<Task> n = beginning;
        for (int i = 0; i < size - 1; i++) {
            s += n.getElem().toString() + ", ";
            n = n.getNext();
        }
        s += n.getElem();
        return s;
    }

    public int getSize() {
        return size;
    }
}
