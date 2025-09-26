package co.edu.uniquindio.listas;

public class ListaDobleSimple<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int size;

    public ListaDobleSimple() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
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