import java.util.*;

public class Batalla {
  public Batalla(Soldado[][] p) {
    System.out.println();
    if (p == null) {
      // Inicializar tablero
      Soldado[][] tablero = new Soldado[10][10];
      List<Soldado> todosLosSoldados = new ArrayList<>();

      int n = 2;
      // Army 1
      for (int i = 0; i < n; i++) {
        Soldado s = new Soldado();
        s.setName("SoldadoEj1_" + i);
        s.setHp((int) (Math.random() * (5 - 1 + 1) + 1));
        s.setActHP((int) (Math.random() * (5 - 1 + 1) + 1));
        int fila, col;
        do {
          fila = (int) (Math.random() * 10);
          col = (int) (Math.random() * 10);
        } while (tablero[fila][col] != null);
        s.setFila(fila);
        s.setColumna(col);
        s.setTeam(1);
        tablero[fila][col] = s;
        todosLosSoldados.add(s);
      }

      // Army 2
      for (int i = 0; i < n; i++) {
        Soldado s = new Soldado();
        s.setName("SoldadoEj2_" + i);
        s.setHp((int) (Math.random() * (5 - 1 + 1) + 1));
        s.setActHP((int) (Math.random() * (5 - 1 + 1) + 1));
        int fila, col;
        do {
          fila = (int) (Math.random() * 10);
          col = (int) (Math.random() * 10);
        } while (tablero[fila][col] != null);
        s.setFila(fila);
        s.setColumna(col);
        s.setTeam(2);
        tablero[fila][col] = s;
        todosLosSoldados.add(s);
      }

      // Mostrar tablero
      Methods.mostrarTablero(tablero);
      // Soldado con mayor vida de cada ejército
      Soldado mayorVidaEj1 = null;
      Soldado mayorVidaEj2 = null;
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          Soldado s = tablero[i][j];
          if (s != null) {
            if (s.getName().startsWith("SoldadoEj1_") && (mayorVidaEj1 == null || s.getHp() > mayorVidaEj1.getHp())) {
              mayorVidaEj1 = s;
            }
            if (s.getName().startsWith("SoldadoEj2_") && (mayorVidaEj2 == null || s.getHp() > mayorVidaEj2.getHp())) {
              mayorVidaEj2 = s;
            }
          }
        }
      }

      System.out.println();
      System.out.println("--------------------------------------------------------");
      System.out.println();
      System.out.println("Soldado con mayor vida Ejército 1:");
      System.out.println(mayorVidaEj1);
      System.out.println();
      System.out.println("--------------------------------------------------------");
      System.out.println();
      System.out.println("Soldado con mayor vida Ejército 2:");
      System.out.println(mayorVidaEj2);

      // Promedio vida de cada ejército
      int countEj1 = 0, countEj2 = 0;
      int sumaEj1 = 0, sumaEj2 = 0;

      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          Soldado s = tablero[i][j];
          if (s != null) {
            if (s.getName().startsWith("SoldadoEj1_")) {
              sumaEj1 += s.getHp();
              countEj1++;
            } else {
              sumaEj2 += s.getHp();
              countEj2++;
            }
          }
        }
      }

      double promEj1 = (double) sumaEj1 / countEj1;
      double promEj2 = (double) sumaEj2 / countEj2;

      System.out.println();
      System.out.println("--------------------------------------------------------");
      System.out.println();
      System.out.println("Promedio vida Ejército 1: " + promEj1);
      System.out.println("Promedio vida Ejército 2: " + promEj2);

      // Soldados por orden de creación
      ArrayList<Soldado> soldadosEj1 = new ArrayList<>();
      ArrayList<Soldado> soldadosEj2 = new ArrayList<>();

      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          Soldado s = tablero[i][j];
          if (s != null) {
            if (s.getName().startsWith("SoldadoEj1_")) {
              soldadosEj1.add(s);
            } else {
              soldadosEj2.add(s);
            }
          }
        }
      }

      System.out.println();
      System.out.println("--------------------------------------------------------");
      System.out.println();
      System.out.println("Soldados Ejército 1:");
      for (Soldado s : soldadosEj1) {
        System.out.println(s);
      }

      System.out.println();
      System.out.println("--------------------------------------------------------");
      System.out.println();
      System.out.println("Soldados Ejército 2:");
      for (Soldado s : soldadosEj2) {
        System.out.println(s);
      }

      // Ranking de poder
      ArrayList<Soldado> soldadosEj1Sorted = new ArrayList<>(soldadosEj1);
      ArrayList<Soldado> soldadosEj2Sorted = new ArrayList<>(soldadosEj2);

      // Ordenamiento por selección
      for (int i = 0; i < soldadosEj1Sorted.size(); i++) {
        int maxIndex = i;
        for (int j = i + 1; j < soldadosEj1Sorted.size(); j++) {
          if (soldadosEj1Sorted.get(j).getHp() > soldadosEj1Sorted.get(maxIndex).getHp()) {
            maxIndex = j;
          }
        }
        Soldado temp = soldadosEj1Sorted.get(maxIndex);
        soldadosEj1Sorted.set(maxIndex, soldadosEj1Sorted.get(i));
        soldadosEj1Sorted.set(i, temp);
      }

      for (int i = 0; i < soldadosEj2Sorted.size(); i++) {
        int maxIndex = i;
        for (int j = i + 1; j < soldadosEj2Sorted.size(); j++) {
          if (soldadosEj2Sorted.get(j).getHp() > soldadosEj2Sorted.get(maxIndex).getHp()) {
            maxIndex = j;
          }
        }
        Soldado temp = soldadosEj2Sorted.get(maxIndex);
        soldadosEj2Sorted.set(maxIndex, soldadosEj2Sorted.get(i));
        soldadosEj2Sorted.set(i, temp);
      }

      System.out.println();
      System.out.println("--------------------------------------------------------");
      System.out.println();
      System.out.println("Ranking Ejército 1:");
      for (Soldado s : soldadosEj1Sorted) {
        System.out.println(s);
      }

      System.out.println();
      System.out.println("--------------------------------------------------------");
      System.out.println();
      System.out.println("Ranking Ejército 2:");
      for (Soldado s : soldadosEj2Sorted) {
        System.out.println(s);
      }

      // Select winner
      int sumaVidaEj1 = 0;
      for (Soldado s : soldadosEj1Sorted) {
        sumaVidaEj1 += s.getHp();
      }

      int sumaVidaEj2 = 0;
      for (Soldado s : soldadosEj2Sorted) {
        sumaVidaEj2 += s.getHp();
      }

      System.out.println();
      System.out.println("--------------------------------------------------------");
      System.out.println();
      System.out.println("-----------------------------");
      System.out.println();
      System.out.println("EN BASE A LOS PUNTOS DE VIDA:");
      System.out.println();
      if (sumaVidaEj1 > sumaVidaEj2) {
        System.out.println("Gana el Ejército 1");
      } else if (sumaVidaEj2 > sumaVidaEj1) {
        System.out.println("Gana el Ejército 2");
      } else {
        System.out.println("Empate");
      }
      System.out.println();
      System.out.println("----------------------------------------------------");

      System.out.println("¡Bienvenidos al Juego de Batallas de Soldados PVP!");
      System.out.println();
      System.out.println("Reglas del Juego:");
      System.out.println("1. PvP (Jugador contra Jugador): Dos ejércitos se enfrentan en un tablero de 10x10.");
      System.out.println("2. Objetivo: El ejército que quede con soldados en el campo gana.");
      System.out.println("3. Movimiento: Selecciona un soldado y una nueva posición.");
      System.out.println("4. Combate: Si la nueva posición tiene un enemigo, se combate.");
      System.out.println();
      System.out.println("En caso querer poner pausa, ingresa ´pause´ en cualquier momento :)");
      System.out.println();
      System.out.println("¡Buena Suerte! ¡Que comience el juego!");
      System.out.println();

      Scanner sc = new Scanner(System.in);
      boolean gameOver = false;
      int batallas = 0;
      Soldado soldadoConMasBajas = null;
      Map<Soldado, Integer> bajasPorSoldado = new HashMap<>();

      System.out.println("Estadísticas completas de los soldados iniciales:");
      for (Soldado s : todosLosSoldados) {
        System.out.println(s);
      }
      System.out.println();

      while (!gameOver) {
        Methods.mostrarTablero(tablero);
        int x, y, x1, y1;
        while (true) {
          System.out.println("Ingrese las coordenadas del soldado a seleccionar (x, y):");
          System.out.print("x, y: ");
          String coordenadas = sc.nextLine();
          String[] partes = coordenadas.split(",");

          if (coordenadas.equalsIgnoreCase("pause")) {
            pauseMenu(tablero);
            continue;
          }

          if (partes.length != 2) {
            System.out.println("Entrada inválida. Intente de nuevo.");
            continue;
          }

          x = Integer.parseInt(partes[0]);
          y = Integer.parseInt(partes[1]);

          System.out.println("Ingrese las nuevas coordenadas (x1, y1):");
          System.out.print("x1, y1: ");
          String nuevasCoordenadas = sc.nextLine();
          partes = nuevasCoordenadas.split(",");

          if (nuevasCoordenadas.equalsIgnoreCase("pause")) {
            pauseMenu(tablero);
            continue;
          }

          if (partes.length != 2) {
            System.out.println("Entrada inválida. Intente de nuevo.");
            continue;
          }

          x1 = Integer.parseInt(partes[0]);
          y1 = Integer.parseInt(partes[1]);

          System.out.println("Siguiente turno...");

          if (x >= 0 && x < 10 && y >= 0 && y < 10 && x1 >= 0 && x1 < 10 && y1 >= 0 && y1 < 10) {
            if (tablero[x][y] != null) {
              break;
            } else {
              System.out.println("No hay un soldado en la posición inicial. Intente de nuevo.");
              Methods.mostrarTablero(tablero);
            }
          } else {
            System.out.println("Coordenadas fuera de rango. Intente de nuevo.");
            Methods.mostrarTablero(tablero);
          }
        }

        Soldado atacante = tablero[x][y];
        Soldado defensor = tablero[x1][y1];

        if (defensor != null) {
          batallas++;
          double winRateAtacante = Methods.calculateWinRate(atacante, defensor);
          double winRateDefensor = 100 - winRateAtacante;
          System.out.println("El atacante " + atacante.getName() + " tiene una probabilidad de " + winRateAtacante + "%");
          System.out.println("El defensor " + defensor.getName() + " tiene una probabilidad de " + winRateDefensor + "%");
          if (atacante.getTeam() == defensor.getTeam()) {
            System.out.println("No puedes atacar a un aliado. Intente de nuevo.");
            continue;
          }
          if (winRateAtacante == winRateDefensor) {
            atacante.morir();
            defensor.morir();
            tablero[x][y] = null;
            tablero[x1][y1] = null;
            System.out.println(
                "El combate estuvo tan reñido, ya que ambos combatientes tenian un porcentaje del 50% de ganar, así que ambos mueren en la batalla.");
          } else if (winRateAtacante > winRateDefensor) {
            atacante.attack(defensor);
            tablero[x1][y1] = atacante;
            tablero[x][y] = null;
            atacante.setFila(x1);
            atacante.setColumna(y1);
            atacante.setActHP(atacante.getHp() + 1);
            bajasPorSoldado.put(atacante, bajasPorSoldado.getOrDefault(atacante, 0) + 1);
            if (soldadoConMasBajas == null || bajasPorSoldado.get(atacante) > bajasPorSoldado.get(soldadoConMasBajas)) {
              soldadoConMasBajas = atacante;
            }
          } else {
            tablero[x][y] = null;
            atacante.attack(defensor, winRateAtacante, winRateDefensor);
            bajasPorSoldado.put(defensor, bajasPorSoldado.getOrDefault(defensor, 0) + 1);
            if (soldadoConMasBajas == null || bajasPorSoldado.get(defensor) > bajasPorSoldado.get(soldadoConMasBajas)) {
              soldadoConMasBajas = defensor;
            }
          }
        } else {
          tablero[x1][y1] = atacante;
          System.out.println("El soldado " + atacante.getName() + " ahora ocupa la posicion (" + x + ", " + y + ")");
          tablero[x][y] = null;
          atacante.setFila(x1);
          atacante.setColumna(y1);
        }

        // Verificar si el juego ha terminado
        int sumaVid1 = Methods.calcularSumaVidaEquipo(tablero, 1);
        int sumaVid2 = Methods.calcularSumaVidaEquipo(tablero, 2);
        if (sumaVid1 == 0) {
          Methods.mostrarTablero(tablero);
          System.out.println("El Ejercito 2 gana la batalla");
          gameOver = true;
          Methods.imprimirResultadoFinal(tablero, todosLosSoldados, 2, batallas, soldadoConMasBajas, bajasPorSoldado);
        } else if (sumaVid2 == 0) {
          Methods.mostrarTablero(tablero);
          System.out.println("El Ejercito 1 gana la batalla");
          gameOver = true;
          Methods.imprimirResultadoFinal(tablero, todosLosSoldados, 1, batallas, soldadoConMasBajas, bajasPorSoldado);
        }
      }
      System.out.println("El juego a Finalizado. ¡Gracias por jugar!");
      endMenu();
      sc.close();
    } else {
      // Inicializar tablero
      Soldado[][] tablero = p;
      List<Soldado> todosLosSoldados = new ArrayList<>();
      // Mostrar tablero
      Methods.mostrarTablero(tablero);
      // Soldado con mayor vida de cada ejército
      Soldado mayorVidaEj1 = null;
      Soldado mayorVidaEj2 = null;
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          Soldado s = tablero[i][j];
          if (s != null) {
            if (s.getName().startsWith("SoldadoEj1_") && (mayorVidaEj1 == null || s.getHp() > mayorVidaEj1.getHp())) {
              mayorVidaEj1 = s;
            }
            if (s.getName().startsWith("SoldadoEj2_") && (mayorVidaEj2 == null || s.getHp() > mayorVidaEj2.getHp())) {
              mayorVidaEj2 = s;
            }
          }
        }
      }

      System.out.println();
      System.out.println("--------------------------------------------------------");
      System.out.println();
      System.out.println("Soldado con mayor vida Ejército 1:");
      System.out.println(mayorVidaEj1);
      System.out.println();
      System.out.println("--------------------------------------------------------");
      System.out.println();
      System.out.println("Soldado con mayor vida Ejército 2:");
      System.out.println(mayorVidaEj2);

      // Promedio vida de cada ejército
      int countEj1 = 0, countEj2 = 0;
      int sumaEj1 = 0, sumaEj2 = 0;

      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          Soldado s = tablero[i][j];
          if (s != null) {
            if (s.getName().startsWith("SoldadoEj1_")) {
              sumaEj1 += s.getHp();
              countEj1++;
            } else {
              sumaEj2 += s.getHp();
              countEj2++;
            }
          }
        }
      }

      double promEj1 = (double) sumaEj1 / countEj1;
      double promEj2 = (double) sumaEj2 / countEj2;

      System.out.println();
      System.out.println("--------------------------------------------------------");
      System.out.println();
      System.out.println("Promedio vida Ejército 1: " + promEj1);
      System.out.println("Promedio vida Ejército 2: " + promEj2);

      // Soldados por orden de creación
      ArrayList<Soldado> soldadosEj1 = new ArrayList<>();
      ArrayList<Soldado> soldadosEj2 = new ArrayList<>();

      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          Soldado s = tablero[i][j];
          if (s != null) {
            if (s.getName().startsWith("SoldadoEj1_")) {
              soldadosEj1.add(s);
            } else {
              soldadosEj2.add(s);
            }
          }
        }
      }

      System.out.println();
      System.out.println("--------------------------------------------------------");
      System.out.println();
      System.out.println("Soldados Ejército 1:");
      for (Soldado s : soldadosEj1) {
        System.out.println(s);
      }

      System.out.println();
      System.out.println("--------------------------------------------------------");
      System.out.println();
      System.out.println("Soldados Ejército 2:");
      for (Soldado s : soldadosEj2) {
        System.out.println(s);
      }

      // Ranking de poder
      ArrayList<Soldado> soldadosEj1Sorted = new ArrayList<>(soldadosEj1);
      ArrayList<Soldado> soldadosEj2Sorted = new ArrayList<>(soldadosEj2);

      // Ordenamiento por selección
      for (int i = 0; i < soldadosEj1Sorted.size(); i++) {
        int maxIndex = i;
        for (int j = i + 1; j < soldadosEj1Sorted.size(); j++) {
          if (soldadosEj1Sorted.get(j).getHp() > soldadosEj1Sorted.get(maxIndex).getHp()) {
            maxIndex = j;
          }
        }
        Soldado temp = soldadosEj1Sorted.get(maxIndex);
        soldadosEj1Sorted.set(maxIndex, soldadosEj1Sorted.get(i));
        soldadosEj1Sorted.set(i, temp);
      }

      for (int i = 0; i < soldadosEj2Sorted.size(); i++) {
        int maxIndex = i;
        for (int j = i + 1; j < soldadosEj2Sorted.size(); j++) {
          if (soldadosEj2Sorted.get(j).getHp() > soldadosEj2Sorted.get(maxIndex).getHp()) {
            maxIndex = j;
          }
        }
        Soldado temp = soldadosEj2Sorted.get(maxIndex);
        soldadosEj2Sorted.set(maxIndex, soldadosEj2Sorted.get(i));
        soldadosEj2Sorted.set(i, temp);
      }

      System.out.println();
      System.out.println("--------------------------------------------------------");
      System.out.println();
      System.out.println("Ranking Ejército 1:");
      for (Soldado s : soldadosEj1Sorted) {
        System.out.println(s);
      }

      System.out.println();
      System.out.println("--------------------------------------------------------");
      System.out.println();
      System.out.println("Ranking Ejército 2:");
      for (Soldado s : soldadosEj2Sorted) {
        System.out.println(s);
      }

      // Select winner
      int sumaVidaEj1 = 0;
      for (Soldado s : soldadosEj1Sorted) {
        sumaVidaEj1 += s.getHp();
      }

      int sumaVidaEj2 = 0;
      for (Soldado s : soldadosEj2Sorted) {
        sumaVidaEj2 += s.getHp();
      }

      System.out.println();
      System.out.println("--------------------------------------------------------");
      System.out.println();
      System.out.println("-----------------------------");
      System.out.println();
      System.out.println("EN BASE A LOS PUNTOS DE VIDA:");
      System.out.println();
      if (sumaVidaEj1 > sumaVidaEj2) {
        System.out.println("Gana el Ejército 1");
      } else if (sumaVidaEj2 > sumaVidaEj1) {
        System.out.println("Gana el Ejército 2");
      } else {
        System.out.println("Empate");
      }
      System.out.println();
      System.out.println("----------------------------------------------------");

      System.out.println("¡Bienvenidos al Juego de Batallas Personalizadas de Soldados PVP!");
      System.out.println();
      System.out.println("Reglas del Juego:");
      System.out.println("1. PvP (Jugador contra Jugador): Dos ejércitos se enfrentan en un tablero de 10x10.");
      System.out.println("2. Objetivo: El ejército que quede con soldados en el campo gana.");
      System.out.println("3. Movimiento: Selecciona un soldado y una nueva posición.");
      System.out.println("4. Combate: Si la nueva posición tiene un enemigo, se combate.");
      System.out.println();
      System.out.println("En caso querer poner pausa, ingresa ´pause´ en cualquier momento :)");
      System.out.println();
      System.out.println("¡Buena Suerte! ¡Que comience el juego!");
      System.out.println();

      Scanner sc = new Scanner(System.in);
      boolean gameOver = false;
      int batallas = 0;
      Soldado soldadoConMasBajas = null;
      Map<Soldado, Integer> bajasPorSoldado = new HashMap<>();

      System.out.println("Estadísticas completas de los soldados iniciales:");
      for (Soldado s : todosLosSoldados) {
        System.out.println(s);
      }
      System.out.println();

      while (!gameOver) {
        Methods.mostrarTablero(tablero);
        int x, y, x1, y1;
        while (true) {
          System.out.println("Ingrese las coordenadas del soldado a seleccionar (x, y):");
          System.out.print("x, y: ");
          String coordenadas = sc.nextLine();
          String[] partes = coordenadas.split(",");

          if (coordenadas.equalsIgnoreCase("pause")) {
            pauseMenu(tablero);
            continue;
          }

          if (partes.length != 2) {
            System.out.println("Entrada inválida. Intente de nuevo.");
            continue;
          }

          x = Integer.parseInt(partes[0]);
          y = Integer.parseInt(partes[1]);

          System.out.println("Ingrese las nuevas coordenadas (x1, y1):");
          System.out.print("x1, y1: ");
          String nuevasCoordenadas = sc.nextLine();
          partes = nuevasCoordenadas.split(",");

          if (nuevasCoordenadas.equalsIgnoreCase("pause")) {
            pauseMenu(tablero);
            continue;
          }

          if (partes.length != 2) {
            System.out.println("Entrada inválida. Intente de nuevo.");
            continue;
          }

          x1 = Integer.parseInt(partes[0]);
          y1 = Integer.parseInt(partes[1]);

          System.out.println("Siguiente turno...");

          if (x >= 0 && x < 10 && y >= 0 && y < 10 && x1 >= 0 && x1 < 10 && y1 >= 0 && y1 < 10) {
            if (tablero[x][y] != null) {
              break;
            } else {
              System.out.println("No hay un soldado en la posición inicial. Intente de nuevo.");
              Methods.mostrarTablero(tablero);
            }
          } else {
            System.out.println("Coordenadas fuera de rango. Intente de nuevo.");
            Methods.mostrarTablero(tablero);
          }
        }

        Soldado atacante = tablero[x][y];
        Soldado defensor = tablero[x1][y1];

        if (defensor != null) {
          batallas++;
          double winRateAtacante = Methods.calculateWinRate(atacante, defensor);
          double winRateDefensor = 100 - winRateAtacante;
          System.out.println("El atacante " + atacante.getName() + " tiene una probabilidad de " + winRateAtacante);
          System.out.println("El defensor " + defensor.getName() + " tiene una probabilidad de " + winRateDefensor);
          if (atacante.getTeam() == defensor.getTeam()) {
            System.out.println("No puedes atacar a un aliado. Intente de nuevo.");
            continue;
          }
          if (winRateAtacante == winRateDefensor) {
            atacante.morir();
            defensor.morir();
            tablero[x][y] = null;
            tablero[x1][y1] = null;
            System.out.println(
                "El combate estuvo tan reñido, ya que ambos combatientes tenian un porcentaje del 50% de ganar, así que ambos mueren en la batalla.");
          } else if (winRateAtacante > winRateDefensor) {
            atacante.attack(defensor);
            tablero[x1][y1] = atacante;
            tablero[x][y] = null;
            atacante.setFila(x1);
            atacante.setColumna(y1);
            atacante.setActHP(atacante.getHp() + 1);
            bajasPorSoldado.put(atacante, bajasPorSoldado.getOrDefault(atacante, 0) + 1);
            if (soldadoConMasBajas == null || bajasPorSoldado.get(atacante) > bajasPorSoldado.get(soldadoConMasBajas)) {
              soldadoConMasBajas = atacante;
            }
          } else {
            tablero[x][y] = null;
            defensor.attack(atacante);
            bajasPorSoldado.put(defensor, bajasPorSoldado.getOrDefault(defensor, 0) + 1);
            if (soldadoConMasBajas == null || bajasPorSoldado.get(defensor) > bajasPorSoldado.get(soldadoConMasBajas)) {
              soldadoConMasBajas = defensor;
            }
          }
        } else {
          tablero[x1][y1] = atacante;
          System.out.println("El soldado " + atacante.getName() + " ahora ocupa la posicion (" + x + ", " + y + ")");
          tablero[x][y] = null;
          atacante.setFila(x1);
          atacante.setColumna(y1);
        }

        // Verificar si el juego ha terminado
        int sumaVid1 = Methods.calcularSumaVidaEquipo(tablero, 1);
        int sumaVid2 = Methods.calcularSumaVidaEquipo(tablero, 2);
        if (sumaVid1 == 0) {
          Methods.mostrarTablero(tablero);
          System.out.println("El Ejercito 2 gana la batalla");
          gameOver = true;
          Methods.imprimirResultadoFinal(tablero, todosLosSoldados, 2, batallas, soldadoConMasBajas, bajasPorSoldado);
        } else if (sumaVid2 == 0) {
          Methods.mostrarTablero(tablero);
          System.out.println("El Ejercito 1 gana la batalla");
          gameOver = true;
          Methods.imprimirResultadoFinal(tablero, todosLosSoldados, 1, batallas, soldadoConMasBajas, bajasPorSoldado);
        }
      }
      System.out.println("El juego a Finalizado. ¡Gracias por jugar!");
      endMenu();
      sc.close();
    }
  }

  public void pauseMenu(Soldado[][] tablero) {
    Scanner sc = new Scanner(System.in);
    System.out.println("PAUSE MENU: ");
    System.out.println("1. Nuevo Juego");
    System.out.println("2. Menu Principal");
    System.out.println("3. Continuar Juego");
    System.out.println();
    System.out.println("Selecciona tu opción");
    int z = sc.nextInt();
    switch (z) {
      case 1:
        Batalla b = new Batalla(null);
        break;
      case 2:
        Game game = new Game();
        break;
      case 3:
        System.out.println("Continuando Juego...");
        Methods.mostrarTablero(tablero);
        break;
      default:
        System.out.println("Opción inválida");
        break;
    }
  }

  public void endMenu() {
    Scanner sc = new Scanner(System.in);
    System.out.println("MENU: ");
    System.out.println("1. Jugar de Nuevo");
    System.out.println("2. Menu Principal");
    System.out.println();
    System.out.println("Selecciona tu opción");
    int z = sc.nextInt();
    switch (z) {
      case 1:
        Batalla b = new Batalla(null);
        break;
      case 2:
        Game game = new Game();
        break;
      default:
        System.out.println("Opción inválida");
        break;
    }
  }
}