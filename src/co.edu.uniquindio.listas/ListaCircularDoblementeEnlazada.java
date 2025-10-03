package co.edu.uniquindio.listas;

public class ListaCircularDoblementeEnlazada<T extends Comparable<? super T>>{
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int size;

    public ListaCircularDoblementeEnlazada() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // Agregar al inicio
    public void agregarAlInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (isEmpty()) {
            primero = ultimo = nuevo;
            primero.setSiguiente(primero);
            primero.setAnterior(primero);
        } else {
            nuevo.setSiguiente(primero);
            nuevo.setAnterior(ultimo);
            primero.setAnterior(nuevo);
            ultimo.setSiguiente(nuevo);
            primero = nuevo;
        }
        size++;
    }

    // Agregar al final
    public void agregarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (isEmpty()) {
            primero = ultimo = nuevo;
            primero.setSiguiente(primero);
            primero.setAnterior(primero);
        } else {
            nuevo.setAnterior(ultimo);
            nuevo.setSiguiente(primero);
            ultimo.setSiguiente(nuevo);
            primero.setAnterior(nuevo);
            ultimo = nuevo;
        }
        size++;
    }

    // Buscar un dato
    public boolean buscar(T dato) {
        if (isEmpty()) return false;
        Nodo<T> actual = primero;
        for (int i = 0; i < size; i++) {
            if (actual.getDato().equals(dato)) return true;
            actual = actual.getSiguiente();
        }
        return false;
    }

    // Eliminar un dato
    public boolean eliminar(T dato) {
        if (isEmpty()) return false;

        Nodo<T> actual = primero;
        for (int i = 0; i < size; i++) {
            if (actual.getDato().equals(dato)) {
                if (size == 1) {
                    primero = ultimo = null;
                } else {
                    Nodo<T> anterior = actual.getAnterior();
                    Nodo<T> siguiente = actual.getSiguiente();

                    anterior.setSiguiente(siguiente);
                    siguiente.setAnterior(anterior);

                    if (actual == primero) primero = siguiente;
                    if (actual == ultimo) ultimo = anterior;
                }
                size--;
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public void mostrar() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
        Nodo<T> actual = primero;
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(actual.getDato());
            if (i < size - 1) System.out.print(" <-> ");
            actual = actual.getSiguiente();
        }
        System.out.println("]");
    }

    public void sort() {
        if (size <= 1) return;
        boolean swapped;
        do {
            swapped = false;
            Nodo<T> actual = primero;
            for (int i = 0; i < size - 1; i++) {
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

    public void InsertarSegunElValorDelDato(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (isEmpty()) {
            primero = ultimo = nuevo;
            nuevo.setSiguiente(nuevo);
            nuevo.setAnterior(nuevo);
        } else if (dato.compareTo(primero.getDato()) <= 0) {
            nuevo.setSiguiente(primero);
            nuevo.setAnterior(ultimo);
            primero.setAnterior(nuevo);
            ultimo.setSiguiente(nuevo);
            primero = nuevo;
        } else if (dato.compareTo(ultimo.getDato()) >= 0) {
            nuevo.setAnterior(ultimo);
            nuevo.setSiguiente(primero);
            ultimo.setSiguiente(nuevo);
            primero.setAnterior(nuevo);
            ultimo = nuevo;
        } else {
            Nodo<T> act = primero.getSiguiente();
            while (act != primero && act.getDato().compareTo(dato) < 0) {
                act = act.getSiguiente();
            }
            Nodo<T> prev = act.getAnterior();

            nuevo.setAnterior(prev);
            nuevo.setSiguiente(act);
            prev.setSiguiente(nuevo);
            act.setAnterior(nuevo);
        }
        size++;
    }



}
