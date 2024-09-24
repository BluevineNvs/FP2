package LAB01;
// Laboratorio N° 01 - Ejercicio 1
// Autor: Nikole Valery Salas Idme

import java.util.*;
public class Actividad01 {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    String soldado1, soldado2, soldado3, soldado4, soldado5;
    
    System.out.print("Ingrese nombre del soldado 1: ");
    soldado1 = sc.nextLine();
    System.out.print("Ingrese nombre del soldado 2: ");
    soldado2 = sc.nextLine();
    System.out.print("Ingrese nombre del soldado 3: ");
    soldado3 = sc.nextLine();
    System.out.print("Ingrese nombre del soldado 4: ");
    soldado4 = sc.nextLine();
    System.out.print("Ingrese nombre del soldado 5: ");
    soldado5 = sc.nextLine();

    System.out.println();
    System.out.println("Los nombres de los soldados son los siguientes:");
    System.out.println();
    System.out.println("Soldado 1: " + soldado1);
    System.out.println("Soldado 2: " + soldado2);
    System.out.println("Soldado 3: " + soldado3);
    System.out.println("Soldado 4: " + soldado4);
    System.out.println("Soldado 5: " + soldado5);
    sc.close();
  }
}