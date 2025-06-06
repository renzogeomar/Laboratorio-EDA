package LAboratorio3.EjercicicosPropuestos.Ejercicio1;

import java.util.Collection;

public class list <T> {
    private node<T> root; //apunta al primer nodo/ punto de partida
    
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
    public void clear(){ //elimina todos los elementos de la lista
        root = null; //inicializa la lista vacia
    }
    public boolean contains(Object o){
        node<T> actual = root; //apunta al primer nodo
        while (actual != null){ //recorre la lista hasta el final
            if (actual.getData().equals(o)){ //compara el dato del nodo con el objeto
                return true; //si lo encuentra retorna true
            }
            actual = actual.getNext(); //apunta al siguiente nodo
        }
        return false; //si no lo encuentra retorna false
    }
    public boolean containsAll(Collection<?> c){ //verifica si la lista contiene todos los elementos de la coleccion
        for (Object o : c) {
            if (!contains(o)) { //si no contiene alguno retorna false
                return false;
            }
        }
        return true; //si contiene todos retorna true
    }
    public boolean equals(Object o){ //compara la lista con otro objeto
        if (o instanceof list<?>) { //verifica si el objeto es una lista
            list<?> other = (list<?>) o; //convierte el objeto a una lista
            node<T> actual = root; //apunta al primer nodo
            node<?> otherActual = other.root; //apunta al primer nodo de la otra lista
            while (actual != null && otherActual != null) { //recorre ambas listas hasta el final
                if (!actual.getData().equals(otherActual.getData())) { //compara los datos de los nodos
                    return false; //si no son iguales retorna false
                }
                actual = actual.getNext(); //apunta al siguiente nodo
                otherActual = otherActual.getNext(); //apunta al siguiente nodo de la otra lista
            }
            return actual == null && otherActual == null; //si ambas listas son del mismo tamaño retorna true
        }
        return false; //si no es una lista retorna false
    }
    public T get(int index){ //retorna el elemento en la posicion index
        node<T> actual = root; //apunta al primer nodo
        for (int i = 0; i < index; i++){ //recorre la lista hasta la posicion deseada
            actual = actual.getNext(); //apunta al siguiente nodo
        }
        return actual.getData(); //retorna el dato del nodo
    }
    public int indexOf(Object o){ //retorna la posicion del objeto en la lista
        node<T> actual = root; //apunta al primer nodo
        int index = 0; //inicializa el indice
        while (actual != null){ //recorre la lista hasta el final
            if (actual.getData().equals(o)){ //compara el dato del nodo con el objeto
                return index; //si lo encuentra retorna el indice
            }
            actual = actual.getNext(); //apunta al siguiente nodo
            index++; //incrementa el indice
        }
        return -1; //si no lo encuentra retorna -1
    }
    public boolean isEmpty(){ //verifica si la lista esta vacia
        return root == null; //retorna true si la lista esta vacia
    }
    public int lastIndexOf(Object o){ //retorna la ultima posicion del objeto en la lista
        node<T> actual = root; //apunta al primer nodo
        int index = 0; //inicializa el indice
        int lastIndex = -1; //inicializa el ultimo indice
        while (actual != null){ //recorre la lista hasta el final
            if (actual.getData().equals(o)){ //compara el dato del nodo con el objeto
                lastIndex = index; //si lo encuentra guarda el indice
            }
            actual = actual.getNext(); //apunta al siguiente nodo
            index++; //incrementa el indice
        }
        return lastIndex; //retorna el ultimo indice
    }
    public T remove(int index){ //elimina el elemento en la posicion index
        node<T> actual = root; //apunta al primer nodo
        if (index == 0){ //si es el primer nodo
            root = actual.getNext(); //apunta al siguiente nodo
            return actual.getData(); //retorna el dato del nodo
        }
        for (int i = 0; i < index - 1; i++){ //recorre la lista hasta la posicion deseada
            actual = actual.getNext(); //apunta al siguiente nodo
        }
        node<T> temp = actual.getNext(); //apunta al siguiente nodo
        actual.setNext(temp.getNext()); //apunta al siguiente nodo
        return temp.getData(); //retorna el dato del nodo
    }
    public boolean remove(Object o){ //elimina el objeto de la lista
        node<T> actual = root; //apunta al primer nodo
        if (actual.getData().equals(o)){ //compara el dato del nodo con el objeto
            root = actual.getNext(); //apunta al siguiente nodo
            return true; //retorna true si lo elimina
        }
        while (actual.getNext() != null){ //recorre la lista hasta el final
            if (actual.getNext().getData().equals(o)){ //compara el dato del nodo con el objeto
                actual.setNext(actual.getNext().getNext()); //apunta al siguiente nodo
                return true; //retorna true si lo elimina
            }
            actual = actual.getNext(); //apunta al siguiente nodo
        }
        return false; //retorna false si no lo encuentra
    }
    public boolean removeAll(Collection<?> c){ //elimina todos los elementos de la coleccion
        boolean result = false;
        for (Object o : c) {
            if (remove(o)) { //si lo elimina retorna true
                result = true; //indica que se elimino al menos un elemento
            }
        }
        return result;
    }
    public T set(int index, T element){ //reemplaza el elemento en la posicion index
        node<T> actual = root; //apunta al primer nodo
        for (int i = 0; i < index; i++){ //recorre la lista hasta la posicion deseada
            actual = actual.getNext(); //apunta al siguiente nodo
        }
        T oldData = actual.getData(); //guarda el dato del nodo
        actual.setData(element); //reemplaza el dato del nodo
        return oldData; //retorna el dato del nodo
    }
    public int size(){ //retorna el tamaño de la lista
        node<T> actual = root; //apunta al primer nodo
        int size = 0; //inicializa el tamaño
        while (actual != null){ //recorre la lista hasta el final
            size++; //incrementa el tamaño
            actual = actual.getNext(); //apunta al siguiente nodo
        }
        return size; //retorna el tamaño
    }
    public list<T> subList(int fromIndex, int toIndex){ //retorna una sublista de la lista
        list<T> subList = new list<T>(); //crea una nueva lista
        node<T> actual = root; //apunta al primer nodo
        for (int i = 0; i < fromIndex; i++){ //recorre la lista hasta la posicion deseada
            actual = actual.getNext(); //apunta al siguiente nodo
        }
        for (int i = fromIndex; i < toIndex; i++){ //recorre la lista hasta la posicion deseada
            subList.add(actual.getData()); //agrega el dato del nodo a la sublista
            actual = actual.getNext(); //apunta al siguiente nodo
        }
        return subList; //retorna la sublista
    }
}


