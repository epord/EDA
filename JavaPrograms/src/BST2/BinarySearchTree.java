package BST2;

/**
 * Created by Pedro on 20/4/2016.
 */
public interface BinarySearchTree<T> {
    public void add(T key);
    public void remove(T key);
    public boolean contains(T key);
    public int size();
}
