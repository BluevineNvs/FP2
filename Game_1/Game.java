import java.util.*;
class Game {
  public Game(){
    Scanner sc = new Scanner(System.in);
    int select;
    System.out.println("MENÚ PRINCIPAL");
    System.out.println("¡Bienvenidos comandantes, al campo de batalla!");
    System.out.println("Dos ejércitos se alistan para la batalla, y solo uno saldrá victorioso, el úlitmo ejército que quede en pie");
    System.out.println("Cada soldado luchará con el coraje de un héroe, empuñando su arma con destreza y determinación");
    System.out.println("Los ataques resonarán como truenos, mientras las defensas se alzarán como fortalezas impenetrables");
    System.out.println("Y en medio de todo este caos, solo los más fuertes y los más astutos podrán vencer y asegurar su lugar en la historia");
    System.out.println("Que la batalla sea épica y legendaria");

    System.out.println("Elijan con sabiduría la opción que deseen utilizar:");
    System.out.println("1. Juego Rápido");
    System.out.println("2. Juego Personalizado");
    System.out.println("3. Salir");

    System.out.println("Selecciona tu opción");
    select = sc.nextInt();


    switch(select){
      case 1:
        System.out.println("¡Juego Rápido!");
        System.out.println("¡Preparados para la acción inmediata!");
        System.out.println("En este modo, el destino será decidido en una batalla rápida y frenética");
        System.out.println("¡No hay tiempo que perder!");
        Batalla batalla = new Batalla(null);
        break;
      case 2:
        System.out.println("¡Juego Personalizado!");
        System.out.println("¿Buscan un desafío más estratégico?");
        System.out.println("En este modo, podrán personalizar sus ejércitos, ajustando cada detalle para perfeccionar sus estrategias y alcanzar la victoria");
        CustomBattle cb = new CustomBattle();
        cb.CustomBattleT();
        break;
      case 3:
        System.out.println("¡Hasta la próxima, comandantes!");
        System.out.println("Siempre podrán regresar para enfrentar el desafío");
        System.exit(0);
        break;
      default:
        System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
        break;
    }
  }
}