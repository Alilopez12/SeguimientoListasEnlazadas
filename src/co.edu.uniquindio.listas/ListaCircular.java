package co.edu.uniquindio.listas;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaCircular<T extends Comparable<T>> implements Iterable<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int size;

    public ListaCircular() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }


    public void agregarPrimero(T dato) {
        Nodo<T> newNodo = new Nodo<>(dato);

        if (primero == null) {
            primero = newNodo;
            primero.setProximo(primero);
        } else {
            Nodo<T> actual = primero;
            while (actual.getProximo() != primero) {
                actual = actual.getProximo();
            }
            newNodo.setProximo(primero);
            primero = newNodo;
            actual.setProximo(primero);
        }
        size++;
    }

    public void agregarAlFinal(T dato) {
        Nodo<T> newNodo = new Nodo<>(dato);

        if (primero == null) {
            primero = newNodo;
            primero.setProximo(primero);
        } else {
            Nodo<T> actual = primero;
            while (actual.getProximo() != primero) {
                actual = actual.getProximo();
            }
            actual.setProximo(newNodo);
            newNodo.setProximo(primero);
        }
        size++;
    }


    public void agregarEnPosicionEspecifica(T dato, int posicion) {
        if (posicion < 0 || posicion > size) {
            throw new IndexOutOfBoundsException("Posición inválida: " + posicion);
        }
        if (posicion == 0) { agregarPrimero(dato); return; }
        if (posicion == size) { agregarAlFinal(dato); return; }

        Nodo<T> nuevo = new Nodo<>(dato);
        Nodo<T> actual = primero;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.getProximo();
        }
        nuevo.setProximo(actual.getProximo());
        actual.setProximo(nuevo);
        size++;
    }

    public boolean esVacia() {
        return size == 0;
    }


    public int localizar(T datoBusqueda) {
        if (size == 0) return -1;
        Nodo<T> actual = primero;
        for (int i = 0; i < size; i++) {
            if (actual.getDato().equals(datoBusqueda)) return i;
            actual = actual.getProximo();
        }
        return -1;
    }

    public boolean buscar(T datoBusqueda) {
        return localizar(datoBusqueda) != -1;
    }

    public boolean eliminar(T datoBusqueda) {
        if (size == 0) return false;

        // Caso: borrar primero
        if (primero.getDato().equals(datoBusqueda)) {
            if (size == 1) {
                primero = ultimo = null;
            } else {
                primero = primero.getProximo();
                ultimo.setProximo(primero);
            }
            size--;
            return true;
        }


        Nodo<T> prev = primero;
        Nodo<T> curr = primero.getProximo();
        for (int i = 1; i < size; i++) {
            if (curr.getDato().equals(datoBusqueda)) {
                prev.setProximo(curr.getProximo());
                if (curr == ultimo) {
                    ultimo = prev; // actualizamos último
                }
                size--;
                return true;
            }
            prev = curr;
            curr = curr.getProximo();
        }
        return false;
    }


    public void AgregarOrdenNatural(T dato) {
        if (size == 0) { agregarPrimero(dato); return; }

        if (dato.compareTo(primero.getDato()) <= 0) { agregarPrimero(dato); return; }

        if (dato.compareTo(ultimo.getDato()) >= 0) { agregarAlFinal(dato); return; }

        Nodo<T> prev = primero;
        Nodo<T> curr = primero.getProximo();
        while (curr != primero && dato.compareTo(curr.getDato()) > 0) {
            prev = curr;
            curr = curr.getProximo();
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setProximo(curr);
        prev.setProximo(nuevo);
        size++;
    }

    public void mostrar() {
        StringBuilder sb = new StringBuilder("[");
        if (size > 0) {
            Nodo<T> actual = primero;
            for (int i = 0; i < size; i++) {
                sb.append(actual.getDato());
                if (i < size - 1) sb.append(" -> ");
                actual = actual.getProximo();
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorListaCircular<>(primero, size);
    }
}
