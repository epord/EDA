package Exams.Ej2_1P1C2014;

/**
 * Created by Pedro on 26/4/2016.
 */
public interface CustomMap<K, V> {
    public V get(K key);
    public void put(K key, V value);
    public K getMostAccessed();
    public void removeLeastAccessed();
}
