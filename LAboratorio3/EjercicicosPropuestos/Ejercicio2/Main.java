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
    static <T extends Number> double raizCuadrada(T valor){
        return Math.sqrt(valor.doubleValue());
    }
    static <T extends Number> double raizCubica(T valor) {
        return Math.cbrt(valor.doubleValue());
    }
    public static void main(String[] args) {
        
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