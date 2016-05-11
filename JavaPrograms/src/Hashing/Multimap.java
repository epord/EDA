package Hashing;

import java.util.Collection;

/**
 * Created by Pedro on 11/5/2016.
 */
public interface Multimap<K,V> {

    public void put(K key, V value);
    public void remove(K key, V value);
    public void remove(K key);
    public Collection<V> get(K key);
    public void print();

}
