/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploHerencia5;

import java.util.ArrayList;
/**
 * Interfaz que contiene la funcionalidad de una cola de cualquier tipo de elementos.
 * @author Usuario
 * @version 1.0 8/12/2022
 */

interface Cola<T> {

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

public class ColaArrayList implements Cola {
    private ArrayList cola;
    
    public ColaArrayList(){
        cola = new ArrayList();
    }

    public void insertar(Object elemento) {
        cola.add(elemento);
    }

    public Object cabeza() {
        if(cola.isEmpty())
            return null;
        return cola.get(0);
    }

    @Override
    public Object eliminarCabeza() {
        if(cola.isEmpty())
            return null;
        Object elemento = cola.get(0);
        cola.remove(0);
        return elemento;
    }

    @Override
    public int tamanyo() {
        return cola.size();
    }
}
