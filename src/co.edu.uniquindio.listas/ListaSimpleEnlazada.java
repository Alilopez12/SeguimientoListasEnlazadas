package co.edu.uniquindio.listas;

import java.util.Iterator;

public class ListaSimpleEnlazada<T extends Comparable<? super T>> implements Iterable<T> {
    private Nodo<T> primero;
    private int size;

    public ListaSimpleEnlazada(){
        primero = null;
        size = 0;
    }

    public void agregarPrimero(T dato){
        Nodo<T> nuevo = new Nodo(dato);

        if(primero == null){
            primero = nuevo;
            size++;
        }else {
            nuevo.setSiguiente(primero);
            primero = nuevo;
            size++;
        }
    }

    public void agregarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        size++;
    }

    public void agregarEnPosicionEspecifica(T dato, int posicion){

        Nodo<T> nuevo = new Nodo<>(dato);

        if (posicion == 0) {
            nuevo.setSiguiente(primero);
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            int contador = 0;

            while (contador < posicion - 2) {
                actual = actual.getSiguiente();
                contador++;
            }

            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);

        }

        size++;
    }

    public boolean esVacia(){
        return (primero == null && size == 0) ? true: false;

    }

    public int localizar(T datoBusqueda){
        Nodo<T> actual = primero;
        int indexBusqueda = 0;

        while(actual != null){
            if(actual.getDato().equals(datoBusqueda)){
                return indexBusqueda;
            }

            indexBusqueda++;
            actual = actual.getSiguiente();
        }

        return -1;
    }

    public boolean buscar(T datoBusqueda){
        Nodo<T> actual = primero;
        boolean flag = false;

        while(actual != null){
            if(actual.getDato().equals(datoBusqueda)){
                flag = true;
            }
            actual = actual.getSiguiente();
        }

        return flag;
    }

    public boolean eliminar(T datoBusqueda){
        Nodo<T> actual = primero;

        if(actual.getDato().equals(datoBusqueda)){
            primero = actual.getSiguiente();
            size--;
            return true;
        }else{
            while (actual.getSiguiente() != null){
                if(actual.getSiguiente().getDato().equals(datoBusqueda)){
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    size--;
                    return true;
                }
                actual = actual.getSiguiente();
            }
        }
        return false;
    }

    public void AgregarOrdenNatural(T dato){
        Nodo<T> nuevo = new Nodo<>(dato);

        if(primero == null){
            primero = nuevo;
        }else{
            Nodo<T> actual = nuevo;
            T otro = actual.getSiguiente().getDato();

            while (actual.getSiguiente() != null &&
                    dato.compareTo(otro) > 0) {
                actual = actual.getSiguiente();
            }

            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);

        }
        size ++;

    }

    public void mostrar(){
        Nodo<T> actual = primero;
        String mensaje = "[";

        do {
            mensaje += actual.getDato() + " ";

            actual = actual.getSiguiente();
        } while(actual != null);

        mensaje += "]";
        System.out.println(mensaje);
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorListaSimpleEnlazada<>(primero);
    }
    public void sort() {
        if (size <= 1) return;
        boolean swapped;
        do {
            swapped = false;
            Nodo<T> actual = primero;
            while (actual != null && actual.getSiguiente() != null) {
                Nodo<T> sig = actual.getSiguiente();
                if (actual.getDato().compareTo(sig.getDato()) > 0) {
                    T tmp = actual.getDato();
                    actual.setDato(sig.getDato());
                    sig.setDato(tmp);
                    swapped = true;
                }
                actual = sig;
            }
        } while (swapped);
    }


}
