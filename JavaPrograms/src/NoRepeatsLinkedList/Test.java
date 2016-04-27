package NoRepeatsLinkedList;

/**
 * Created by Pedro on 26/4/2016.
 */
public class Test {

    public static void main(String[] args) {
        MySortedLinkedList<Integer> l = new MySortedLinkedList<>((o1, o2) -> o1 - o2);
        l.add(5);
        l.add(23);
        l.add(1);
        l.add(45);
        l.add(120);
        l.add(6);
        l.add(4);
        l.add(2);
        l.add(4);
        l.add(13);
        l.add(6);
        l.add(21);

        l.print();
        System.out.println(l.getSize());

        l.remove(6);
        l.remove(1);
        l.remove(23);

        l.print();
        System.out.println(l.getSize());
    }

}
