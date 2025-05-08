package Ejercicio1;
import java.lang.reflect.Array;
import java.util.*;;
public class ejercicio1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresar la cantidad de estudiantes: ");
        int cantidad = scan.nextInt();
        ArrayList<Integer> notas = new ArrayList<>();
        for(int i = 0 ; i < cantidad; i++){
            System.out.println("Ingresar nota para el estudiante " + (i+1) + ": ");
            int nota = scan.nextInt();
            while(nota < 0 || nota > 20){
                System.out.println("Nota invalida, ingresar nuevamente: ");
                nota = scan.nextInt();
            }
            notas.add(nota);
        }



    }
    public static void calcularMediana(ArrayList<Integer> notas){
        int contador = 0;
        int acumulado = 0;
        for(int i = 0 ; i < notas.size(); i++){
            contador ++;
            acumulado = acumulado + notas.get(i);
        }
        System.out.println("Le mediana es: " + (acumulado/contador));
    }
}