package co.edu.uniquindio.listas;

public class Main {

    public static void main(String[] args) {
        ListaDobleSimple<Integer> lista = new ListaDobleSimple<>();

        titulo("lista vacia");
        imprimirDesdeInicio(lista);
        imprimirDesdeFin(lista);
        imprimirSize(lista);


        titulo("Prueba agregarAlInicio()");
        lista.agregarAlInicio(20);
        lista.agregarAlInicio(10);
        lista.agregarAlInicio(0);
        imprimirDesdeInicio(lista);
        imprimirDesdeFin(lista);
        imprimirSize(lista);
        validarEnlaces(lista);


        titulo("Prueba agregarAlFinal()");
        lista.agregarAlFinal(30);
        lista.agregarAlFinal(40);
        imprimirDesdeInicio(lista);
        imprimirDesdeFin(lista);
        imprimirSize(lista);
        validarEnlaces(lista);

        titulo("Prueba agregarEnPosicion() en medio (pos=2)");
        lista.agregarEnPosicion(15, 2);
        imprimirDesdeInicio(lista);
        imprimirDesdeFin(lista);
        imprimirSize(lista);
        validarEnlaces(lista);


        titulo("Prueba agregarEnPosicion() al inicio (pos=0)");
        lista.agregarEnPosicion(-5, 0);
        imprimirDesdeInicio(lista);
        imprimirDesdeFin(lista);
        imprimirSize(lista);
        validarEnlaces(lista);


        titulo("Prueba agregarEnPosicion() al final (pos=size)");
        lista.agregarEnPosicion(50, lista.getSize());
        imprimirDesdeInicio(lista);
        imprimirDesdeFin(lista);
        imprimirSize(lista);
        validarEnlaces(lista);

    }
    private static <T> void imprimirDesdeInicio(ListaDobleSimple<T> lista) {
        System.out.print("Inicio ");
        Nodo<T> actual = lista.getPrimero();
        while (actual != null) {
            System.out.print(actual.getDato());
            actual = actual.getSiguiente();
            if (actual != null) System.out.print(" -> ");
        }
        System.out.println();
    }

    private static <T> void imprimirDesdeFin(ListaDobleSimple<T> lista) {
        System.out.print("Fin  ");
        Nodo<T> actual = lista.getUltimo();
        while (actual != null) {
            System.out.print(actual.getDato());
            actual = actual.getAnterior();
            if (actual != null) System.out.print(" -> ");
        }
        System.out.println();
    }

    private static void imprimirSize(ListaDobleSimple<?> lista) {
        System.out.println("size = " + lista.getSize());
    }


    private static <T> void validarEnlaces(ListaDobleSimple<T> lista) {
        int n = lista.getSize();
        if (n == 0) {
            System.out.println(".");
            return;
        }


        Nodo<T> p = lista.getPrimero();
        int pasos = 1;
        while (p != null && p.getSiguiente() != null) {
            p = p.getSiguiente();
            pasos++;
        }
        boolean okAvance = (p == lista.getUltimo()) && (pasos == n);

        Nodo<T> q = lista.getUltimo();
        int pasosBack = 1;
        while (q != null && q.getAnterior() != null) {
            q = q.getAnterior();
            pasosBack++;
        }
        boolean okRetroceso = (q == lista.getPrimero()) && (pasosBack == n);

        System.out.println("." + (okAvance ? "." : "ERROR")
                + ", retroceder=" + (okRetroceso ? "." : "ERROR"));
        if (!okAvance || !okRetroceso) {
            System.out.println("⚠ Revisa las asignaciones de anterior/siguiente en tus métodos.");
        }
        System.out.println();
    }

    private static void titulo(String t) {
        System.out.println( " + Verifico metodos + ");
    }
}