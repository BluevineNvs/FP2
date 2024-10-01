package Aedo06;
import java.util.*;
public class Cursos{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> cursos = new HashMap<>();
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Añadir curso");
            System.out.println("2. Consultar curso por código");
            System.out.println("3. Eliminar curso por código");
            System.out.println("4. Mostrar todos los cursos");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    agregar(cursos, scanner);
                    break;
                case 2:
                    consultar(cursos, scanner);
                    break;
                case 3:
                    eliminar(cursos, scanner);
                    break;
                case 4:
                    mostrar(cursos);
                    break;
                case 5:
                    System.out.println("Programa Finalizado");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }
    public static void agregar(HashMap<String, String> cursos, Scanner scanner) {
        System.out.print("Ingresa el nombre: ");
        String nombre = scanner.nextLine();
        String codigo = generarCodigo(nombre);
        if (cursos.containsKey(codigo)) {
            System.out.println("Ya existe un curso con ese código.");
        } else {
            cursos.put(codigo, nombre);
            System.out.println("Curso añadido: " + codigo + " - " + nombre);
        }
    }
    public static String generarCodigo(String nombre) {
        return nombre.substring(0, Math.min(2, nombre.length())).toUpperCase();
    }
    public static void consultar(HashMap<String, String> cursos, Scanner scanner) {
        System.out.print("Ingresa el código: ");
        String codigo = scanner.nextLine();
        if (cursos.containsKey(codigo)) {
            System.out.println("Curso: " + cursos.get(codigo));
        } else {
            System.out.println("No existe el código");
        }
    }
    public static void eliminar(HashMap<String, String> cursos, Scanner scanner) {
        System.out.print("Ingresa el código: ");
        String codigo = scanner.nextLine();
        if (cursos.remove(codigo) != null) {
            System.out.println("Curso eliminado.");
        } else {
            System.out.println("No existe el cógido");
        }
    }
    public static void mostrar(HashMap<String, String> cursos) {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
        } else {
            System.out.println("Cursos:");
            for (HashMap.Entry<String, String> entry : cursos.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}