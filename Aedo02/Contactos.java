import java.util.*;
class Contacto {
    private String nombre;
    private String celular;

    public Contacto(String nombre, String celular) {
        this.nombre = nombre;
        this.celular = celular;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCelular() {
        return celular;
    }
}
public class Contactos{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Contacto[] contactos = new Contacto[100];
        int indice = 0;
        while (true) {
            System.out.println("Ingrese nombre de contacto (o 'q' para salir): ");
            String nombre = sc.nextLine();
            if (nombre.equalsIgnoreCase("q")) {
                break;
            }
            System.out.println("Ingrese celular: ");
            String celular = sc.nextLine();
            if (!esUnico(contactos, indice, nombre)) {
                System.out.println("El nombre ya existe.");
            } else if (!esNumUnico(contactos, indice, celular)) {
                System.out.println("El número de celular ya existe.");
            } else if (esValido(celular)) {
                contactos[indice++] = new Contacto(nombre, celular);
            } else {
                System.out.println("Celular inválido.");
            }
        }
        System.out.println("Contactos ingresados:");
        for (int i = 0; i < indice; i++) {
            System.out.println(contactos[i].getNombre() + " - " + contactos[i].getCelular());
        }
        boolean seguirBuscando = true;
        while (seguirBuscando) {
            System.out.println("Ingrese nombre a buscar: ");
            String busqueda = sc.nextLine();
            Contacto contacto = buscar(contactos, indice, busqueda);
            if (contacto != null) {
                System.out.println("Celular: " + contacto.getCelular());
            } else {
                System.out.println("Contacto no encontrado.");
            }
            System.out.println("¿Desea buscar otro contacto? (S para sí, N para no): ");
            String opcion = sc.nextLine();
            if (opcion.equalsIgnoreCase("N")) {
                seguirBuscando = false;
                System.out.println("Programa finalizado.");
            }
        }
        sc.close();
    }

    private static boolean esValido(String celular) {
        if (celular.length() != 9) {
            return false;
        }
        for (int i = 0; i < celular.length(); i++) {
            if (!Character.isDigit(celular.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean esUnico(Contacto[] contactos, int indice, String nombre) {
        for (int i = 0; i < indice; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                return false;
            }
        }
        return true;
    }

    private static boolean esNumUnico(Contacto[] contactos, int indice, String celular) {
        for (int i = 0; i < indice; i++) {
            if (contactos[i].getCelular().equals(celular)) {
                return false;
            }
        }
        return true;
    }
    
    private static Contacto buscar(Contacto[] contactos, int indice, String nombre) {
        for (int i = 0; i < indice; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                return contactos[i];
            }
        }
        return null;
    }
}
