package vallegrande.edu.pe.model;

public class actividad5 {
    // Atributos
    String nombre;
    int edad;

    // Constructor
    public actividad5(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);
    }
}
