package Game_2;

class Soldado {
  private String name;
  private int atkLvl;
  private int defLvl;
  private int hp;
  private int actHP;
  private int speed;
  private String actt;
  private boolean live;
  private int fila;
  private int columna;
  private int team;

  public int getFila() {
    return fila;
  }

  public void setFila(int fila) {
    this.fila = fila;
  }

  public int getColumna() {
    return columna;
  }

  public void setColumna(int columna) {
    this.columna = columna;
  }

  public int getTeam() {
    return team;
  }

  public void setTeam(int team) {
    this.team = team;
  }

  @Override
  public String toString() {
    return "Soldado [name=" + name + ", atkLvl=" + atkLvl + ", defLvl=" + defLvl + ", hp=" + hp + ", actHP=" + actHP
        + ", speed=" + speed + ", actt=" + actt + ", live=" + live + ", fila=" + fila + ", columna=" + columna + "]";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAtkLvl() {
    return atkLvl;
  }

  public void setAtkLvl(int atkLvl) {
    this.atkLvl = atkLvl;
  }

  public int getDefLvl() {
    return defLvl;
  }

  public void setDefLvl(int defLvl) {
    this.defLvl = defLvl;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public int getActHP() {
    return actHP;
  }

  public void setActHP(int actHP) {
    this.actHP = actHP;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public String getActt() {
    return actt;
  }

  public void setActt(String actt) {
    this.actt = actt;
  }

  public boolean isLive() {
    return live;
  }

  public void setLive(boolean live) {
    this.live = live;
  }

  // Method Call Chaining
  public Soldado sumar(Soldado otro) {
    Soldado result = new Soldado();
    result.setAtkLvl(this.atkLvl + otro.atkLvl);
    result.setDefLvl(this.defLvl + otro.defLvl);
    result.setHp(this.hp + otro.hp);
    result.setActHP(this.actHP + otro.actHP);
    return result;
  }

  public Soldado(int y) {
    this.team = y;
    this.hp = 100;
    this.actHP = 100;
    this.speed = 1;
    this.actt = "Neutral";
    this.live = true;
  }

  public Soldado() {
    this.name = "Soldado";
    this.atkLvl = 1;
    this.defLvl = 1;
    this.hp = 100;
    this.actHP = 100;
    this.speed = 1;
    this.actt = "Neutral";
    this.live = true;
  }

  public Soldado(String name, int defLvl, int atkLvl, int hp) {
    this.name = name;
    this.atkLvl = atkLvl;
    this.defLvl = defLvl;
    this.hp = hp;
    this.actHP = hp;
    this.speed = 1;
    this.actt = "Neutral";
    this.live = true;
  }

  public Soldado(String name, int atkLvl, int defLvl, int hp, int speed, int team) {
    this.name = name;
    this.atkLvl = atkLvl;
    this.defLvl = defLvl;
    this.hp = 100;
    this.actHP = hp;
    this.speed = speed;
    this.team = team;
  }

  public Soldado(String name, int atkLvl, int defLvl, int hp, int speed, int team, int fila, int columna) {
    this.name = name;
    this.atkLvl = atkLvl;
    this.defLvl = defLvl;
    this.hp = 100;
    this.actHP = hp;
    this.speed = speed;
    this.team = team;
    this.fila = fila;
    this.columna = columna;
  }

  public Soldado(String name, int atkLvl, int defLvl, int hp, int speed, String actt, boolean live) {
    this.name = name;
    this.atkLvl = atkLvl;
    this.defLvl = defLvl;
    this.hp = 100;
    this.actHP = hp;
    this.speed = speed;
    this.actt = actt;
    this.live = live;
  }

  public void huir() {
    this.actt = "Fuga";
    this.speed += 2;
  }

  public void morir() {
    this.actHP = 0;
    this.actt = "Muerto";
    this.live = false;

  }

  public void attack(Soldado b) {
    double winRateAtacante = Methods.calculateWinRate(this, b);
    double winRateDefensor = 100 - winRateAtacante;
    System.out.println("El soldado: " + this.name + " ataca al soldado: " + b.getName()
        + " con una probabilidad de victoria de: " + winRateAtacante + "%");
    if (winRateAtacante / 2 > winRateDefensor) {
      System.out.println();
      System.out.println("El soldado: " + b.getName() + " ha huido de la batalla");
      b.huir();
    } else {
      this.actt = "Offensive";
      this.speed += 1;
      b.actt = "Defensive";
      b.setSpeed(0);
      if (winRateAtacante > winRateDefensor) {
        System.out.println("El soldado: " + this.name + " ha matado al soldado enemigo: " + b.getName());
        b.morir();
      } else {
        if (winRateAtacante < winRateDefensor) {
          this.morir();
          System.out.println("El soldado: " + this.name + " ha muerto a manos del soldado: " + b.getName());
        }
      }
    }
  }

  public void attack(Soldado b, double winRateAtacante, double winRateDefensor) {
    System.out.println("El soldado: " + this.name + " ataca al soldado: " + b.getName()
        + " con una probabilidad de victoria de: " + winRateAtacante + "%");
    if (winRateAtacante / 2 > winRateDefensor) {
      System.out.println();
      System.out.println("El soldado: " + b.getName() + " ha huido de la batalla");
      b.huir();
    } else {
      this.actt = "Offensive";
      this.speed += 1;
      b.actt = "Defensive";
      b.setSpeed(0);
      if (winRateAtacante > winRateDefensor) {
        System.out.println("El soldado: " + this.name + " ha matado al soldado enemigo: " + b.getName());
        b.morir();
      } else {
        if (winRateAtacante < winRateDefensor) {
          this.morir();
          System.out.println("El soldado: " + this.name + " ha muerto a manos del soldado: " + b.getName());
        }
      }
    }
  }
}