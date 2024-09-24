package LAB01;
// Laboratorio N° 01 - Ejercicio 3
// Autor: Nikole Valery Salas Idme

import java.util.*;
public class Actividad03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] soldados = new String[5];

        for(int i = 0; i < 5; i++){
            System.out.print("Ingrese el nombre del soldado " + (i + 1) + ": ");
            soldados[i] = sc.nextLine();
        }
        System.out.println();
        System.out.println("Los nombres de los soldados son los siguientes:");
        System.out.println();
        for(int i = 0; i < 5; i++){
            System.out.println("Soldado " + (i + 1) + ": " + soldados[i]);
        }
        sc.close();
    }
}