package Hashing;

/**
 * Created by Pedro on 11/5/2016.
 */
public interface Bag<T> {
    /** Agrega un elemento a la bolsa. */
    public void add(T value);

    /** Obtiene la cantidad de veces que un elemento aparece en la bolsa. */
    public int occurencesOf(T value);

    /** Elimina un elemento de la bolsa. */
    public void remove(T value);

    public void print();
}
