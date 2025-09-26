package co.edu.uniquindio.listas;

import java.util.Iterator;

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
        Nodo<T> nuevo = new Nodo<>(dato);
        if (size == 0) {
            primero = ultimo = nuevo;
            nuevo.setSiguiente(nuevo);
            nuevo.setAnterior(nuevo);
        } else {
            nuevo.setSiguiente(primero);
            nuevo.setAnterior(ultimo);
            primero.setAnterior(nuevo);
            ultimo.setSiguiente(nuevo);
            primero = nuevo;
        }
        size++;
    }

    public void agregarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (size == 0) {
            primero = ultimo = nuevo;
            nuevo.setSiguiente(nuevo);
            nuevo.setAnterior(nuevo);
        } else {
            nuevo.setAnterior(ultimo);
            nuevo.setSiguiente(primero);
            ultimo.setSiguiente(nuevo);
            primero.setAnterior(nuevo);
            ultimo = nuevo;
        }
        size++;
    }


    public void agregarEnPosicionEspecifica(T dato, int posicion) {
        if (posicion < 0 || posicion > size) {
            throw new IndexOutOfBoundsException("Posición inválida: " + posicion);
        }
        if (posicion == 0) { agregarPrimero(dato); return; }
        if (posicion == size) { agregarAlFinal(dato); return; }

        Nodo<T> actual = primero;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        // Insertar antes de 'actual'
        Nodo<T> nuevo = new Nodo<>(dato);
        Nodo<T> prev = actual.getAnterior();

        nuevo.setSiguiente(actual);
        nuevo.setAnterior(prev);
        prev.setSiguiente(nuevo);
        actual.setAnterior(nuevo);
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
            actual = actual.getSiguiente();
        }
        return -1;
    }

    public boolean buscar(T datoBusqueda) {
        return localizar(datoBusqueda) != -1;
    }

    public boolean eliminar(T datoBusqueda) {
        if (size == 0) return false;

        Nodo<T> actual = primero;
        for (int i = 0; i < size; i++) {
            if (actual.getDato().equals(datoBusqueda)) {
                if (size == 1) {
                    primero = ultimo = null;
                } else {
                    Nodo<T> prev = actual.getAnterior();
                    Nodo<T> next = actual.getSiguiente();
                    prev.setSiguiente(next);
                    next.setAnterior(prev);

                    if (actual == primero) primero = next;
                    if (actual == ultimo)  ultimo  = prev;
                }
                size--;
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public void AgregarOrdenNatural(T dato) {
        if (size == 0) { agregarPrimero(dato); return; }

        if (dato.compareTo(primero.getDato()) <= 0) { agregarPrimero(dato); return; }
        if (dato.compareTo(ultimo.getDato())  >= 0) { agregarAlFinal(dato);  return; }

        Nodo<T> curr = primero;
        for (int i = 0; i < size; i++) {
            if (dato.compareTo(curr.getDato()) <= 0) {
                // Insertar antes de curr
                Nodo<T> prev = curr.getAnterior();
                Nodo<T> nuevo = new Nodo<>(dato);

                nuevo.setAnterior(prev);
                nuevo.setSiguiente(curr);
                prev.setSiguiente(nuevo);
                curr.setAnterior(nuevo);
                size++;
                return;
            }
            curr = curr.getSiguiente();
        }

        agregarAlFinal(dato);
    }

    public void mostrar() {
        StringBuilder sb = new StringBuilder("[");
        if (size > 0) {
            Nodo<T> actual = primero;
            for (int i = 0; i < size; i++) {
                sb.append(actual.getDato());
                if (i < size - 1) sb.append(" -> ");
                actual = actual.getSiguiente();
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorListaCircular<>(primero, size);
    }
}
