public class Exec{
  public static void main(String[] args) {
    Soldado Juan = new Soldado("Juan", 50, 150, 120);
    Soldado Pedro = new Soldado("Pedro", 200, 60, 100);

    System.out.println(Juan.toString());
    System.out.println(Pedro.toString());
    Juan.attack(Pedro);
    System.out.println(Juan.toString());
    System.out.println(Pedro.toString());
  }
}