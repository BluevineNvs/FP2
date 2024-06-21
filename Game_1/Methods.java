import java.util.*;

class Methods {
  public static List<Ejercito>[] territorioeineador(String winner, String kingdom1, String kingdom2,
      List<Ejercito> teamA, List<Ejercito> teamB, String reino1Name, String reino2Name) {
    List<Ejercito>[] territorio = new List[2];
    if (winner.equals("ningun reino")) {
      System.out.println("El territorio no favorece a ningun reino");
    }
    if (winner.equals(kingdom1) && winner.equals(kingdom2)) {
      System.out.println("El territorio favorece a ambos reinos");
      for (Ejercito ejercito : teamA) {
        for (Soldado soldado : ejercito.getSoldados()) {
          soldado.setHp(soldado.getHp() + 1);
          soldado.setActHP(soldado.getActHP() + 1);
        }
      }
      for (Ejercito ejercito : teamB) {
        for (Soldado soldado : ejercito.getSoldados()) {
          soldado.setHp(soldado.getHp() + 1);
          soldado.setActHP(soldado.getActHP() + 1);
        }
      }
    }
    if (kingdom1.equals(winner)) {
      System.out.println("El territorio favorece a " + reino1Name);
      for (Ejercito ejercito : teamA) {
        for (Soldado soldado : ejercito.getSoldados()) {
          soldado.setHp(soldado.getHp() + 1);
          soldado.setActHP(soldado.getActHP() + 1);
        }
      }
    }
    if (kingdom2.equals(winner)) {
      System.out.println("El territorio favorece a " + reino2Name);
      for (Ejercito ejercito : teamB) {
        for (Soldado soldado : ejercito.getSoldados()) {
          soldado.setHp(soldado.getHp() + 1);
          soldado.setActHP(soldado.getActHP() + 1);
        }
      }
    }
    territorio[0] = teamA;
    territorio[1] = teamB;
    return territorio;
  }

  public static List<Ejercito> ReinosGameplayCustom(Ejercito[][] tablero, List<Ejercito> teamA, List<Ejercito> teamB) {
    List<Ejercito> todosLosSoldaditos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese Ejercito a Modificar: ");
    System.out.println("1: Ejercito 1");
    System.out.println("2: Ejercito 2");
    int imput = sc.nextInt();
    if (imput == 1) {
      todosLosSoldaditos = teamA;
    } else {
      todosLosSoldaditos = teamB;
    }
    for (Ejercito s : todosLosSoldaditos) {
      System.out.println(s.toString());
    }
    System.out.println("Seleccione la opcion del Juego Personalizado: ");
    System.out.println("1. Modificar Soldados");
    System.out.println("2. Autogenerar Soldados");
    System.out.println("3. Eliminar Soldados");
    sc.nextLine();
    String a = sc.nextLine();
    switch (a) {
      case "1":
        System.out.println("Ingrese el nombre del soldado a modificar: ");
        String nombreBuscado = sc.nextLine();
        Soldado soldadoBuscado = null;

        for (Ejercito ejercito : todosLosSoldaditos) {
          for (Soldado soldado : ejercito.getSoldados()) {
            if (soldado.getName().equals(nombreBuscado)) {
              soldadoBuscado = soldado;
              break;
            }
          }
          if (soldadoBuscado != null) {
            break;
          }
        }

        if (soldadoBuscado != null) {
          System.out.println("Soldado seleccionado: " + soldadoBuscado);

          System.out.println("Ingrese el nuevo nombre del soldado, si no desea cambiarlo, apretar enter: ");
          String newName = sc.nextLine();
          if (!newName.equals("")) {
            soldadoBuscado.setName(newName);
          }

          System.out.println("Ingrese el nuevo nivel de ataque del soldado, si no desea cambiarlo, apretar enter: ");
          String newAtkLvl = sc.nextLine();
          if (!newAtkLvl.equals("")) {
            soldadoBuscado.setAtkLvl(Integer.parseInt(newAtkLvl));
          }

          System.out.println("Ingrese el nuevo nivel de defensa del soldado, si no desea cambiarlo, apretar enter: ");
          String newDefLvl = sc.nextLine();
          if (!newDefLvl.equals("")) {
            soldadoBuscado.setDefLvl(Integer.parseInt(newDefLvl));
          }

          System.out.println("Ingrese los nuevos puntos de vida del soldado, si no desea cambiarlo, apretar enter: ");
          String newHp = sc.nextLine();
          if (!newHp.equals("")) {
            soldadoBuscado.setHp(Integer.parseInt(newHp));
          }

          System.out.println(
              "Ingrese los nuevos puntos de vida actuales del soldado, si no desea cambiarlo, apretar enter: ");
          String newActHP = sc.nextLine();
          if (!newActHP.equals("")) {
            soldadoBuscado.setActHP(Integer.parseInt(newActHP));
          }

          System.out.println("Ingrese la nueva velocidad del soldado, si no desea cambiarlo, apretar enter: ");
          String newSpeed = sc.nextLine();
          if (!newSpeed.equals("")) {
            soldadoBuscado.setSpeed(Integer.parseInt(newSpeed));
          }

          System.out.println("Ingrese la nueva acción del soldado, si no desea cambiarlo, apretar enter: ");
          String newActt = sc.nextLine();
          if (!newActt.equals("")) {
            soldadoBuscado.setActt(newActt);
          }

        } else {
          System.out.println("Soldado no encontrado");
        }
        break;
      case "2":
        System.out.println("Soldados Autogenerados");
        break;
      case "3":
        System.out.println("Ingrese el nombre del soldado a eliminar: ");
        String nombreBuscado2 = sc.nextLine();
        Soldado soldadoBuscado2 = null;

        for (Ejercito ejercito : todosLosSoldaditos) {
          for (Soldado soldado : ejercito.getSoldados()) {
            if (soldado.getName().equals(nombreBuscado2)) {
              soldadoBuscado2 = soldado;
              break;
            }
          }
          if (soldadoBuscado2 != null) {
            break;
          }
        }

        if (soldadoBuscado2 != null) {
          System.out.println("Soldado seleccionado: " + soldadoBuscado2);
          System.out.println("¿Está seguro de que desea eliminar este soldado? (s/n)");
          String confirmacion = sc.nextLine();
          if (confirmacion.equals("s")) {
            for (Ejercito ejercito : todosLosSoldaditos) {
              ejercito.getSoldados().remove(soldadoBuscado2);
            }
            System.out.println("Soldado eliminado con éxito");
          } else {
            System.out.println("Operación cancelada");
          }
        } else {
          System.out.println("Soldado no encontrado");
        }
        break;

      default:
        System.out.println("Opción no valida");
        break;
    }
    return todosLosSoldaditos;
  }

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
    System.out.println("En caso quieras ver las estadísticas de los soldados, ingresa 'info' en cualquier momento :)");
    System.out.println();
    System.out.println("¡Buena Suerte! ¡Que comience el juego!");
    System.out.println();

    Scanner sc = new Scanner(System.in);
    boolean gameOver = false;

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

        if (coordenadas.equalsIgnoreCase("info")) {
          List<Soldado> todosLosSoldad = new ArrayList<>();
          for (Ejercito ejercito : todosLosSoldados) {
            for (Soldado soldado : ejercito.getSoldados()) {
              todosLosSoldad.add(soldado);
            }
          }
          info(todosLosSoldad);
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

        if (coordenadas.equalsIgnoreCase("info")) {
          List<Soldado> todosLosSoldad = new ArrayList<>();
          for (Ejercito ejercito : todosLosSoldados) {
            for (Soldado soldado : ejercito.getSoldados()) {
              todosLosSoldad.add(soldado);
            }
          }
          info(todosLosSoldad);
          continue;
        }

        if (partes.length != 2) {
          System.out.println("Entrada inválida. Intente de nuevo.");
          continue;
        }

        x1 = Integer.parseInt(partes[0]);
        y1 = Integer.parseInt(partes[1]);

        System.out.println("AL ATAQUE!!!...");

        if (x >= 0 && x < 10 && y >= 0 && y < 10 && x1 >= 0 && x1 < 10 && y1 >= 0 && y1 < 10) {
          if (tablero[x][y] != null) {
            break;
          } else {
            System.out.println("No hay un Ejercito en la posición inicial. Intente de nuevo.");
            crearTableroReinos(tablero);
          }
        } else {
          System.out.println("Coordenadas fuera de rango. Intente de nuevo.");
          crearTableroReinos(tablero);
        }
      }

      Ejercito atacante = tablero[x][y];
      Ejercito defensor = tablero[x1][y1];

      if (atacante.getKey() == defensor.getKey()) {
        System.out.println("No puedes atacar a un aliado. Intente de nuevo.");
        continue;
      }
      Ejercito winner = Methods.attack(atacante, defensor);
      if (winner == atacante) {
        tablero[x1][y1] = atacante;
        tablero[x][y] = null;
        System.out.println(
            "El ejercito " + atacante.getKey() + " gano el combate, ahora ocupa la posicion (" + x1 + ", " + y1 + ")");
        for (Soldado s : atacante.getSoldados()) {
          s.setActHP(s.getActHP() + 1);
        }
      } else {
        tablero[x][y] = null;
        System.out.println("El ejercito " + defensor.getKey()
            + " gano el combate y seguira ocupando la misma posicion (" + x1 + ", " + y1 + ")");
        for (Soldado s : defensor.getSoldados()) {
          s.setActHP(s.getActHP() + 1);
        }
      }
      // Verificar si el juego ha terminado
      int sumaVid1 = Methods.calcularSoldadosVivos(tablero, atacante.getKey());
      int sumaVid2 = Methods.calcularSoldadosVivos(tablero, defensor.getKey());
      if (sumaVid1 == 0) {
        Methods.crearTableroReinos(tablero);
        System.out.println("El Reino " + defensor.getName() + " gana la batalla");
        gameOver = true;
      } else if (sumaVid2 == 0) {
        Methods.crearTableroReinos(tablero);
        System.out.println("El Reino " + atacante.getName() + " gana la batalla");
        gameOver = true;
      }
    }
    System.out.println("El juego a Finalizado. ¡Gracias por jugar!");
    endMenu2();
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
    sc.close();
  }

  public static void info(List<Soldado> todosLosSoldados) {
    Soldado mayorVidaEj1 = null;
    Soldado mayorVidaEj2 = null;
    for (Soldado s : todosLosSoldados) {
      if (s.getName().startsWith("SoldadoEj1_") && (mayorVidaEj1 == null || s.getHp() > mayorVidaEj1.getHp())) {
        mayorVidaEj1 = s;
      }
      if (s.getName().startsWith("SoldadoEj2_") && (mayorVidaEj2 == null || s.getHp() > mayorVidaEj2.getHp())) {
        mayorVidaEj2 = s;
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

    for (Soldado s : todosLosSoldados) {
      if (s.getName().startsWith("SoldadoEj1_")) {
        sumaEj1 += s.getHp();
        countEj1++;
      } else {
        sumaEj2 += s.getHp();
        countEj2++;
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

    for (Soldado s : todosLosSoldados) {
      if (s.getName().startsWith("SoldadoEj1_")) {
        soldadosEj1.add(s);
      } else {
        soldadosEj2.add(s);
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
  }

  public static List<Soldado> autoSelectWinner(List<Soldado> Army1, List<Soldado> Army2) {
    // Select winner
    int sumaVidaEj1 = 0;
    for (Soldado s : Army1) {
      sumaVidaEj1 += s.getHp();
    }

    int sumaVidaEj2 = 0;
    for (Soldado s : Army2) {
      sumaVidaEj2 += s.getHp();
    }

    System.out.println();
    System.out.println();
    System.out.println("-----------------------------");
    System.out.println();
    System.out.println("EN BASE A LOS PUNTOS DE VIDA:" + sumaVidaEj1 + " VS " + sumaVidaEj2);
    System.out.println();
    if (sumaVidaEj1 > sumaVidaEj2) {
      return Army1;
    } else if (sumaVidaEj2 > sumaVidaEj1) {
      return Army2;
    } else {
      System.out.println("Empate");
      return null;
    }
  }

  public static Ejercito attack(Ejercito a, Ejercito b) {
    List<Soldado> Army1 = a.getSoldados();
    List<Soldado> Army2 = b.getSoldados();

    if (Army1 != null && Army2 != null) {
      // Inicializar tablero
      Soldado[][] tablero = new Soldado[10][10];
      List<Soldado> todosLosSoldados = new ArrayList<>();

      // Army 1
      for (Soldado s : Army1) {
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
      for (Soldado s : Army2) {
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

      System.out.println("Seleccione el tipo de Juego: ");
      System.out.println("1. Juego Automatico");
      System.out.println("2. Juego Manual");
      Scanner sc = new Scanner(System.in);
      int option = sc.nextInt();
      if (option == 1) {
        List<Soldado> automaticWinner = Methods.autoSelectWinner(Army1, Army2);
        if (automaticWinner == Army1) {
          return a;
        } else if (automaticWinner == Army2) {
          return b;
        }
      } else {
        // Lógica de combate
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
            sc.nextLine();
            String coordenadas = sc.nextLine();
            String[] partes = coordenadas.split(",");

            if (coordenadas.equalsIgnoreCase("pause")) {
              Methods.pauseMenu(tablero);
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
            System.out
                .println("El atacante " + atacante.getName() + " tiene una probabilidad de " + winRateAtacante + "%");
            System.out
                .println("El defensor " + defensor.getName() + " tiene una probabilidad de " + winRateDefensor + "%");
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
                  "El combate estuvo tan reñido, ya que ambos combatientes tenían un porcentaje del 50% de ganar, así que ambos mueren en la batalla.");
            } else if (winRateAtacante > winRateDefensor) {
              atacante.attack(defensor);
              tablero[x1][y1] = atacante;
              tablero[x][y] = null;
              atacante.setFila(x1);
              atacante.setColumna(y1);
              atacante.setActHP(atacante.getHp() + 1);
              bajasPorSoldado.put(atacante, bajasPorSoldado.getOrDefault(atacante, 0) + 1);
              if (soldadoConMasBajas == null
                  || bajasPorSoldado.get(atacante) > bajasPorSoldado.get(soldadoConMasBajas)) {
                soldadoConMasBajas = atacante;
              }
            } else {
              tablero[x][y] = null;
              atacante.attack(defensor, winRateAtacante, winRateDefensor);
              bajasPorSoldado.put(defensor, bajasPorSoldado.getOrDefault(defensor, 0) + 1);
              if (soldadoConMasBajas == null
                  || bajasPorSoldado.get(defensor) > bajasPorSoldado.get(soldadoConMasBajas)) {
                soldadoConMasBajas = defensor;
              }
            }
          } else {
            tablero[x1][y1] = atacante;
            System.out
                .println("El soldado " + atacante.getName() + " ahora ocupa la posición (" + x1 + ", " + y1 + ")");
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
            return b;
          } else if (sumaVid2 == 0) {
            Methods.mostrarTablero(tablero);
            System.out.println("El Ejercito 1 gana la batalla");
            gameOver = true;
            Methods.imprimirResultadoFinal(tablero, todosLosSoldados, 1, batallas, soldadoConMasBajas, bajasPorSoldado);
            return a;
          }
        }
      }
    }
    return null;
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
    endMenu2();
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

  public static void endMenu2() {
    Scanner sc = new Scanner(System.in);
    System.out.println("MENU: ");
    System.out.println("1. Jugar de Nuevo");
    System.out.println("2. Salir");
    System.out.println();
    System.out.println("Selecciona tu opción");
    int z = sc.nextInt();
    switch (z) {
      case 1:
        NewGame game = new NewGame();
        break;
      case 2:
        System.out.println("Saliendo del Juego...");
        System.exit(0);
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
    System.out.println("2. Continuar Juego");
    System.out.println("3. Salir");
    System.out.println();
    System.out.println("Selecciona tu opción");
    int z = sc.nextInt();
    switch (z) {
      case 1:
        NewGame game = new NewGame();
        break;
      case 2:
        System.out.println("Continuando Juego...");
        Methods.crearTableroReinos(tablero);
        break;
      case 3:
        System.out.println("Saliendo del Juego...");
        System.exit(0);
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

  public static int calcularSoldadosVivos(Ejercito[][] tablero, String key) {
    int soldados = 0;
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        Ejercito s = tablero[i][j];
        if (s != null && s.getKey() == key) {
          soldados += 1;
        }
      }
    }
    return soldados;
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