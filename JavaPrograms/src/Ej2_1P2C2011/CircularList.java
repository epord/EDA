package Ej2_1P2C2011;

/**
 * Created by Pedro on 27/4/2016.
 */
public interface CircularList<T> {
    /**
     * Agrega un elemento al final de la lista.
     */
    public void addLast(T elem);
    /**
     * Permite iterar por los elementos de la lista. La primera vez que se lo
     * invoca retorna el primer elemento, luego el segundo y as� sucesivamente.
     * Luego de retornar el �ltimo, la pr�xima invocaci�n vuelve a retornar el primero.
     * Lanza NoSuchElementException �nicamente cuando la lista est� vac�a.
     */
    public T getNext();
    /**
     * Hace que la pr�xima invocaci�n a getNext retorne el primer elemento de la lista.
     */
    public void reset();
    /**
     * Corta la lista en la posici�n actual. Esta lista (this) mantiene todos
     * los elementos desde el primero hasta el �ltimo retornado por getNext().
     * Los elementos restantes son almacenados en una nueva lista, que es retornada
     * por este m�todo.
     * Lanza IllegalStateException si nunca se invoc� a getNext antes de llamar a este
     * m�todo.
     */
    public CircularList<T> split();


    public void print();
}