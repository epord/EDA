package Exams.Ej3_1P1C2015;

/**
 * Created by Pedro on 24/4/2016.
 */
public class Test {

    public static void main(String[] args) {
        WordlList list = new WordListImpl();
        list.print();

        list.add("AA");
        list.add("DDD");
        list.add("F");
        list.add("EE");
        list.add("BBB");

        list.print();
        list.removeEven();
        list.print();
        list.add("CC");
        list.add("H");
        list.add("GGGG");
        list.print();
        list.removeOdd();
        list.print();
    }

}
