package LAB04;
//Laboratorio N° 04 - Ejercicio 3
//Autor: Nikole Valery Salas Idme
import java.util.*;
public class DemoBatalla2{
    public static void main(String[] args) {
        Nave[] misNaves = new Nave[3];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;
        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.print("Fila: ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
            System.out.print("Estado: ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();
            misNaves[i] = new Nave(); // Se crea un objeto Nave y se asigna su referencia a misNaves
            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }
        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        System.out.println("\nBusqueda por nombre:");
        mostrarPorNombre(misNaves);
        System.out.println("\nFiltrar por numero de puntos:");
        mostrarPorPuntos(misNaves);
        System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));
        sc.nextLine();
        System.out.println("Ingrese el nombre de la nave a buscar: ");
        String nombre = sc.nextLine();
        //mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
        int pos = busquedaLinealNombre(misNaves,nombre);
        if(pos == -1){
            System.out.println("Nave no encontrada :C");
        }else{
            System.out.println(misNaves[pos]);
        }
        ordenarPorPuntosBurbuja(misNaves);
        System.out.println("Ordenar por puntos Bubble: ");
        mostrarNaves(misNaves);
        System.out.println("Ordenar por nombres Bubble: ");
        ordenarPorNombreBurbuja(misNaves);
        mostrarNaves(misNaves);
        System.out.println("Busqueda Binaria nombre: ");
        pos=busquedaBinariaNombre(misNaves,nombre);
        System.out.println(misNaves[pos]);
        System.out.println("Ordenar por puntos Selection: ");
        ordenarPorPuntosSeleccion(misNaves);
        mostrarNaves(misNaves);
        System.out.println("Ordenar por nombres Selection: ");
        ordenarPorNombreSeleccion(misNaves);
        mostrarNaves(misNaves);
        System.out.println("Ordenar por puntos Insertion: ");
        ordenarPorPuntosInsercion(misNaves);
        mostrarNaves(misNaves);
        System.out.println("Ordenar por nombres Insertion: ");
        ordenarPorNombreInsercion(misNaves);
        mostrarNaves(misNaves);
        sc.close();
    }
    // Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota) {
        for (int i = 0; i < flota.length; i++) {
            System.out.println(flota[i]);
        }
    }
    // Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for (int i = 0; i < flota.length; i++) {
            if (name.equals(flota[i].getNombre())) {
                System.out.println(flota[i]);
            }
        }
        sc.close();
    }
    // Método para mostrar todas las naves con un número de puntos inferior o igual
    // al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        int nmr = sc.nextInt();
        for (int i = 0; i < flota.length; i++) {
            if (nmr >= flota[i].getPuntos()) {
                System.out.println(flota[i]);
            }
        }
        sc.close();
    }
    // Método que devuelve la Nave con mayor número de Puntos
    public static Nave mostrarMayorPuntos(Nave[] flota) {
        int m = 0;
        for (int i = 0; i < flota.length; i++) {
            if (flota[i].getPuntos() > flota[m].getPuntos()) {
                m = i;
            }
        }
        return flota[m];
    }
    public static Nave[] shuffle(Nave[] flotaY) {
        Nave[] chocolateado = new Nave[flotaY.length];
        for (int i = 0; i < flotaY.length; i++) {
            chocolateado[i] = flotaY[i];
        }
        for (int i = chocolateado.length - 1; i > 0; i--) {
            int j = (int) Math.floor(Math.random() * (i + 1));
            Nave temp = chocolateado[i];
            chocolateado[i] = chocolateado[j];
            chocolateado[j] = temp;
        }
        return chocolateado;
    }
    // Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaLinealNombre(Nave[] flota, String s) {
        for(int i = 0; i < flota.length; i++){
            if(s.equals(flota[i].getNombre())){
                return i;
            }
        }
        return -1;
    }
    // Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosBurbuja(Nave[] flota) {
        for (int i = 0; i < flota.length - 1; i++) {
          for (int j = 0; j < flota.length - i - 1; j++) {
            if (flota[j].getPuntos() > flota[j+1].getPuntos()) {
              Nave temp = flota[j];
              flota[j] = flota[j+1]; 
              flota[j+1] = temp;
            }
          }
        }
      }
    // Método que ordena por nombre de A a Z
    public static void ordenarPorNombreBurbuja(Nave[] flota) {
        for (int i = 0; i < flota.length - 1; i++) {
          for (int j = 0; j < flota.length - i - 1; j++) {
            if (flota[j].getNombre().compareTo(flota[j+1].getNombre()) > 0) { 
              Nave temp = flota[j];
              flota[j] = flota[j+1];
              flota[j+1] = temp;
            }
          }
        }
      }
    // Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaBinariaNombre(Nave[] flota, String s) {
        int baja = 0;
        int alta = flota.length;
        while(baja <= alta){
            int media = (baja + alta) / 2;
            String name = flota[media].getNombre();
            int comparar = s.compareTo(name);
            if(comparar == 0){
                return media;
            }else if(comparar < 0){
                alta = media - 1;
            }else{
                baja = media + 1;
            }
        }
        return -1;
    }
    // Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosSeleccion(Nave[] flota) {
        for(int i = 0; i < flota.length; i++){
            int index = i;
            for(int j = i + 1; j < flota.length; j++){
                if(flota[j].getPuntos() < flota[index].getPuntos()){
                    index = j;
                }
            }
            Nave tempo = flota[i];
            flota[i] = flota[index];
            flota[index] = tempo;
        }
    }
    // Método que ordena por nombre de A a Z
    public static void ordenarPorNombreSeleccion(Nave[] flota) {
        for (int i = 0; i < flota.length - 1; i++) {
          int indexMin = i;
          for (int j = i + 1; j < flota.length; j++) {              
            if (flota[j].getNombre().compareTo(flota[indexMin].getNombre()) < 0) {
              indexMin = j;
            }
          } 
          Nave temp = flota[i];
          flota[i] = flota[indexMin];
          flota[indexMin] = temp;
        }
      }
    // Método que muestra las naves ordenadas por número de puntos de mayor a menor
    public static void ordenarPorPuntosInsercion(Nave[] flota) {
        for(int i = 0; i < flota.length; i++){
            Nave naveT = flota[i];
            int j = i - 1;
            while(j >= 0 && flota[j].getPuntos() < naveT.getPuntos()){
                flota[j + 1] = flota[j];
                j--;
            }
            flota[j + 1] = naveT;
        }
    }
    // Método que muestra las naves ordenadas por nombre de Z a A
    public static void ordenarPorNombreInsercion(Nave[] flota) {
        for (int i = 1; i < flota.length; i++) {
          Nave temp = flota[i];
          int j = i - 1;      
          while (j >= 0 && temp.getNombre().compareTo(flota[j].getNombre()) > 0) {
            flota[j + 1] = flota[j];
            j--;
          }        
          flota[j + 1] = temp;
        }
    }
}