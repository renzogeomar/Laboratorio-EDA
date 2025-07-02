package Laboratorio7.EjerciciosPropuestos.Ejercicio3;
public class Test{
    public static void main(String[] args) {
        AVL<Integer> arbol = new AVL<>();

        // Inserciones iniciales
        int[] datos = {100, 200, 300, 400, 500, 50, 25, 350, 375, 360, 355, 150, 175, 120, 190};
        for (int dato : datos) {
            arbol.insert(dato);
        }
        arbol.exportToDot("arbol.dot");
        System.out.println("Archivo DOT generado.");

    }
}