package co.edu.uniquindio.listas;
//Cola = Queue

public class Cola<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int size;

    public Cola(){
        primero = null;
        ultimo = null;
        size = 0;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo<T> primero) {
        this.primero = primero;
    }

    public Nodo<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo<T> ultimo) {
        this.ultimo = ultimo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //Método encolar (Agregr al final)
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

    //Método desencolar (Quitar el primer elemento de la cola)
    public T desencolar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía, no se puede desencolar.");
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

    //Metodo de Apoyo
    public boolean estaVacia() {
        return size == 0;
    }






}
