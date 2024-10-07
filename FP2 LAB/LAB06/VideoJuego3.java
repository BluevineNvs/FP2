package LAB06;
//Laboratorio N° 06 - Ejercicio 5
//Autor: Nikole Valery Salas Idme
import java.util.*;
public class VideoJuego3 {
    public static void main(String[] args) {
        int n = 10;
        ArrayList<ArrayList<Soldado>> tablero = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Soldado> fila = new ArrayList<>(Collections.nCopies(10, null));
            tablero.add(fila);
        }
        generarSoldados(tablero, n, "Ej1");
        generarSoldados(tablero, n, "Ej2");
        mostrarTablero(tablero);
        Soldado mayorVidaEj1 = obtenerMayorVida(tablero, "Ej1");
        Soldado mayorVidaEj2 = obtenerMayorVida(tablero, "Ej2");
        System.out.println("--------------------------------------------------------");
        System.out.println("Soldado con mayor vida Ejército 1:");
        System.out.println(mayorVidaEj1);
        System.out.println("Soldado con mayor vida Ejército 2:");
        System.out.println(mayorVidaEj2);
        double promEj1 = calcularPromedioVida(tablero, "Ej1");
        double promEj2 = calcularPromedioVida(tablero, "Ej2");
        System.out.println("--------------------------------------------------------");
        System.out.println("Promedio vida Ejército 1: " + promEj1);
        System.out.println("Promedio vida Ejército 2: " + promEj2);
        System.out.println("--------------------------------------------------------");
        mostrarSoldados(tablero, "Ej1");
        mostrarSoldados(tablero, "Ej2");
        ArrayList<Soldado> rankingEj1 = ordenarSoldados(tablero, "Ej1", "seleccion");
        ArrayList<Soldado> rankingEj2 = ordenarSoldados(tablero, "Ej2", "burbuja");
        System.out.println("--------------------------------------------------------");
        System.out.println("Ranking Ejército 1 (Selección):");
        mostrarRanking(rankingEj1);
        System.out.println("Ranking Ejército 2 (Burbuja):");
        mostrarRanking(rankingEj2);
        determinarGanador(rankingEj1, rankingEj2);
    }
    public static void generarSoldados(ArrayList<ArrayList<Soldado>> tablero, int n, String ejercito) {
        for (int i = 0; i < n; i++) {
            Soldado s = new Soldado();
            s.setName("Soldado" + ejercito + "_" + i);
            s.setHp((int) (Math.random() * 5) + 1);
            int fila, col;
            do {
                fila = (int) (Math.random() * 10);
                col = (int) (Math.random() * 10);
            } while (tablero.get(fila).get(col) != null);
            s.setFila(fila);
            s.setColumna(col);
            tablero.get(fila).set(col, s);
        }
    }
    public static void mostrarTablero(ArrayList<ArrayList<Soldado>> tablero) {
        System.out.println("Tablero con símbolos:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero.get(i).get(j) == null) {
                    System.out.print("|_|");
                } else if (tablero.get(i).get(j).getName().contains("Ej1")) {
                    System.out.print("|*|"); // Ejército 1
                } else {
                    System.out.print("|$|"); // Ejército 2
                }
            }
            System.out.print("        ");
            for (int j = 0; j < 10; j++) {
                if (tablero.get(i).get(j) == null) {
                    System.out.print("|_|");
                } else {
                    System.out.print("|" + tablero.get(i).get(j).getHp() + "|");
                }
            }
            System.out.println();
        }
    }
    public static Soldado obtenerMayorVida(ArrayList<ArrayList<Soldado>> tablero, String ejercito) {
        Soldado mayorVida = null;
        for (ArrayList<Soldado> fila : tablero) {
            for (Soldado s : fila) {
                if (s != null && s.getName().contains(ejercito)) {
                    if (mayorVida == null || s.getHp() > mayorVida.getHp()) {
                        mayorVida = s;
                    }
                }
            }
        }
        return mayorVida;
    }
    public static double calcularPromedioVida(ArrayList<ArrayList<Soldado>> tablero, String ejercito) {
        int suma = 0, count = 0;
        for (ArrayList<Soldado> fila : tablero) {
            for (Soldado s : fila) {
                if (s != null && s.getName().contains(ejercito)) {
                    suma += s.getHp();
                    count++;
                }
            }
        }
        return (double) suma / count;
    }
    // Mostrar los soldados en el orden INICIAL
    public static void mostrarSoldados(ArrayList<ArrayList<Soldado>> tablero, String ejercito) {
        System.out.println("Soldados " + ejercito + ":");
        for (ArrayList<Soldado> fila : tablero) {
            for (Soldado s : fila) {
                if (s != null && s.getName().contains(ejercito)) {
                    System.out.println(s);
                }
            }
        }
    }
    // Ordenar los soldados (Selección o Burbuja)
    public static ArrayList<Soldado> ordenarSoldados(ArrayList<ArrayList<Soldado>> tablero, String ejercito,
            String metodo) {
        ArrayList<Soldado> soldados = new ArrayList<>();
        for (ArrayList<Soldado> fila : tablero) {
            for (Soldado s : fila) {
                if (s != null && s.getName().contains(ejercito)) {
                    soldados.add(s);
                }
            }
        }
        if (metodo.equals("seleccion")) {
            for (int i = 0; i < soldados.size(); i++) {
                int maxIndex = i;
                for (int j = i + 1; j < soldados.size(); j++) {
                    if (soldados.get(j).getHp() > soldados.get(maxIndex).getHp()) {
                        maxIndex = j;
                    }
                }
                Soldado temp = soldados.get(maxIndex);
                soldados.set(maxIndex, soldados.get(i));
                soldados.set(i, temp);
            }
        } else if (metodo.equals("burbuja")) {
            for (int i = 0; i < soldados.size() - 1; i++) {
                for (int j = 0; j < soldados.size() - i - 1; j++) {
                    if (soldados.get(j).getHp() < soldados.get(j + 1).getHp()) {
                        Soldado temp = soldados.get(j);
                        soldados.set(j, soldados.get(j + 1));
                        soldados.set(j + 1, temp);
                    }
                }
            }
        }
        return soldados;
    }
    public static void mostrarRanking(ArrayList<Soldado> soldados) {
        for (Soldado s : soldados) {
            System.out.println(s);
        }
    }
    public static void determinarGanador(ArrayList<Soldado> ej1, ArrayList<Soldado> ej2) {
        int sumaVidaEj1 = ej1.stream().mapToInt(Soldado::getHp).sum();
        int sumaVidaEj2 = ej2.stream().mapToInt(Soldado::getHp).sum();
        System.out.println("--------------------------------------------------------");
        if (sumaVidaEj1 > sumaVidaEj2) {
            System.out.println("Gana el Ejército 1");
        } else if (sumaVidaEj2 > sumaVidaEj1) {
            System.out.println("Gana el Ejército 2");
        } else {
            System.out.println("Empate");
        }
    }
}