package LAboratorio3.EjercicicosPropuestos.Ejercicio2;

import java.util.Scanner;

public class Main{
    static <T extends Number> double suma(T valor1, T valor2){
        return (valor1.doubleValue() + valor2.doubleValue());
    }
    static <T extends Number> double resta(T valor1, T valor2){
        return (valor1.doubleValue() - valor2.doubleValue());
    }
    static <T extends Number> double producto(T valor1, T valor2){
        return (valor1.doubleValue() * valor2.doubleValue());
    }
    static <T extends Number> double division(T valor1, T valor2) {
        if (valor2.doubleValue() == 0) {
            System.out.println("Error: División por cero.");
            return Double.NaN;
        }
        return valor1.doubleValue() / valor2.doubleValue();
    }
    static <T extends Number> double potencia(T base, T exponente){
        return Math.pow(base.doubleValue(), exponente.doubleValue());
    }
    static <T extends Number> double raizCuadrada(T valor){
        return Math.sqrt(valor.doubleValue());
    }
    static <T extends Number> double raizCubica(T valor) {
        return Math.cbrt(valor.doubleValue());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Operaciones Clases Genéricas ---");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Producto");
            System.out.println("4. División");
            System.out.println("5. Potencia");
            System.out.println("6. Raíz Cuadrada");
            System.out.println("7. Raíz Cúbica");
            System.out.println("8. Salir del Programa");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 7) {
                System.out.print("Ingrese el tipo de datos (1: Integer, 2: Double): ");
                int tipo = scanner.nextInt();

                if (tipo == 1) {
                    if (opcion >= 6) {
                        System.out.print("Ingrese el valor: ");
                        int val = scanner.nextInt();
                        Operador<Integer> op = new Operador<>(val, 0); // segundo valor no se usa
                        ejecutarOperacion(op, opcion);
                    } else {
                        System.out.print("Ingrese el valor 1: ");
                        int val1 = scanner.nextInt();
                        System.out.print("Ingrese el valor 2: ");
                        int val2 = scanner.nextInt();
                        Operador<Integer> op = new Operador<>(val1, val2);
                        ejecutarOperacion(op, opcion);
                    }
                } else {
                    if (opcion >= 6) {
                        System.out.print("Ingrese el valor: ");
                        double val = scanner.nextDouble();
                        Operador<Double> op = new Operador<>(val, 0.0); // segundo valor no se usa
                        ejecutarOperacion(op, opcion);
                    } else {
                        System.out.print("Ingrese el valor 1: ");
                        double val1 = scanner.nextDouble();
                        System.out.print("Ingrese el valor 2: ");
                        double val2 = scanner.nextDouble();
                        Operador<Double> op = new Operador<>(val1, val2);
                        ejecutarOperacion(op, opcion);
                    }
                }

            } else if (opcion == 8) {
                System.out.println("Programa terminado.");
            } else {
                System.out.println("Opción inválida.");
            }

        } while (opcion != 8);
        scanner.close();
    }
    
    public static <T extends Number> void ejecutarOperacion(Operador<T> op, int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Resultado: " + suma(op.getValor1(), op.getValor2()));
                break;
            case 2:
                System.out.println("Resultado: " + resta(op.getValor1(), op.getValor2()));
                break;
            case 3:
                System.out.println("Resultado: " + producto(op.getValor1(), op.getValor2()));
                break;
            case 4:
                System.out.println("Resultado: " + division(op.getValor1(), op.getValor2()));
                break;
            case 5:
                System.out.println("Resultado: " + potencia(op.getValor1(), op.getValor2()));
                break;
            case 6:
                System.out.println("Resultado: " + raizCuadrada(op.getValor1()));
                break;
            case 7:
                System.out.println("Resultado: " + raizCubica(op.getValor1()));
                break;
        }
    }
}