package Aedo06;
public class Contacto {
    private String nombre;
    private int edad;
    private String estadoCivil;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public String getEstadoCivil() {
        return estadoCivil;
    }
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Estado Civil: " + estadoCivil;
    }
}

