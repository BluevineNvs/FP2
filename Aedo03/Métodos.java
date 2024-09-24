import java.util.*;
public class Métodos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = sc.nextInt();
        int[] arreglo = new int[n]; 

        ingresar(arreglo);
        modificar(arreglo);
        imprimir(arreglo);
    }

    public static void ingresar(int[] arreglo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese los elementos:");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            arreglo[i] = sc.nextInt();
        }
    }
    
    public static void modificar(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] *= 2; 
        }
    }

    public static void imprimir(int[] arreglo) {
        System.out.println("Elementos del arreglo:");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Elemento " + (i + 1) + ": " + arreglo[i]);
        }
    }
}