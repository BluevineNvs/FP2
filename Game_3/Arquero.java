public class Arquero extends Soldado {
  private int numFlechas;
  private String ArmyName;

  public String getArmyName() {
    return ArmyName;
  }

  public void setArmyName(String armyName) {
    this.ArmyName = armyName;
  }

  public Arquero(int x) {
    super();
    this.numFlechas = x; // valor por defecto
    this.setType("Arquero");
  }

  public Arquero(String name, int atkLvl, int defLvl, int hp, int speed, int team, int numFlechas) {
    super(name, atkLvl, defLvl, hp, speed, team);
    this.numFlechas = numFlechas;
    this.setType("Arquero");
  }

  public int getNumFlechas() {
    return numFlechas;
  }

  public void setNumFlechas(int numFlechas) {
    this.numFlechas = numFlechas;
  }

  public void dispararFlecha(Soldado enemigo) {
    if (numFlechas > 0) {
      System.out.println(this.getName() + " dispara una flecha a " + enemigo.getName());
      enemigo.setActHP(enemigo.getActHP() - this.getAtkLvl());
      this.numFlechas--;
    } else {
      System.out.println(this.getName() + " no tiene flechas.");
    }
  }

  @Override
  public String toString() {
    return super.toString() + ", numFlechas=" + numFlechas + "]";
  }
}
