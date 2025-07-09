package Laboratorio8.EjerciciosPropuestos.Ejercicio4;

public class Test{
    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<>(5);
        // Inserta algunas claves
        tree.insert(100);
        tree.insert(200);
        tree.insert(300);
        tree.insert(400);
        tree.insert(500);
        tree.insert(50);
        tree.insert(25);
        tree.insert(350);
        tree.insert(375);
        tree.insert(360);
        tree.insert(355);
        tree.insert(150);
        tree.insert(175);
        tree.insert(120);
        tree.insert(190);

        String dot = tree.toDot();
        tree.saveDotToFile("tree.dot");
        System.out.println(dot);
    }
}