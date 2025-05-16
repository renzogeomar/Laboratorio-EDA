package Laboratorio2.EjerciciosResueltos.ejercicio2;
public class Recursividad {
    void imprimir(int x) {
        System.out.println(x);
        imprimir(x - 1);
    }
    public static void main(String[] ar) {
        Recursividad re = new Recursividad();
        re.imprimir(5);
    }
}
