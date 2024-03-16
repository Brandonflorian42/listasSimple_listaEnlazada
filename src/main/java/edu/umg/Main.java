package edu.umg;

import java.util.HashSet;

/**
 *
 * @author Walter Cordova
 */
public class Lista {

    private Nodo primero;

    @Override
    public String toString() {
        return "=>" + primero;
    }

    /**
     * Constructor para inicializar una lista
     */
    public Lista() {
        primero = null;
    }

    /**
     * Devuelve el nodo inicial
     *
     * @return
     */
    public Nodo leerPrimero() {
        return primero;
    }

    /**
     * Inserta valores a la lista
     *
     * @param entrada
     */
    public void insertarCabezaLista(int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;

    }

    /**
     * inserta un elemento a partir de anterior
     *
     * @param anterior
     * @param entrada
     */
    public void insertarLista(Nodo anterior, int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;

    }

    /**
     * elimina el elemento entrada
     *
     * @param entrada
     */
    public void eliminar(int entrada) {
        Nodo actual, anterior;
        boolean encontrado;
        actual = primero;
        anterior = null;
        encontrado = false;
        // Bucle de búsqueda
        while ((actual != null) && !(actual.dato == entrada)) {
            if (!(actual.dato == entrada)) {
                anterior = actual;
                actual = actual.enlace;
            }
        }
        if (actual != null) {
            // Se distingue entre que el nodo sea el cabecera
            // o del resto de la lista
            if (actual == primero) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
            actual = null;
        }
    }

    /**
     * busca el elemento destino
     *
     * @param destino
     * @return
     */
    public Nodo buscarLista(int destino) {
        Nodo indice;
        for (indice = primero; indice != null; indice = indice.enlace) {
            if (indice.dato == destino) {
                return indice;
            }
        }
        return null;
    }

    /**
     * recorre la lista y muestra cada dato
     */
    public void visualizar() {
        Nodo n;
        n = primero;
        while (n != null) {
            System.out.print(n.dato + " ");
            n = n.enlace;
        }
    }

    /**
     * Tarea:
     * / 1 - crear metodo para invertir lista enlazada
     */
    public class Nodo {
        int dato;
        Nodo enlace;

        public Nodo(int x) {
            dato = x;
            enlace = null;
        }

        public static Nodo invertirLista(Nodo cabeza) {
            Nodo prev = null;
            Nodo actual = cabeza;
            while (actual != null) {
                Nodo siguiente = actual.enlace;
                actual.enlace = prev;
                prev = actual;
                actual = siguiente;
            }
            return prev; // La cabeza de la lista invertida es el último nodo original
        }

        public static void imprimirLista(Nodo cabeza) {
            Nodo temp = cabeza;
            while (temp != null) {
                System.out.print(temp.dato + " ");
                temp = temp.enlace;
            }
            System.out.println();
        }

        public void main(String[] args) {
            Nodo cabeza = new Nodo(1);
            cabeza.enlace = new Nodo(2);
            cabeza.enlace.enlace = new Nodo(3);
            cabeza.enlace.enlace.enlace = new Nodo(4);

            System.out.println("Lista original:");
            imprimirLista(cabeza);

            cabeza = invertirLista(cabeza);

            System.out.println("Lista invertida:");
            imprimirLista(cabeza);
        }
    }


    /**
     * 2 - crear metodo para obtener elemento de la posicion n desde el final de la lista
     */

    public class Nodo {
        int dato;
        Nodo enlace;

        public Nodo(int x) {
            dato = x;
            enlace = null;
        }

        public static int obtenerElementoDesdeFinal(Nodo cabeza, int n) {
            Nodo p1 = cabeza;
            Nodo p2 = cabeza;
            // Avanzar p2 n posiciones hacia adelante
            for (int i = 0; i < n; i++) {
                if (p2 == null) return -1; // La lista es más corta que la posición especificada
                p2 = p2.enlace;
            }
            // Mover ambos punteros hasta que p2 alcance el final de la lista
            while (p2 != null) {
                p1 = p1.enlace;
                p2 = p2.enlace;
            }
            return (p1 != null) ? p1.dato : -1; // Retornar el dato de p1 si no es nulo, de lo contrario, -1
        }

        public void main(String[] args) {
            Nodo cabeza = new Nodo(1);
            cabeza.enlace = new Nodo(2);
            cabeza.enlace.enlace = new Nodo(3);
            cabeza.enlace.enlace.enlace = new Nodo(4);

            int n = 2;
            int elementoDesdeFinal = obtenerElementoDesdeFinal(cabeza, n);
            if (elementoDesdeFinal != -1) {
                System.out.println("Elemento " + n + " desde el final de la lista: " + elementoDesdeFinal);
            } else {
                System.out.println("No se pudo obtener el elemento " + n + " desde el final de la lista.");
            }
        }
    }

    /**
     * 3 - crear metodo para eliminar duplicados en una lista enlazada
     */

    public class Nodo {
        int dato;
        Nodo enlace;

        public Nodo(int x) {
            dato = x;
            enlace = null;
        }

        public static void eliminarDuplicados(Nodo cabeza) {
            HashSet<Integer> conjunto = new HashSet<>();
            Nodo prev = null;
            Nodo actual = cabeza;
            while (actual != null) {
                if (!conjunto.add(actual.dato)) {
                    prev.enlace = actual.enlace; // Eliminar el nodo actual
                } else {
                    prev = actual;
                }
                actual = actual.enlace;
            }
        }

        public void main(String[] args) {
            Nodo cabeza = new Nodo(1);
            cabeza.enlace = new Nodo(2);
            cabeza.enlace.enlace = new Nodo(3);
            cabeza.enlace.enlace.enlace = new Nodo(2);
            cabeza.enlace.enlace.enlace.enlace = new Nodo(4);

            System.out.println("Lista original:");
            imprimirLista(cabeza);

            eliminarDuplicados(cabeza);

            System.out.println("Lista sin duplicados:");
            imprimirLista(cabeza);
        }

        // Métodos auxiliares para imprimir la lista
        public static void imprimirLista(Nodo cabeza) {
            Nodo temp = cabeza;
            while (temp != null) {
                System.out.print(temp.dato + " ");
                temp = temp.enlace;
            }
            System.out.println();
        }
    }


    /**
     * 4 * Clase para representar un nodo de una lista enlazada
     */
    public class Nodo {
        int dato;
        Nodo enlace;

        public Nodo(int x) {
            dato = x;
            enlace = null;
        }

        public static int obtenerTamaño(Nodo cabeza) {
            int tamaño = 0;
            Nodo actual = cabeza;

            while (actual != null) {
                tamaño++;
                actual = actual.enlace;
            }

            return tamaño;
        }

        public void main(String[] args) {
            Nodo cabeza = new Nodo(1);
            cabeza.enlace = new Nodo(2);
            cabeza.enlace.enlace = new Nodo(3);
            cabeza.enlace.enlace.enlace = new Nodo(4);

            System.out.println("Tamaño de la lista: " + obtenerTamaño(cabeza));
        }
    }
}

