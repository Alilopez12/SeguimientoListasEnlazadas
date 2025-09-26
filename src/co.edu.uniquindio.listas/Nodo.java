package co.edu.uniquindio.listas;

public class Nodo<T> {
    private T dato;
    private co.edu.uniquindio.listas.Nodo<T> proximo;

    public Nodo(T dato) {
        this.dato = dato;
        this.proximo = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public co.edu.uniquindio.listas.Nodo<T> getProximo() {
        return proximo;
    }

    public void setProximo( co.edu.uniquindio.listas.Nodo<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "dato=" + dato +
                ", proximo=" + proximo +
                '}';
    }

}