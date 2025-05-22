package LAboratorio3.EjercicicosPropuestos.Ejercicio1;

public class Estudiantes {
    private int cui;
    private int edad;
    private String nombre;
    public Estudiantes(int cui, int edad, String nombre) {
        this.cui = cui;
        this.edad = edad;
        this.nombre = nombre;
    }
    public int getCui() {
        return cui;
    }
    public void setCui(int cui) {
        this.cui = cui;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "Estudiantes [cui=" + cui + ", edad=" + edad + ", nombre=" + nombre + "]";
    }

}
