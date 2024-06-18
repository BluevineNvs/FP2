import java.util.*;

public class NewGame {
  public NewGame() {
    Reino reino1 = consulter();
    Reino reino2 = consulter();
    while ((reino1.getName().equals(reino2.getName()) == true)) {
      System.out.println("No puedes seleccionar el mismo reino dos veces.");
      reino2 = consulter();
    }
    Ejercito[][] tablero1 = new Ejercito[10][10];
    Methods.llenarTablero(tablero1, reino1, reino2);
    List<Ejercito> a = reino1.getEjercitos();
    Methods.ReinosGameplay(tablero1, a);

  }

  public Reino consulter() {
    while (true) {
      System.out.println("REINOS DISPONIBLES: ");
      System.out.println("A: Inglaterra");
      System.out.println("B: Francia");
      System.out.println("C: Sacro Imperio");
      System.out.println("D: Castilla - Aragon");
      System.out.println("E: Moros");
      System.out.println("Ingrese la letra del Reino a seleccionar: ");
      Scanner sc = new Scanner(System.in);
      String option = sc.nextLine().toUpperCase();
      Reino reino = null;
      switch (option) {
        case "A":
          reino = new Reino("Ingles");
          reino.setName("Inglaterra");
          return reino;
        case "B":
          reino = new Reino("Frances");
          reino.setName("Francia");
          return reino;
        case "C":
          reino = new Reino("Sacro Imperiano");
          reino.setName("Sacro Imperio");
          return reino;
        case "D":
          reino = new Reino("Castillano");
          reino.setName("Castilla - Aragon");
          return reino;
        case "E":
          reino = new Reino("Moroso");
          reino.setName("Moros");
          return reino;
        default:
          System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
      }
    }
  }
}
