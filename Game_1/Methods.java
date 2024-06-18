import java.util.*;

class Methods {
  public static void ReinosGameplay(Ejercito[][] tablero, List<Ejercito> todosLosSoldados) {
    System.out.println("¡Bienvenidos al Juego de Batallas de Reinos PVP!");
    System.out.println();
    System.out.println("Reglas del Juego:");
    System.out.println("1. PvP (Jugador contra Jugador): Dos reinos se enfrentan en una batala sin igual");
    System.out.println("2. Objetivo: El reino que quede con soldados en el campo gana.");
    System.out.println("3. Movimiento: Selecciona un reino, ejercito, soldado y una nueva posición.");
    System.out.println("4. Combate: Si la nueva posición tiene un enemigo, se combate.");
    System.out.println();
    System.out.println("En caso querer poner pausa, ingresa ´pause´ en cualquier momento :)");
    System.out.println();
    System.out.println("¡Buena Suerte! ¡Que comience el juego!");
    System.out.println();

    Scanner sc = new Scanner(System.in);
    boolean gameOver = false;
    int batallas = 0;
    Map<Soldado, Integer> bajasPorSoldado = new HashMap<>();

    while (!gameOver) {
      crearTableroReinos(tablero);
      int x, y, x1, y1;
      while (true) {
        System.out.println("Ingrese las coordenadas del ejercito a seleccionar (x, y):");
        System.out.print("x, y: ");
        String coordenadas = sc.nextLine();
        String[] partes = coordenadas.split(",");

        if (coordenadas.equalsIgnoreCase("pause")) {
          pauseMenu2(tablero);
          continue;
        }

        if (partes.length != 2) {
          System.out.println("Entrada inválida. Intente de nuevo.");
          continue;
        }

        x = Integer.parseInt(partes[0]);
        y = Integer.parseInt(partes[1]);

        System.out.println("Ingrese las nuevas coordenadas del Ejercito (x1, y1):");
        System.out.print("x1, y1: ");
        String nuevasCoordenadas = sc.nextLine();
        partes = nuevasCoordenadas.split(",");
        
        if (nuevasCoordenadas.equalsIgnoreCase("pause")) {
          pauseMenu2(tablero);
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
            crearTableroReinos(tablero);
          }
        } else {
          System.out.println("Coordenadas fuera de rango. Intente de nuevo.");
          crearTableroReinos(tablero);
        }
      }

      Ejercito atacante = tablero[x][y];
      Ejercito defensor = tablero[x1][y1];}

     /* if (defensor != null) {
        batallas++;
        if (atacante.getKey() == defensor.getKey()) {
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
  }

  public void miniLogic(Soldado[][] tablero, List<Soldado> todosLosSoldados) {
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
      mostrarTablero(tablero);
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
          Methods.pauseMenu(tablero);
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
            mostrarTablero(tablero);
          }
        } else {
          System.out.println("Coordenadas fuera de rango. Intente de nuevo.");
          mostrarTablero(tablero);
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
    sc.close();*/
  }

  public void Gamesito(Soldado[][] tablero, List<Soldado> todosLosSoldados) {
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
      mostrarTablero(tablero);
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
          Methods.pauseMenu(tablero);
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
            mostrarTablero(tablero);
          }
        } else {
          System.out.println("Coordenadas fuera de rango. Intente de nuevo.");
          mostrarTablero(tablero);
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
  }

  public static void endMenu() {
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

  public static void pauseMenu2(Ejercito[][] tablero) {
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
        NewGame game = new NewGame();
        break;
      case 2:
        // AUN NO EXISTE MENU PRINCIPALNewGame game = new NewGame();
        break;
      case 3:
        System.out.println("Continuando Juego...");
        Methods.crearTableroReinos(tablero);
        break;
      default:
        System.out.println("Opción inválida");
        break;
    }
  }

  public static void pauseMenu(Soldado[][] tablero) {
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

  public static void llenarTablero(Ejercito[][] tablero, Reino reino, Reino reino2) {
    List<Ejercito> ejercitos = reino.getEjercitos();
    List<Ejercito> ejercitos2 = reino2.getEjercitos();

    for (Ejercito ejercito : ejercitos) {
      int fila = (int) (Math.random() * 10);
      int columna = (int) (Math.random() * 10);
      while (tablero[fila][columna] != null) {
        fila = (int) (Math.random() * 10);
        columna = (int) (Math.random() * 10);
      }
      tablero[fila][columna] = ejercito;
    }

    for (Ejercito ejercito : ejercitos2) {
      int fila = (int) (Math.random() * 10);
      int columna = (int) (Math.random() * 10);
      while (tablero[fila][columna] != null) {
        fila = (int) (Math.random() * 10);
        columna = (int) (Math.random() * 10);
      }
      tablero[fila][columna] = ejercito;
    }

    crearTableroReinos(tablero);
  }

  public static void crearTableroReinos(Ejercito[][] tablero) {
    // Imprimir parte de arriba de columnas
    System.out.print("  ");
    for (int j = 0; j < 10; j++) {
      System.out.print("  " + j);
    }
    System.out.println();

    for (int i = 0; i < 10; i++) {
      // Imprimir los números de las filas
      System.out.print(i + "  ");
      for (int j = 0; j < 10; j++) {
        if (tablero[i][j] == null) {
          System.out.print("|_|");
        } else {
          System.out.print("|" + tablero[i][j].getKey() + "|");
        }
      }
      System.out.println();
    }
  }

  public static void mostrarTablero(Soldado[][] tablero) {
    // Imprimir parte de arriba de columnas
    System.out.print("  ");
    for (int j = 0; j < 10; j++) {
      System.out.print("  " + j);
    }
    System.out.println();

    for (int i = 0; i < 10; i++) {
      // Imprimir los números de las filas
      System.out.print(i + "  ");
      for (int j = 0; j < 10; j++) {
        if (tablero[i][j] == null) {
          System.out.print("|_|");
        } else {
          System.out.print("|" + tablero[i][j].getTeam() + "|");
        }
      }
      System.out.println();
    }
  }

  public static void mostrarTablero(Soldado[][] tablero, Soldado s) {
    // Imprimir parte de arriba de columnas
    System.out.print("  ");
    for (int j = 0; j < 10; j++) {
      System.out.print("  " + j);
    }
    System.out.println();

    for (int i = 0; i < 10; i++) {
      // Imprimir los números de las filas
      System.out.print(i + "  ");
      for (int j = 0; j < 10; j++) {
        if (tablero[i][j] == null || tablero[i][j].getTeam() != s.getTeam()) {
          System.out.print("|_|");
        } else {
          System.out.print("|" + tablero[i][j].getTeam() + "|");
        }
      }
      System.out.println();
    }
  }

  public static void verify(Soldado[][] tablero, int x, int y, int x1, int y1) {
    // Verificar si hay un soldado en la posición (x, y)
    if (tablero[x][y] == null) {
      System.out.println("No hay un soldado en la posición (" + x + ", " + y + ")");
      return;
    }

    Soldado soldado = tablero[x][y];
    Soldado otroSoldado = tablero[x1][y1];

    if (otroSoldado == null) {
      // Mover el soldado a la nueva posición vacía
      tablero[x1][y1] = soldado;
      soldado.setFila(x1);
      soldado.setColumna(y1);
      tablero[x][y] = null;
      System.out.println(
          "El soldado " + soldado.getName() + "(" + x + ", " + y + ") se ha movido a (" + x1 + ", " + y1 + ")");
    } else if (soldado.getTeam() == otroSoldado.getTeam()) {
      System.out.println("Ya existe un aliado en la ubicación seleccionada");
    } else {
      // Calcular winrate
      double winRateSoldado = Math.round(calculateWinRate(soldado, otroSoldado));
      double winRateOtroSoldado = Math.round(calculateWinRate(otroSoldado, soldado));

      System.out.println("Porcentaje de winrate del soldado (" + x + ", " + y + "): " + winRateSoldado + "%");
      System.out.println("Porcentaje de winrate del soldado (" + x1 + ", " + y1 + "): " + winRateOtroSoldado + "%");

      // Elegir el real winner
      if (winRateSoldado > winRateOtroSoldado) {
        tablero[x1][y1] = soldado;
        System.out
            .println("El soldado " + soldado.getName() + " en la posición (" + x + ", " + y + ") gano el combate");
        // Mover al soldado ganador a la nueva posición
        soldado.setFila(x1);
        soldado.setColumna(y1);
        soldado.setActHP(soldado.getActHP() + 50);
        tablero[x][y] = null;
      } else {
        tablero[x1][y1] = otroSoldado;
        System.out.println(
            "El soldado " + otroSoldado.getName() + " en la posición (" + x1 + ", " + y1 + ") gano el combate");
        // Mover al soldado ganador a la nueva posición
        otroSoldado.setFila(x1);
        otroSoldado.setColumna(y1);
        otroSoldado.setActHP(otroSoldado.getActHP() + 50);
        tablero[x][y] = null;
      }
    }
  }

  public static double calculateWinRate(Soldado soldado, Soldado otroSoldado) {
    double vidaSoldado = soldado.getActHP();
    double vidaOtroSoldado = otroSoldado.getActHP();
    double atkSoldado = soldado.getAtkLvl();
    double atkOtroSoldado = otroSoldado.getAtkLvl();

    double winRate = (vidaSoldado + atkSoldado) / (vidaSoldado + atkSoldado + vidaOtroSoldado + atkOtroSoldado) * 100;
    return winRate;
  }

  public static int calcularSumaVidaEquipo(Soldado[][] tablero, int equipo) {
    int sumaVida = 0;
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        Soldado s = tablero[i][j];
        if (s != null && s.getTeam() == equipo) {
          sumaVida += s.getActHP();
        }
      }
    }
    return sumaVida;
  }

  public static void imprimirResultadoFinal(Soldado[][] tablero, List<Soldado> todosLosSoldados, int equipoGanador,
      int batallas, Soldado soldadoConMasBajas, Map<Soldado, Integer> bajasPorSoldado) {
    System.out.println("Resultado Final:");
    System.out.println("Equipo Ganador: Ejército " + equipoGanador);
    int soldadosRestantes = 0;
    for (Soldado[] fila : tablero) {
      for (Soldado s : fila) {
        if (s != null && s.getTeam() == equipoGanador) {
          soldadosRestantes++;
        }
      }
    }
    System.out.println("Soldados restantes: " + soldadosRestantes);
    System.out.println("Número de batallas: " + batallas);
    System.out.println("Soldado con más bajas: " + soldadoConMasBajas.getName() + " con "
        + bajasPorSoldado.get(soldadoConMasBajas) + " bajas");

    System.out.println();
    System.out.println("Estadísticas completas de los soldados finales:");

    for (Soldado s : todosLosSoldados) {
      System.out.println(s);
    }
  }
}