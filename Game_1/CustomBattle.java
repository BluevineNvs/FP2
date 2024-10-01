import java.util.*;

public class CustomBattle {
  private Soldado[][] tablero;
  private List<Soldado> soldadosTeam1;
  private List<Soldado> soldadosTeam2;
  private List<Soldado> todosLosSoldados;
  private Scanner sc;

  public CustomBattle() {
    tablero = new Soldado[10][10];
    soldadosTeam1 = new ArrayList<>();
    soldadosTeam2 = new ArrayList<>();
    todosLosSoldados = new ArrayList<>();
    sc = new Scanner(System.in);
  }

  public void CustomBattleT() {
    // Inicializar los ejércitos
    int n = (int) (Math.random() * 9) + 1;
    int x = (int) (Math.random() * 9) + 1;

    // Army 1
    for (int i = 0; i < n; i++) {
      Soldado s = new Soldado();
      s.setName("SoldadoEj1_" + i);
      s.setHp((int) (Math.random() * 5) + 1);
      s.setActHP((int) (Math.random() * 5) + 1);
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
      soldadosTeam1.add(s);
    }

    // Army 2
    for (int i = 0; i < x; i++) {
      Soldado s = new Soldado();
      s.setName("SoldadoEj2_" + i);
      s.setHp((int) (Math.random() * 5) + 1);
      s.setActHP((int) (Math.random() * 5) + 1);
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
      soldadosTeam2.add(s);
    }

    // Mostrar los datos de los ejércitos
    Methods.mostrarTablero(tablero);
    gestionarEjercitos();
  }

  private void gestionarEjercitos() {
    boolean salir = false;
    while (!salir) {
      System.out.println("Selecciona el ejército a gestionar:");
      System.out.println("1. Ejército 1");
      System.out.println("2. Ejército 2");
      System.out.println("3. Ver Tablero");
      System.out.println("4. Jugar");
      System.out.println("5. Volver");
      int opcion = sc.nextInt();
      sc.nextLine(); // Clear the buffer
      List<Soldado> ejercito = null;

      switch (opcion) {
        case 1:
          ejercito = soldadosTeam1;
          break;
        case 2:
          ejercito = soldadosTeam2;
          break;
        case 3:
          Methods.mostrarTablero(tablero);
          gestionarEjercitos();
          return;
        case 4:
          jugar();
          return;
        case 5:
          new Game();
          continue;
        default:
          System.out.println("Opción inválida. Intente de nuevo.");
          continue;
      }

      if (ejercito != null) {
        gestionarEjercito(ejercito);
      }
    }
  }

  private void gestionarEjercito(List<Soldado> ejercito) {
    boolean salir = false;
    while (!salir) {
      System.out.println("Selecciona una opción:");
      System.out.println("a) Crear Soldado");
      System.out.println("b) Eliminar Soldado");
      System.out.println("c) Clonar Soldado");
      System.out.println("d) Modificar Soldado");
      System.out.println("e) Comparar Soldados");
      System.out.println("f) Intercambiar Soldados");
      System.out.println("g) Ver soldado");
      System.out.println("h) Ver ejército");
      System.out.println("i) Sumar niveles");
      System.out.println("j) Volver");
      String opcion = sc.nextLine();

      switch (opcion.toLowerCase()) {
        case "a":
          crearSoldado(ejercito);
          break;
        case "b":
          eliminarSoldado(ejercito);
          break;
        case "c":
          clonarSoldado(ejercito);
          break;
        case "d":
          modificarSoldado(ejercito);
          break;
        case "e":
          compararSoldados(ejercito);
          break;
        case "f":
          intercambiarSoldados(ejercito);
          break;
        case "g":
          verSoldado(ejercito);
          break;
        case "h":
          verEjercito(ejercito);
          break;
        case "i":
          sumarNiveles(ejercito);
          break;
        case "j":
          salir = true;
          break;
        default:
          System.out.println("Opción inválida. Intente de nuevo.");
      }
    }
  }

  private void crearSoldado(List<Soldado> ejercito) {
    if (ejercito.size() == 10) {
      System.out.println("No se pueden agregar más soldados");
      return;
    }
    System.out.print("Nombre: ");
    String name = sc.nextLine();
    System.out.print("Nivel de Ataque: ");
    int atk = sc.nextInt();
    System.out.print("Nivel de Defensa: ");
    int def = sc.nextInt();
    System.out.print("Nivel de Vida: ");
    int hp = sc.nextInt();
    System.out.print("Velocidad: ");
    int speed = sc.nextInt();
    sc.nextLine(); // Clear the buffer
    int team = ejercito == soldadosTeam1 ? 1 : 2;
    newSoldier(tablero, name, atk, def, hp, speed, team, todosLosSoldados, ejercito);
  }

  private void eliminarSoldado(List<Soldado> ejercito) {
    if (ejercito.size() <= 1) {
      System.out.println("No se puede eliminar el último soldado del ejército");
      return;
    }
    verEjercito(ejercito);
    System.out.print("Índice del soldado a eliminar: ");
    int index = sc.nextInt();
    sc.nextLine(); // Clear the buffer
    if (index >= 0 && index < ejercito.size()) {
      Soldado soldado = ejercito.remove(index);
      tablero[soldado.getFila()][soldado.getColumna()] = null;
      todosLosSoldados.remove(soldado);
    } else {
      System.out.println("Índice inválido.");
    }
  }

  private void clonarSoldado(List<Soldado> ejercito) {
    if (ejercito.size() == 10) {
      System.out.println("No se pueden agregar más soldados");
      return;
    }
    verEjercito(ejercito);
    System.out.print("Índice del soldado a clonar: ");
    int index = sc.nextInt();
    sc.nextLine(); // Clear the buffer
    if (index >= 0 && index < ejercito.size()) {
      cloneSoldier(tablero, todosLosSoldados, ejercito, index);
    } else {
      System.out.println("Índice inválido.");
    }
  }

  private void modificarSoldado(List<Soldado> ejercito) {
    verEjercito(ejercito);
    System.out.print("Índice del soldado a modificar: ");
    int index = sc.nextInt();
    sc.nextLine(); // Clear the buffer
    if (index >= 0 && index < ejercito.size()) {
      Soldado soldado = ejercito.get(index);
      System.out.println("Selecciona el atributo a modificar:");
      System.out.println("1. Nombre");
      System.out.println("2. Nivel de Ataque");
      System.out.println("3. Nivel de Defensa");
      System.out.println("4. Vida Actual");
      int atributo = sc.nextInt();
      System.out.print("Nuevo valor: ");
      String nuevoValor = sc.next();
      sc.nextLine(); // Clear the buffer
      switch (atributo) {
        case 1:
          soldado.setName(nuevoValor);
          break;
        case 2:
          soldado.setAtkLvl(Integer.parseInt(nuevoValor));
          break;
        case 3:
          soldado.setDefLvl(Integer.parseInt(nuevoValor));
          break;
        case 4:
          soldado.setActHP(Integer.parseInt(nuevoValor));
          break;
        default:
          System.out.println("Atributo no válido");
      }
    } else {
      System.out.println("Índice inválido.");
    }
  }

  private void compararSoldados(List<Soldado> ejercito) {
    verEjercito(ejercito);
    System.out.print("Índice del primer soldado a comparar: ");
    int index1 = sc.nextInt();
    System.out.print("Índice del segundo soldado a comparar: ");
    int index2 = sc.nextInt();
    sc.nextLine(); // Clear the buffer
    if (index1 >= 0 && index1 < ejercito.size() && index2 >= 0 && index2 < ejercito.size()) {
      Soldado s1 = ejercito.get(index1);
      Soldado s2 = ejercito.get(index2);
      System.out.println("Comparación entre " + s1.getName() + " y " + s2.getName());
      System.out.println("Nivel de Ataque: " + s1.getAtkLvl() + " vs " + s2.getAtkLvl());
      System.out.println("Nivel de Defensa: " + s1.getDefLvl() + " vs " + s2.getDefLvl());
      System.out.println("Vida Actual: " + s1.getActHP() + " vs " + s2.getActHP());
    } else {
      System.out.println("Índices inválidos.");
    }
  }

  private void intercambiarSoldados(List<Soldado> ejercito) {
    verEjercito(ejercito);
    Soldado b = ejercito.get(0);
    Methods.mostrarTablero(tablero, b);
    System.out.print("Índice del primer soldado a intercambiar: ");
    int index1 = sc.nextInt();
    System.out.print("Índice del segundo soldado a intercambiar: ");
    int index2 = sc.nextInt();
    sc.nextLine(); // Clear the buffer
    if (index1 >= 0 && index1 < ejercito.size() && index2 >= 0 && index2 < ejercito.size()) {
      Collections.swap(ejercito, index1, index2);
    } else {
      System.out.println("Índices inválidos.");
    }
    Methods.mostrarTablero(tablero, b);
  }

  private void verSoldado(List<Soldado> ejercito) {
    verEjercitoL(ejercito);
    System.out.print("Índice del soldado a ver: ");
    int index = sc.nextInt();
    sc.nextLine(); // Clear the buffer
    if (index >= 0 && index < ejercito.size()) {
      Soldado soldado = ejercito.get(index);
      System.out.println("Soldado: " + soldado.getName());
      System.out.println("Nivel de Ataque: " + soldado.getAtkLvl());
      System.out.println("Nivel de Defensa: " + soldado.getDefLvl());
      System.out.println("Vida Actual: " + soldado.getActHP());
    } else {
      System.out.println("Índice inválido.");
    }
  }

  private void verEjercito(List<Soldado> ejercito) {
    System.out.println("Ejército:");
    for (int i = 0; i < ejercito.size(); i++) {
      Soldado s = ejercito.get(i);
      System.out.println(i + ": " + s.getName() + " (Vida: " + s.getActHP() + ", Ataque: " + s.getAtkLvl()
          + ", Defensa: " + s.getDefLvl() + ", Fila: " + s.getFila() + ", Columna: " + s.getColumna() + ")");
    }
  }

  private void verEjercitoL(List<Soldado> ejercito) {
    System.out.println("Ejército:");
    for (int i = 0; i < ejercito.size(); i++) {
      Soldado s = ejercito.get(i);
      System.out.println(i + ": " + s.getName());
    }
  }

  private void sumarNiveles(List<Soldado> ejercito) {
    if (ejercito.isEmpty()) {
      System.out.println("El ejército no tiene soldados.");
      return;
    }

    Soldado sumatoria = ejercito.get(0);

    for (int i = 1; i < ejercito.size(); i++) {
      sumatoria = sumatoria.sumar(ejercito.get(i));
    }

    System.out.println("Sumatoria de niveles del ejército:");
    System.out.println("Nivel de Ataque: " + sumatoria.getAtkLvl());
    System.out.println("Nivel de Defensa: " + sumatoria.getDefLvl());
    System.out.println("Vida Actual: " + sumatoria.getActHP());
    System.out.println("Velocidad: " + sumatoria.getSpeed());
  }

  private void jugar() {
    // Lógica del juego
    System.out.println("Iniciando el juego...");
    new Batalla(tablero);
  }

  public static void newSoldier(Soldado[][] tablero, String name, int atk, int def, int hp, int speed, int team,
      List<Soldado> todosLosSoldados, List<Soldado> ejercito) {
    int fila, col;
    do {
      fila = (int) (Math.random() * 10);
      col = (int) (Math.random() * 10);
    } while (tablero[fila][col] != null);

    Soldado s = new Soldado(name, atk, def, hp, speed, team, fila, col);
    tablero[fila][col] = s;
    todosLosSoldados.add(s);
    ejercito.add(s);
  }

  public static void cloneSoldier(Soldado[][] tablero, List<Soldado> todosLosSoldados, List<Soldado> ejercito,
      int index) {
    Soldado original = ejercito.get(index);
    String name = original.getName() + "_clon";
    int atk = original.getAtkLvl();
    int def = original.getDefLvl();
    int hp = original.getActHP();
    int speed = original.getSpeed();
    int team = original.getTeam();

    int fila, col;
    do {
      fila = (int) (Math.random() * 10);
      col = (int) (Math.random() * 10);
    } while (tablero[fila][col] != null);

    Soldado clon = new Soldado(name, atk, def, hp, speed, team, fila, col);
    tablero[fila][col] = clon;
    todosLosSoldados.add(clon);
    ejercito.add(clon);
  }
}