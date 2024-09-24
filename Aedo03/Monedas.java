import java.util.*;
public class Monedas {

    public static void main(String[] args) {
        Random rd = new Random();
        int lanzamientos = 1000000; 
        int[] frecuencia = new int[4];  

        for (int i = 0; i < lanzamientos; i++) {
            int caras = 0;
            for (int j = 0; j < 3; j++) {
                if (rd.nextBoolean()) { 
                    caras++;
                }
            }
            frecuencia[caras]++;
        }
        imprimir(frecuencia, lanzamientos);
    }

    public static void imprimir(int[] frecuencia, int lanzamientos) {
        System.out.println("Número de veces que cada caso ocurrió (0, 1, 2, 3 caras):");
        for (int i = 0; i < frecuencia.length; i++) {
            System.out.print(i + "  " + frecuencia[i] + " ");

            int porcentaje = (frecuencia[i] * 100) / lanzamientos;  
            for (int j = 0; j < porcentaje; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}