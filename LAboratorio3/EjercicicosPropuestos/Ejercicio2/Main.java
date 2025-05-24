package LAboratorio3.EjercicicosPropuestos.Ejercicio2;
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
    public static void main(String[] args) {
        
    }
}