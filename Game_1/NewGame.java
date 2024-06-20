import java.util.*;

public class NewGame {
  private static final String[] REINOS = { "Inglaterra", "Francia", "Sacro Imperio", "Castilla - Aragon", "Moros" };

  public NewGame() {
    System.out.println("¡Bienvenidos al Juego de Batallas de Reinos PVP!");
    System.out.println();
    System.out.println("Reglas del Juego:");
    System.out.println(
        "1. PvP o Simulación(Jugador contra Jugador o Jugador Contra Simulación): Dos ejércitos se enfrentan en un tablero de 10x10.");
    System.out.println("2. Objetivo: El Reino que quede con ejercitos en el campo gana.");
    System.out.println("3. Movimiento: Selecciona un ejercitos y una nueva posición.");
    System.out.println("4. Combate: Si la nueva posición tiene un enemigo, se combate.");
    System.out.println();
    System.out.println();
    System.out.println("¡Buena Suerte! ¡Que comience el juego!");
    System.out.println();

    List<String> opcionesReinos = new ArrayList<>(Arrays.asList(REINOS));
    Reino reino1 = consulter(opcionesReinos);
    opcionesReinos.remove(reino1.getName());
    Reino reino2 = consulter(opcionesReinos);

    Ejercito[][] tablero1 = new Ejercito[10][10];
    Methods.llenarTablero(tablero1, reino1, reino2);
    List<Ejercito> a = reino1.getEjercitos();
    List<Ejercito> b = reino2.getEjercitos();
    System.out.println("1: Juego Normal");
    System.out.println("2: Juego Personalizado");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    switch (n) {
      case 1:
        Methods.ReinosGameplay(tablero1, a);
        break;
      case 2:
        a = Methods.ReinosGameplayCustom(tablero1, a, b);
        Methods.ReinosGameplay(tablero1, a);
        break;
      default:
        System.out.println("Ingrese una opción valida");
        break;
    }
  }

  public Reino consulter(List<String> opcionesReinos) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("REINOS DISPONIBLES: ");
      for (int i = 0; i < opcionesReinos.size(); i++) {
        System.out.println((char) ('A' + i) + ": " + opcionesReinos.get(i));
      }
      System.out.println("Ingrese la letra del Reino a seleccionar: ");
      String option = sc.nextLine().toUpperCase();
      int index = option.charAt(0) - 'A';

      if (index >= 0 && index < opcionesReinos.size()) {
        String nombreReino = opcionesReinos.get(index);
        Reino reino = new Reino(nombreReino);
        reino.setName(nombreReino);
        return reino;
      } else {
        System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
      }
    }
  }
}
