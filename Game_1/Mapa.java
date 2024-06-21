public class Mapa {
  private static final String[] territories = { "Bosque", "Campo Abierto", "Montaña", "Desierto", "Playa" };
  private static String exception2 = "";

  public static void setException(String exception) {
    exception2 = exception;
  }

  public static String getException() {
    return exception2;
  }
  
  public Mapa() {
  }

  public static String verifier(String a) {
    String territorio = "";

    switch (a) {
      case "Inglaterra":
        territorio = "Bosque";
        break;
      case "Francia":
        territorio = "Campo Abierto";
        break;
      case "Castilla - Aragon":
        territorio = "Montaña";
        break;
      case "Moros":
        territorio = "Desierto";
        break;
      default:
        territorio = "default";
        break;
    }
    return territorio;
  }

  public static String TerrainBonus(String a, String b) {
    int random = (int) (Math.random() * 5);
    String territory = territories[random];
    String territorioA = Mapa.verifier(a);
    String territorioB = Mapa.verifier(b);

    if (a.equals("Sacro Imperio")) {
      if (territory.equals("Bosque") || territory.equals("Campo Abierto") ||
          territory.equals("Playa")) {
        territorioA = territory;
      }
    }

    if (b.equals("Sacro Imperio")) {
      if (territory.equals("Bosque") || territory.equals("Campo Abierto") ||
          territory.equals("Playa")) {
        territorioA = territory;
      }
    }

    if (territorioA.equals(territorioB)) {
      if(a.equals("Sacro Imperio") || b.equals("Sacro Imperio")){
        Mapa.setException(territorioA);
      }
      System.out.println(
          "El terreno de juego será " + territory
              + ", por lo que ambos reciben un bono de +1 de vida en todos sus soldados.");
      return territorioA;
    }
    if (territorioA.equals(territory)) {
      if(a.equals("Sacro Imperio")){
        Mapa.setException(territorioA);
      }
      System.out.println(
          "El terreno de juego será " + territory + ", por lo que " + a
              + " recibe un bono de +1 de vida en todos sus soldados.");
      return territorioA;
    }
    if (territorioB.equals(territory)) {
      if(b.equals("Sacro Imperio")){
        Mapa.setException(territorioA);
      }
      System.out.println(
          "El terreno de juego será " + territory + ", por lo que " + b
              + " recibe un bono de +1 de vida en todos sus soldados.");
      return territorioB;

    } else {
      System.out.println("El terreno de juego será " + territory + ", por lo que no hay bonos de vida.");
      return "ningun reino";
    }
  }

}
