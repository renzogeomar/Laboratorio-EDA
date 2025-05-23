package LAboratorio3.EjercicicosPropuestos.Ejercicio1;

public class node <T>{
    private T data; //dato almacenado
    private node<T> next; //apunta al siguiente nodo

    public node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public node<T> getNext() {
        return next;
    }

    public void setNext(node<T> next) {
        this.next = next;
    }

}

