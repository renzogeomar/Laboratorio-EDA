package LAboratorio3.EjercicicosResueltos.Ejercicio2;
import java.util.ArrayList;
import java.util.Iterator;
public class ejercicio2{
    public static void main(String[] args) {
        ArrayList<String> alumnos = new ArrayList<String>();
        alumnos.add("Diego"); 
        alumnos.add("Pedro");
        alumnos.add("Juan");
        alumnos.add("Marta");
        Iterator<String> itA = alumnos.iterator();
        while (itA.hasNext()) {
            System.out.println(itA.next());
        }
    }
}