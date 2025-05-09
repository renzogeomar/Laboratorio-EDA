package Laboratorio1.Ejercicio1;
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
        int moda = calcularModa(notas);
        double desviacionEstandar = calcularDesviacionEstandar(notas);
        double mediana = calcularMediana(notas);
        System.out.println("La media es: " + mediana);
        System.out.println("La moda es: " + moda);
        System.out.println("La desviacion estandar es: " + desviacionEstandar);

    }
    public static double calcularMediana(ArrayList<Integer> notas){
        int contador = 0;
        int acumulado = 0;
        for(int i = 0 ; i < notas.size(); i++){
            contador ++;
            acumulado = acumulado + notas.get(i);
        }
        return (double) acumulado / contador;
    }
    public static int calcularModa(ArrayList<Integer> notas){
        int[] contador = new int[21];
        for(int i = 0 ; i < notas.size(); i++){
            int nota = notas.get(i);
            if (nota >= 1 && nota <= 20) {
                contador[nota]++;
            }
        }
        int moda = -1;
        int maxFrecuencia = 0;
        for (int i = 1; i <= 20; i++) {
            if (contador[i] > maxFrecuencia) {
                maxFrecuencia = contador[i];
                moda = i;
            }
        }
        return moda;
    }
    public static double calcularDesviacionEstandar(ArrayList<Integer> notas){
        int n = notas.size();
        if (n == 0) return 0;

        // Paso 1: calcular la media
        double suma = 0;
        for (int i = 0; i < n; i++) {
            suma += notas.get(i);
        }
        double media = suma / n;

        // Paso 2: calcular la suma de los cuadrados de las diferencias
        double sumaCuadrados = 0;
        for (int i = 0; i < n; i++) {
            double diferencia = notas.get(i) - media;
            sumaCuadrados += diferencia * diferencia;
        }

        // Paso 3: calcular la raíz cuadrada del promedio de esas diferencias al cuadrado
        double desviacion = Math.sqrt(sumaCuadrados / n);

        return desviacion;
    }
}