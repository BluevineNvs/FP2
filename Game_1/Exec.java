public class Exec{
  public static void main(String[] args) {
    Soldado Juan = new Soldado("Juan", 50, 150, 120);
    Soldado Pedro = new Soldado("Pedro", 400, 300, 200);
    Soldado Diego = new Soldado();

    System.out.println(Juan.toString());
    System.out.println(Pedro.toString());
    System.out.println(Diego.toString());
    Juan.attack(Pedro);
    Diego.morir();
    System.out.println(Juan.toString());
    System.out.println(Pedro.toString());
    System.out.println(Diego.toString());
  }
}