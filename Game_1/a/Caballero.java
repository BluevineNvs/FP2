public class Caballero extends Soldado {
  private boolean montado;
  private String arma; // Puede ser "espada" o "lanza"

  public Caballero() {
    super();
    this.montado = true; // valor por defecto
    this.arma = "lanza esquirlada"; // valor por defecto
  }

  public Caballero(int a, int b) {
    super();
    switch (a) {
      case 1:
        this.montado = true;
        break;
      case 2:
        this.montado = false;
        break;
    }
    switch (b) {
      case 1:
        this.arma = "Espada Esquirlada";
        break;
      case 2:
        this.arma = "Lanza Esquirlada";
        break;
    }
  }

  public Caballero(String name, int atkLvl, int defLvl, int hp, int speed, int team, boolean montado, String arma) {
    super(name, atkLvl, defLvl, hp, speed, team);
    this.montado = montado;
    this.arma = arma;
  }

  public boolean isMontado() {
    return montado;
  }

  public void setMontado(boolean montado) {
    this.montado = montado;
  }

  public String getArma() {
    return arma;
  }

  public void setArma(String arma) {
    this.arma = arma;
  }

  public void desmontar() {
    if (montado) {
      System.out.println(this.getName() + " desmonta.");
      this.montado = false;
      this.setActt("Defense");
      this.arma = "espada";
      this.setDefLvl(this.getDefLvl() + 5); // Aumenta defensa al desmontar
    } else {
      System.out.println(this.getName() + " ya está desmontado.");
    }
  }

  public void montar(Soldado enemigo) {
    if (!montado) {
      System.out.println(this.getName() + " monta.");
      this.montado = true;
      this.arma = "lanza";
      this.setSpeed(this.getSpeed() + 2); // Aumenta velocidad al montar
      this.envestir(enemigo);
    } else {
      System.out.println(this.getName() + " ya está montado.");
    }
  }

  public void envestir(Soldado enemigo) {
    if (montado) {
      System.out.println(this.getName() + " envestir a " + enemigo.getName() + " tres veces.");
      for (int i = 0; i < 3; i++) {
        this.attack(enemigo);
      }
    } else {
      System.out.println(this.getName() + " envestir a " + enemigo.getName() + " dos veces.");
      for (int i = 0; i < 2; i++) {
        this.attack(enemigo);
      }
    }
  }

  @Override
  public String toString() {
    return super.toString() + ", montado=" + montado + ", arma=" + arma + "]";
  }
}
