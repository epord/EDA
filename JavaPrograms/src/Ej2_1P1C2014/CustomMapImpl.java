package Ej2_1P1C2014;

/**
 * Created by Pedro on 26/4/2016.
 */
public class CustomMapImpl<K,V> implements CustomMap<K,V>{

    Node<K,V> first;
    Node<K,V> last;

    private class Node<K,V> {
        private K key;
        private V value;
        private int cantAccess;
        private Node<K,V> next;
        private Node<K,V> prev;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public V get(K key) {
        return getRec(first, key);
    }

    private V getRec(Node<K,V> n, K key) {
        if (n == null) {
            return null;    // the key doesn't exist
        }
        if (n.key.equals(key)) {
            n.cantAccess++;
            Node<K,V> aux = n.prev;
            while (aux != null && aux.cantAccess < n.cantAccess) {
                swap(aux, n);
                aux = n.prev;
            }
            return n.value;
        }
        return getRec(n.next, key);
    }

    // n1 must be the element BEFORE n2
    private void swap(Node<K,V> n1, Node<K,V> n2) {
        if (n1.prev == null) {
            first = n2;
        } else {
            n1.prev.next = n2;
        }
        if (n2.next == null) {
            last = n1;
        } else {
            n2.next.prev = n1;
        }
        n1.next = n2.next;
        n2.prev = n1.prev;
        n1.prev = n2;
        n2.next = n1;
    }

    @Override
    public void put(K key, V value) {
        first = putRec(first, key, value);
        if (last != null && last.next != null) {
            last = last.next;
        }
    }

    private Node<K,V> putRec(Node<K,V> n, K key, V value) {
        if (n == null) {
            return new Node<>(key, value);
        }
        if (n.key.equals(key)) {
            n.value = value;
            return n;
        }
        n.next = putRec(n.next, key, value);
        if (n.next != null) {
            n.next.prev = n;
        }
        return n;
    }

    @Override
    public K getMostAccessed() {
        if (first != null) {
            return first.key;
        }
        return null;
    }

    @Override
    public void removeLeastAccessed() {
        if (last != null) {
            last = last.prev;
        }
        if (last == null) {
            first = null;
        }
    }
}
