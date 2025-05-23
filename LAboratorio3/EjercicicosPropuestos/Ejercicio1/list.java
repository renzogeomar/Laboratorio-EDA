package LAboratorio3.EjercicicosPropuestos.Ejercicio1;

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


}
