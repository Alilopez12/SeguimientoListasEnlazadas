package co.edu.uniquindio.listas;

public class Pila<T> {
    private Nodo<T> cima;
    private int size;

    public Pila() {
        cima = null;
        size = 0;
    }

    // Empilar (agrega al inicio)
    public void empilar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (estaVacia()) {
            cima = nuevo;
        } else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }

        size++;
    }

    // Desempilar (Quitar al inicio)
    public T desempilar() {
        if (estaVacia()) {
            System.out.println("La pila está vacía, no se puede desempilar.");
            return null;
        }

        T dato = cima.getDato();
        cima = cima.getSiguiente();
        size--;

        return dato;
    }

    // Método de apoyo
    public boolean estaVacia() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public Nodo<T> getCima() {
        return cima;
    }
}