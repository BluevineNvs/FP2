public class Espadachin extends Soldado {
  private int longitudEspada;

  public Espadachin() {
    super();
    this.longitudEspada = 100; // valor por defecto
  }

  public Espadachin(int x) {
    super();
    this.longitudEspada = x; // valor por defecto
  }

  public Espadachin(String name) {
    super();
    this.longitudEspada = 100; // valor por defecto
  }

  public Espadachin(String name, int atkLvl, int defLvl, int hp, int speed, int team, int longitudEspada) {
    super(name, atkLvl, defLvl, hp, speed, team);
    this.longitudEspada = longitudEspada;
  }

  public int getLongitudEspada() {
    return longitudEspada;
  }

  public void setLongitudEspada(int longitudEspada) {
    this.longitudEspada = longitudEspada;
  }

  public void crearMuroDeEscudos() {
    System.out.println(this.getName() + " ha creado un muro de escudos.");
    this.setDefLvl(this.getDefLvl() + 10); // Aumenta el nivel de defensa temporalmente
  }

  @Override
  public String toString() {
    return super.toString() + ", longitudEspada=" + longitudEspada + "]";
  }
}
