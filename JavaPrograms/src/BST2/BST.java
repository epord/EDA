package BST2;

import java.util.Comparator;
import java.util.Objects;

/**
 * Created by Pedro on 20/4/2016.
 */
public class BST<T> implements BinarySearchTree<T> {
    private int size;
    private Node<T> root;
    private Comparator<T> cmp;

    private class Node<T> {
        private T elem;
        private Node<T> l;
        private Node<T> r;

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

    public BST(Comparator<T> cmp) {
        this.cmp = cmp;
    }

    @Override
    public void add(T key) {
        if (root == null) {
            root = new Node(key);
            size++;
        } else {
            addRec(root, key);
        }
    }

    private Node<T> addRec(Node<T> n, T elem) {
        if (n == null) {
            size++;
            return new Node<T>(elem);
        }
        if (cmp.compare(elem, n.elem) < 0) {
            n.l = addRec(n.l, elem);
        } else if (cmp.compare(elem, n.elem) > 0) {
            n.r = addRec(n.r, elem);
        }
        return n;
    }

    @Override
    public void remove(T key) {
        if (root != null) {
            root = removeRec(root, key);
        }
    }

    private Node<T> removeRec(Node<T> n, T key) {
        if (n == null) {
            return null;
        }
        if (cmp.compare(key, n.elem) < 0) {
            n.l = removeRec(n.l, key);
        } else if (cmp.compare(key, n.elem) > 0) {
            n.r = removeRec(n.r, key);
        } else {    // key == n.elem
            Node<T> aux = n.l;
            while (aux != null && aux.r != null) {
                aux = aux.r;
            }
            if (aux != null) {
                removeRec(aux, aux.elem);
                aux.l = n.l;
            } else {
                aux = n.l;
                while (aux != null && aux.l != null) {
                    aux = aux.l;
                }
                if (aux != null) {
                    removeRec(aux, aux.elem);
                    aux.r = n.r;
                }
            }
            return aux;
        }
        return n;
    }

    @Override
    public boolean contains(T key) {
        if (root == null) {
            return false;
        }
        return containsRec(root, key);
    }

    private boolean containsRec(Node<T> n, T elem) {
        if (n == null) {
            return false;
        }
        if (n.elem.equals(elem)) {
            return true;
        }
        if (cmp.compare(elem, n.elem) < 0) {
            return  containsRec(n.l, elem);
        } else if (cmp.compare(elem, n.elem) > 0) {
            return  containsRec(n.r, elem);
        }
        return false; // error
    }

    @Override
    public int size() {
        return size;
    }

    public void printInOrder() {
       printInOrderRec(root);
    }

    private void printInOrderRec(Node<T> n) {
        if (n == null){
            return;
        }
        printInOrderRec(n.l);
        System.out.println(n.elem);
        printInOrderRec(n.r);
    }
}
