import java.util.*;

public class NotasArreglo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresar tamaño del arreglo:");
        int n = sc.nextInt();
        int[] notas = new int[n];

        ingresar(notas);
        imprimir(notas);
        sc.close();
    }

    public static void ingresar(int[] arreglo) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("Ingrese la nota número " + (i+1) + ": ");
            arreglo[i] = sc.nextInt();
        }
        sc.close();
    }

    public static void imprimir(int[] arreglo) {
        System.out.println("Las notas del arreglo son: ");
        for (int nota : arreglo) {
            System.out.println(nota);
        }
    }
}