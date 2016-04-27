package Exams.Ej3_1P1C2015;

/**
 * Created by Pedro on 24/4/2016.
 */
public class WordListImpl implements WordlList {

    private Node firstOdd, lastOdd, firstEven, lastEven;

    @Override
    public void add(String word) {
        int order;

        if (word.length() % 2 == 0) {
            if (lastEven == null) { // list is empty
                order = lastOdd == null ? 0 : lastOdd.getOrder() + 1;
                firstEven = new Node(word, order);
                lastEven = firstEven;
            } else {
                if (lastOdd == null) {
                    order = lastEven.getOrder() + 1;
                } else {
                    order = lastEven.getOrder() > lastOdd.getOrder() ? lastEven.getOrder() + 1 : lastOdd.getOrder() + 1;
                }
                lastEven.setNext(new Node(word, order));
                lastEven = lastEven.getNext();
            }
        } else {
            if (lastOdd == null) {
                order = lastEven == null ? 0 : lastEven.getOrder() + 1;
                firstOdd = new Node(word, order);
                lastOdd = firstOdd;
            } else {
                if (lastEven == null) {
                    order = lastOdd.getOrder() + 1;
                } else {
                    order = lastEven.getOrder() > lastOdd.getOrder() ? lastEven.getOrder() + 1 : lastOdd.getOrder() + 1;
                }
                lastOdd.setNext(new Node(word, order));
                lastOdd = lastOdd.getNext();
            }
        }

    }

    @Override
    public void print() {
        Node oddP = firstOdd;
        Node evenP = firstEven;

        while (oddP != null && evenP != null) {
            if (evenP.getOrder() < oddP.getOrder()) {
                System.out.printf(" %s", evenP);
                evenP = evenP.getNext();
            } else {
                System.out.printf(" %s", oddP);
                oddP = oddP.getNext();
            }
        }
        while (oddP != null) {
            System.out.printf(" %s", oddP);
            oddP = oddP.getNext();
        }
        while (evenP != null) {
            System.out.printf(" %s", evenP);
            evenP = evenP.getNext();
        }
        System.out.printf("\n");
    }

    @Override
    public void removeEven() {
        firstEven = null;
        lastEven = null;
    }

    @Override
    public void removeOdd() {
        firstOdd = null;
        lastOdd = null;
    }
}
