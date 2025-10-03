package co.edu.uniquindio.listas;

public class ListaDobleSimple<T extends Comparable<? super T>> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int size;

    public ListaDobleSimple() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }

    public void agregarAlInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (esVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);
            primero = nuevo;
        }
        size++;
    }

    public void agregarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (esVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }
        size++;
    }

    public void agregarEnPosicion(T dato, int posicion) {
        if (posicion < 0 || posicion > size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        if (posicion == 0) {
            agregarAlInicio(dato);
        } else if (posicion == size) {
            agregarAlFinal(dato);
        } else {
            Nodo<T> nuevo = new Nodo<>(dato);
            Nodo<T> actual = primero;


            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getSiguiente();
            }

            Nodo<T> siguiente = actual.getSiguiente();


            nuevo.setSiguiente(siguiente);
            nuevo.setAnterior(actual);
            actual.setSiguiente(nuevo);
            siguiente.setAnterior(nuevo);

            size++;
        }
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

    public void InsertarSegunElValorDelDato(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (esVacia()) {
            primero = ultimo = nuevo;
        } else if (dato.compareTo(primero.getDato()) <= 0) {
            // insertar al inicio
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);
            primero = nuevo;
        } else if (dato.compareTo(ultimo.getDato()) >= 0) {
            // insertar al final
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        } else {
            Nodo<T> act = primero.getSiguiente();
            while (act != null && act.getDato().compareTo(dato) < 0) {
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




    public Nodo<T> getPrimero() {
        return primero;
    }

    public Nodo<T> getUltimo() {
        return ultimo;
    }

    public int getSize() {
        return size;
    }

    public boolean esVacia() {
        return size == 0;
    }
}