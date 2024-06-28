public class Lancero extends Soldado {
  private int longitudDeLanza;


  public int getLongitudDeLanza() {
    return longitudDeLanza;
  }

  public void setLongitudDeLanza(int longitudDeLanza) {
    this.longitudDeLanza = longitudDeLanza;
  }

  public Lancero() {
    super();
    this.longitudDeLanza = 100; 
  }

  public Lancero(int x) {
    super();
    this.longitudDeLanza = x;
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
