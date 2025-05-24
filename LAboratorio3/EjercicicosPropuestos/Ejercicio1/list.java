package LAboratorio3.EjercicicosPropuestos.Ejercicio1;

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
    public void remove(){
        if (root == null){ 
            System.out.println("La lista esta vacia");
        }
        else{
            node<T> actual = root; //apunta al primer nodo
            while (actual.getNext() != null){ //recorre la lista hasta el final
                actual = actual.getNext(); //apunta al siguiente nodo
            }
            actual.setNext(null); //elimina el ultimo nodo
        }
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





}


