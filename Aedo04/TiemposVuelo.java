import java.util.*;
public class TiemposVuelo {
    private static final String[] ciudades = {"AQP", "JUL", "CUZ", "TCQ", "LIM"};
    private static final int[][] tiemposVuelo = {
        { 0, 22, 30, 42, 57}, 
        {23,  0, 15, 25, 58}, 
        {31, 17,  0, 24, 30}, 
        {45, 27, 25,  0, 95}, 
        {59, 58, 30, 97,  0},
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar tabla de tiempos");
            System.out.println("2. Consultar tiempo de vuelo");
            System.out.println("3. Salir");
            System.out.print("Escoja una opción: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    mostrarTablaTiemposVuelo();
                    break;
                case 2:
                    preguntarPorTiempoVuelo(sc);
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
        System.out.println("Programa finalizado.");
        sc.close();
    }
    public static void mostrarTablaTiemposVuelo() {
        System.out.println("Tiempos de vuelo (en minutos):");
        System.out.print("       ");
        for (String ciudad : ciudades) {
            System.out.print(ciudad + "  ");
        }
        System.out.println();
        for (int i = 0; i < tiemposVuelo.length; i++) {
            System.out.print(ciudades[i] + "  ");
            for (int j = 0; j < tiemposVuelo[i].length; j++) {
                System.out.print(tiemposVuelo[i][j] + "    ");
            }
            System.out.println();
        }
    }
    public static void preguntarPorTiempoVuelo(Scanner sc) {
        System.out.println("\nCiudades registradas:");
        for (int i = 0; i < ciudades.length; i++) {
            System.out.println((i + 1) + ". " + ciudades[i]);
        }
        System.out.print("Número de ciudad de partida: ");
        int part = sc.nextInt() - 1;
        System.out.print("Número de ciudad de llegada: ");
        int lleg = sc.nextInt() - 1;
        if (part >= 0 && part < ciudades.length && lleg >= 0 && lleg < ciudades.length) {
            System.out.println("El vuelo es de " + tiemposVuelo[part][lleg] + " minutos.");
        } else {
            System.out.println("ERROR");
        }
    }
}