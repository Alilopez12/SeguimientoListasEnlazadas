package co.edu.uniquindio.listas;

public class ListaCircularDoblementeEnlazada<T> {
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
}
