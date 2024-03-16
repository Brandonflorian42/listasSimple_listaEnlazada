
package edu.umg;

import java.util.HashSet;

/**
     * Insertar en medio
     */
public class ListaDoblementeEnlazada {
    public void insertarEnMedio(int dato, Nodo nodoAnterior) {
        if (nodoAnterior == null) {
            System.out.println("El nodo anterior no puede ser nulo");
            return;
        }

        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.enlace = nodoAnterior.enlace;
        nodoAnterior.enlace = nuevoNodo;
    }

        /** Eliminar en medio
         */
        public void eliminarEnMedio(Nodo nodoAnterior) {
            if (nodoAnterior == null || nodoAnterior.enlace == null) {
                System.out.println("No se puede eliminar el nodo en medio");
                return;
            }
            Nodo nodoAEliminar = nodoAnterior.enlace;
            nodoAnterior.enlace = nodoAEliminar.enlace;
            nodoAEliminar = null;
        }
        /** Revertir la lista doble
         */
        public Nodo revertirListaDoble(Nodo cabeza) {
            if (cabeza == null || cabeza.enlace == null) {
                return cabeza; // La lista está vacía o tiene solo un nodo, ya está revertida
            }
            Nodo actual = cabeza;
            Nodo temp = null;
            // Intercambiar los punteros previo y siguiente de cada nodo
            while (actual != null) {
                temp = actual.previo;
                actual.previo = actual.siguiente;
                actual.siguiente = temp;
                actual = actual.previo; // Mover al siguiente nodo
            }
            // Cambiar la cabeza a la última posición (el último nodo ahora es la cabeza)
            if (temp != null) {
                cabeza = temp.previo;
            }
            return cabeza;
        }
        /** Tamaño de la lista
         */
        public int tamañoLista(Nodo cabeza) {
            int tamaño = 0;
            Nodo actual = cabeza;
            while (actual != null) {
                tamaño++;
                actual = actual.siguiente; // Avanzar al siguiente nodo
            }
            return tamaño;
        }

        /** Eliminar duplicados
         */
        public void eliminarDuplicados(Nodo cabeza) {
            HashSet<Integer> conjunto = new HashSet<>();
            Nodo actual = cabeza;

            while (actual != null) {
                if (!conjunto.add(actual.dato)) {
                    if (actual.previo != null) {
                        actual.previo.siguiente = actual.siguiente;
                    }
                    if (actual.siguiente != null) {
                        actual.siguiente.previo = actual.previo;
                    }
                }
                actual = actual.siguiente;
            }
        }
    }


/** LinkedList<>
 */
public class Main {
    public static void eliminarDuplicados(LinkedList<Integer> lista) {
        lista.retainAll(new HashSet<>(lista));
    }

    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(2);
        lista.add(4);
        lista.add(3);

        System.out.println("Lista original: " + lista);
        eliminarDuplicados(lista);
        System.out.println("Lista sin duplicados: " + lista);
    }
}

