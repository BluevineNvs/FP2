package LAB03;
//Laboratorio N° 03 - Ejercicio 2
//Autor: Nikole Valery Salas Idme
import java.util.*;
class Actividad4_new_Ver{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Soldados[] soldados = new Soldados[5];

        for (int i = 0; i < 5; i++) {
            soldados[i] = new Soldados();
            System.out.print("Ingresa el nombre del soldado " + (i + 1) + ": ");
            soldados[i].setName(sc.nextLine());
            System.out.print("Ingresa el nivel de vida del soldado " + (i + 1) + ": ");
            soldados[i].setPoints(sc.nextInt());
            sc.nextLine();
        }
        System.out.println();
        System.out.println("Los nombres de los soldados y su vida son los siguientes:");
        System.out.println();
        for (int i = 0; i < 5; i++){
            System.out.println(soldados[i]);
        }
        sc.close();
    }
}