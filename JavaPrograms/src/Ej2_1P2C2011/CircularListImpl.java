package Ej2_1P2C2011;

import java.util.Objects;

/**
 * Created by Pedro on 27/4/2016.
 */
public class CircularListImpl<T> implements CircularList<T> {

    private Node<T> first;
    private Node<T> last;
    private Node<T> current;

    private class Node<T> {
        private T elem;
        private Node<T> next;

        public Node(T elem) {
            this.elem = elem;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(elem, node.elem);
        }

        @Override
        public int hashCode() {
            return Objects.hash(elem);
        }
    }


    @Override
    public void addLast(T elem) {
        if (first == null) {
            first = new Node<>(elem);
            last = first;
            first.next = last;  // next points to itself
            return;
        }
        if (last.equals(first)) {
            first.next = new Node<>(elem);
            last = first.next;
            last.next = first;
            return;
        }
        last.next = new Node<>(elem);
        last = last.next;
        last.next = first;
    }

    @Override
    public T getNext() {
        if (first == null) {
            throw new IllegalStateException("No elements in the list.");
        }
        if (current == null) {
            current = first;
        } else {
            current = current.next;
        }
        return current.elem;
    }

    @Override
    public void reset() {
        current = null;
    }

    @Override
    public CircularList<T> split() {
        if (current == null || first == null) {
            throw new IllegalStateException();
        }
        if (first.equals(last)) {
            return null;
        }
        // I create the new CircularList to return
        CircularListImpl<T> auxCL = new CircularListImpl<>();
        auxCL.first = current.next;
        auxCL.last = last;
        auxCL.last.next = auxCL.first;

        // I close the current CircularList
        last = current;
        last.next = first;

        return auxCL;
    }

    public void print() {
        Node<T> aux = current == null ? first : current;
        for (int i = 0; i < 10 && aux != null; i++) {
            System.out.printf("%s, ", aux.elem.toString());
            aux = aux.next;
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        CircularList<String> list1 = new CircularListImpl<String>();
        list1.addLast("A"); list1.addLast("B"); list1.addLast("C");
        list1.print(); // imprime "A B C A B C A B C A "
        list1.addLast("D"); list1.addLast("E"); list1.addLast("F");
        list1.print(); // imprime "B C D E F A B C D E "
        list1.reset();
        list1.getNext(); // A
        list1.getNext(); // B
        list1.getNext(); // C
        CircularList<String> list2 = list1.split();
        list1.print(); // imprime "A B C A B C A B C A "
        list2.print(); // imprime "D E F D E F D E F D "
        list2.reset(); list2.getNext(); list2.getNext(); list2.getNext();
        CircularList<String> list3 = list2.split();
        list2.print(); // imprime "D E F D E F D E F D "
        list3.print(); // Lanza NoSuchElementException porque la lista está vacía
    }
}
