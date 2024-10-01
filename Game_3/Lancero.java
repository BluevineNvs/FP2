public class Lancero extends Soldado {
  private int longitudDeLanza;
  private String ArmyName;

  public String getArmyName() {
    return ArmyName;
  }

  public void setArmyName(String armyName) {
    this.ArmyName = armyName;
  }


  public int getLongitudDeLanza() {
    return longitudDeLanza;
  }

  public void setLongitudDeLanza(int longitudDeLanza) {
    this.longitudDeLanza = longitudDeLanza;
  }

  public Lancero() {
    super();
    this.longitudDeLanza = 100; 
    this.setType("Lancero");
  }

  public Lancero(int x) {
    super();
    this.longitudDeLanza = x;
    this.setType("Lancero");
  }

  public void Schiltrom(){
    System.out.println(this.getName() + " ha hecho Schiltrom.");
    super.setDefLvl(super.getDefLvl() + 1);
  }

  @Override
  public String toString() {
    return super.toString() + ", longitudLanza=" + longitudDeLanza + "]";
  }
}
