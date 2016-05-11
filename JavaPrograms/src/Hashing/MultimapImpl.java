package Hashing;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;

public class MultimapImpl<K,V> implements Multimap<K,V> {

    SimpleMap<K,Collection<V>> map = new OpenHashing<>();

    @Override
    public void put(K key, V value) {
        Collection<V> col = map.get(key);
        if (map.get(key) == null) {
            col = new LinkedList<>();
        }

        col.add(value);
        map.put(key, col);
    }

    @Override
    public void remove(K key, V value) {
        Collection<V> col = map.get(key);
        if (map.get(key) != null) {
            col.remove(value);
        }
        if (col.isEmpty()) {
            remove(key);
        }
    }

    @Override
    public void remove(K key) {
        map.remove(key);
    }

    @Override
    public Collection<V> get(K key) {
        return map.get(key);
    }

    @Override
    public void print() {
        Set<K> set = map.keySet();
        String str = "";
        for (K each: set) {
            str += "<" + each + "," + map.get(each) + "> ";
        }
        System.out.println(str);
    }
}
