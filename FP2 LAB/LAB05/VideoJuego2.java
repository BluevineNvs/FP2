package LAB05;
//Laboratorio N° 05 - Ejercicio 5
//Autor: Nikole Valery Salas Idme
public class VideoJuego2 {
    public static void main(String[] args) {
        int n = 10;
        Soldado[][] tablero = new Soldado[10][10];
        // Inicializar tablero con soldados aleatorios
        for (int i = 0; i < n; i++) {
            Soldado s = new Soldado();
            s.setName("Soldado " + i);
            s.setHp((int) (Math.random() * (5 - 1 + 1) + 1));
            int fila, col;
            do {
                fila = (int) (Math.random() * 10);
                col = (int) (Math.random() * 10);
            } while (tablero[fila][col] != null);
            s.setFila(fila);
            s.setColumna(col);
            tablero[fila][col] = s;
        }
        // Mostrar tablero
        System.out.println("TABLERO DE JUEGO");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] == null) {
                    System.out.print("|_|");
                } else {
                    System.out.print("|" + "*" + "|");
                }
            }
            System.out.println();
        }
        // Soldado con mayor nivel de vida
        Soldado mayorVida = null;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] != null &&
                        (mayorVida == null || tablero[i][j].getHp() > mayorVida.getHp())) {
                    mayorVida = tablero[i][j];
                }
            }
        }
        System.out.println("Soldado con mayor nivel de vida:");
        System.out.println(mayorVida);
        // Promedio nivel de vida
        double suma = 0;
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] != null) {
                    suma += tablero[i][j].getHp();
                    count++;
                }
            }
        }
        double promedio = suma / count;
        System.out.println("Promedio nivel de vida: " + promedio);
        // Nivel de vida total
        int vidaTotal = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] != null) {
                    vidaTotal += tablero[i][j].getHp();
                }
            }
        }
        System.out.println("Nivel de vida total: " + vidaTotal);
        // Mostrar todos los soldados
        System.out.println("Todos los soldados:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] != null) {
                    System.out.println(tablero[i][j]);
                }
            }
        }
        // Ranking de poder
        Soldado[] ranking = new Soldado[n];
        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] != null) {
                    ranking[k++] = tablero[i][j];
                }
            }
        }
        // Ordenamiento por selección
        for (int i = 0; i < ranking.length - 1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < ranking.length; j++) {
                if (ranking[j].getHp() > ranking[indexMin].getHp()) {
                    indexMin = j;
                }
            }
            Soldado temp = ranking[indexMin];
            ranking[indexMin] = ranking[i];
            ranking[i] = temp;
        }
        // Mostrar ranking
        System.out.println("Ranking de poder (Selección):");
        for (Soldado s : ranking) {
            System.out.println(s);
        }
        // Ordenamiento por burbuja
        for (int i = 0; i < ranking.length - 1; i++) {
            for (int j = 0; j < ranking.length - i - 1; j++) {
                if (ranking[j].getHp() < ranking[j + 1].getHp()) {
                    Soldado temp = ranking[j];
                    ranking[j] = ranking[j + 1];
                    ranking[j + 1] = temp;
                }
            }
        }
        // Mostrar ranking
        System.out.println("Ranking de poder (Burbuja):");
        for (Soldado s : ranking) {
            System.out.println(s);
        }
    }
}