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

    //Agregar un Elemento
    public void agregar(T dato){
        Nodo<T> nuevo = new Nodo<>(dato);
        if(esVacia()){
            primero = ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
        size++;
    }

    //Eliminar un elemento
    public T eliminar(){
        if(esVacia()) {
            throw new RuntimeException("La cola está vacía");
        }

        T dato = primero.getDato();
        primero = primero.getSiguiente();
        if(primero == null){
            ultimo = null;
        }
        size --;
        return dato;

    }

    //Método PEEK (obtener primero sin eliminar)
    public T peek(){
        return primero.getDato();
    }

    //Método POLL (obtener primero y eliminarlo)
    public T poll(){
        if(esVacia()) {
            return null;
        }

        T dato = primero.getDato();
        primero = primero.getSiguiente();
        if(primero == null){
            ultimo = null;
        }
        size --;
        return dato;

    }

    //Mostrar los elementos de la Cola
    public void mostrar() {
        Nodo<T> actual = primero;
        System.out.print("[");
        while (actual != null) {
            System.out.print(actual.getDato());
            actual = actual.getSiguiente();
            if (actual != null) System.out.print(" -> ");
        }
        System.out.println("]");
    }

    public boolean esVacia(){
        return size == 0;
    }

    public int size(){
        return size;
    }


}
