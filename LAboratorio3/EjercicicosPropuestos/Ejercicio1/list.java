package LAboratorio3.EjercicicosPropuestos.Ejercicio1;

public class list <T> {
    private node<T> root; //apunta al primer nodo
    
    public list(){
        this.root = null; //inicializa la lista vacia
    }
    public void add(T data){
        node<T> newNode = new node<T>(data); // creando un nuevo nodo
    }
}
