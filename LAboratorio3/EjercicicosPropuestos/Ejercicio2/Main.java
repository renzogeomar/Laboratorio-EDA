package LAboratorio3.EjercicicosPropuestos.Ejercicio2;
public class Main{
    static <T extends Number> void suma(Operador<T> op){
        System.out.println("La suma es: " + (op.getValor1().doubleValue() + op.getValor2().doubleValue()));
    }
    public static void main(String[] args) {
        
    }
}