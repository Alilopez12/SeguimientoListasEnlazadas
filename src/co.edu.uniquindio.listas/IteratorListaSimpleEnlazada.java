package co.edu.uniquindio.listas;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorListaSimpleEnlazada<T> implements Iterator<T> {
    private Nodo<T> actual;

    public IteratorListaSimpleEnlazada(Nodo<T> primero) {
        this.actual = primero;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        if (actual == null) {
            throw new NoSuchElementException("No hay más elementos en la lista");
        }
        T dato = actual.getDato();
        actual = actual.getSiguiente();
        return dato;
    }

}
