package LAB03;
//Laboratorio N° 03 - Ejercicio 1
//Autor: Nikole Valery Salas Idme
import java.util.*;
public class DemoBatalla {
    public static void main(String[] args){
        Nave[] misNaves = new Nave[10];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;

        for (int i = 0; i < misNaves.length; i++){
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
        System.out.println("\nNaves ordenadas aleatoriamente:");
        mostrarNaves(shuffle(misNaves));
        sc.close();
    }

    // Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota){
        for(int i = 0; i < flota.length; i++){
            System.out.println(flota[i]);
        }
    }

    // Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave[] flota){
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for(int i = 0; i < flota.length; i++){
            if(name.equals(flota[i].getNombre())){
                System.out.println(flota[i]);
            }
        }
        sc.close();
    }

    // Método para mostrar todas las naves con un número de puntos inferior o igual
    // al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave[] flota){
        Scanner sc = new Scanner(System.in);
        int nmr = sc.nextInt();
        for(int i = 0; i < flota.length; i++){
            if(nmr >= flota[i].getPuntos()){
                System.out.println(flota[i]);
            }
        }
        sc.close();
    }

    // Método que devuelve la Nave con mayor número de Puntos
    public static Nave mostrarMayorPuntos(Nave[] flota){
        int m = 0;
        for(int i = 0; i < flota.length; i++){
            if(flota[i].getPuntos() > flota[m].getPuntos()){
                m = i;
            }
        }
        return flota[m];
    }

    // Método que devuelva un nuevo arreglo de objetos con todos los objetos previamente ingresados
    //pero aleatoriamente desordenados
    public static Nave[] shuffle(Nave[] flota){
        Random random = new Random();
        Nave[] aleatorio = new Nave[flota.length];
        for(int i = 0; i < flota.length; i++){
            aleatorio[i] = flota[i];
        }
        for(int i = aleatorio.length - 1; i > 0; i--){
            int indiceAleatorio = random.nextInt(i + 1);
            Nave temp = aleatorio[i];
            aleatorio[i] = aleatorio[indiceAleatorio];
            aleatorio[indiceAleatorio] = temp;
          }
        return aleatorio;
    }
}