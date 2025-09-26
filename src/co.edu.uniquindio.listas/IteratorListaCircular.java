package co.edu.uniquindio.listas;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorListaCircular<T> implements Iterator<T> {
    private Nodo<T> actual;
    private final int total;  // número de elementos a recorrer
    private int cont = 0;

    public IteratorListaCircular(Nodo<T> primero, int size) {
        this.actual = primero;
        this.total = size;
    }

    @Override
    public boolean hasNext() {
        return cont < total;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No hay más elementos en la lista");
        }
        T dato = actual.getDato();
        actual = actual.getSiguiente();
        cont++;
        return dato;
    }
}
