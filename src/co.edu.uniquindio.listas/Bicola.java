package co.edu.uniquindio.listas;

public class Bicola<T> {
    private Nodo<T> primero; // frente
    private Nodo<T> ultimo;  // final
    private int size;

    public Bicola() {
        primero = null;
        ultimo = null;
        size = 0;
    }
    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (estaVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
        size++;
    }
    public T desencolar() {
        if (estaVacia()) {
            System.out.println("La bicola está vacía, no se puede desencolar.");
            return null;
        }

        T dato = primero.getDato();
        primero = primero.getSiguiente();

        if (primero == null) {
            ultimo = null;
        }

        size--;
        return dato;
    }


    public void agregarAlInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (estaVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.setSiguiente(primero);
            primero = nuevo;
        }
        size++;
    }

    public T quitarAlFinal() {
        if (estaVacia()) {
            System.out.println("La bicola está vacía, no se puede quitar al final.");
            return null;
        }

        T dato = ultimo.getDato();

        if (primero == ultimo) {
            primero = null;
            ultimo = null;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != ultimo) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(null);
            ultimo = actual;
        }

        size--;
        return dato;
    }

    //
    public boolean estaVacia() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
