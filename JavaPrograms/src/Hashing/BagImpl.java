package Hashing;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Set;

public class BagImpl<T> implements Bag<T>{

    private OpenHashing<T, Integer> openHash = new OpenHashing<>();

    @Override
    public void add(T value) {
        Integer cant = openHash.get(value) == null ? 1 : openHash.get(value) + 1;
        openHash.put(value, cant);
    }

    @Override
    public int occurencesOf(T value) {
        return openHash.get(value) == null ? 0 : openHash.get(value);
    }

    @Override
    public void remove(T value) {
        Integer cant = openHash.get(value);
        if (cant != null) {
            if (cant - 1 == 0) {
                openHash.remove(value);
            } else {
                openHash.put(value, cant - 1);
            }
        }
    }

    public void print() {
        Set<T> set = openHash.keySet();
        String str = "";
        for (T each: set) {
            str += "<" + each + "," + openHash.get(each) + ">";
        }
        System.out.println(str);
    }
}
