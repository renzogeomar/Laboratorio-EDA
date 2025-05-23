package LAboratorio3.EjercicicosPropuestos.Ejercicio1;

import java.util.Collection;

public class list <T> {
    private node<T> root; //apunta al primer nodo/ punto de partida
    private int size; //tamaño de la lista
    
    public list(){
        this.root = null; //inicializa la lista vacia
    }
    public void add(T data){
        node<T> newNode = new node<T>(data); //crea un nuevo nodo
        if (root == null){
            root = newNode; // crea un nuevo nodo en caso que este vacio
        }
        else{
            node<T> actual = root; //apunta al primer nodo
            while (actual.getNext() != null){ //recorre la lista hasta el final
                actual = actual.getNext(); //apunta al siguiente nodo
            }
            actual.setNext(newNode); //agrega el nuevo nodo al final de la lista
        }
    }
    public void add(T data, int posicion){
        node<T> newNode = new node<T>(data); //crea un nuevo nodo
        if (root == null){
            root = newNode; // crea un nuevo nodo en caso que este vacio
        }
        else{
            node<T> actual = root; //apunta al primer nodo
            for (int i = 0; i < posicion - 1; i++){ //recorre la lista hasta la posicion deseada
                actual = actual.getNext(); //apunta al siguiente nodo
            }
            newNode.setNext(actual.getNext()); //apunta al siguiente nodo
            actual.setNext(newNode); //agrega el nuevo nodo a la lista
        }
    }
    public boolean addAll(Collection<? extends T> c){ //permite mayor flexibilidad y que el método acepte colecciones que tengan subtipos de E
        boolean result = false;
        for (T data : c) {
            add(data); //agrega cada elemento de la coleccion a la lista
            result = true; //indica que se agrego al menos un elemento
        }
        return result;
    }
    public boolean addAll(int index, Collection<? extends T> c){ //Agrega todos los elementos de la colección c a partir de la posición index en la lista. 
        boolean result = false;
        for (T data : c) {
            add(data, index); //agrega cada elemento de la coleccion a la lista
            result = true; //indica que se agrego al menos un elemento
        }
        return result;

    }


}


