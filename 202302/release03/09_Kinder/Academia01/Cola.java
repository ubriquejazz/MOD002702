/**
 * Interfaz que contiene la funcionalidad de una cola de cualquier tipo de elementos.
 * @author Usuario
 * @version 1.0 8/12/2022
 */

public interface Cola<T> {
    
    /**
     * Método que inserta un elemento en una cola.
     * @param elemento Elemento de tipo genérico a insertar en la cola.
     */
    public void insertar(T elemento);
    
    /**
     * Método que devuelve (sin eliminar) el elemento que está en la cabeza de la cola.
     * @return elemento de tipo genérico que está situado en la cabeza de la cola.
     * @exception NoSuchElementException cuando la cola está vacía.
     */
    public T cabeza();
    
    /**
     * Método que devuelve y elimina el elemento que está en la cabeza de la cola.
     * @return elemento de tipo genérico que está situado en la cabeza de la cola.
     * @exception NoSuchElementException cuando la cola está vacía.
     */
    public T eliminarCabeza();

    /**
     * Método que muestra el número de elementos de la cola.
     * @return número de elementos (entero) de la cola.
     */
    public int tamanyo();
        
}
