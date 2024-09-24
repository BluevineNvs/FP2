import java.util.*;
public class Simulacion {
    public static void main(String[] args) {
        int[] horas = new int[30];
        Random rd = new Random();
        for (int i = 0; i < horas.length; i++) {
            horas[i] = rd.nextInt(9);
        }
        System.out.println("Horas iniciales:");
        imprimir(horas);
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de días: ");
        int dias = sc.nextInt();
        for (int i = 0; i < dias; i++) {
            actualizar(horas, rd);
        }
        System.out.println("Horas de trabajo después de " + dias + " días:");
        imprimir(horas);
    }

    public static void actualizar(int[] horas, Random rd) {
        for (int i = 1; i < horas.length; i++) {
            horas[i - 1] = horas[i];
        }
        horas[horas.length - 1] = rd.nextInt(9);
    }

    public static void imprimir(int[] horas) {
        for (int i = 0; i < horas.length; i++) {
            System.out.println("Día " + (i + 1) + ": " + horas[i] + " horas");
        }
    }
}