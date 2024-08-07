import java.util.*;

public class Ejercito {
  private String key;
  private List<Soldado> misSoldados;
  private String name;
  private int z;

  public String getName() {
    return name;
  }

  public String getKey() {
    return key;
  }

  public Ejercito(String name, String key, int z) {
    this.name = name;
    this.key = key;
    this.misSoldados = gen_ejercito(name);
    this.z = z + 1;
  }

  @Override
  public String toString() {
    String result = "Ejercito [name=" + name + ", key=" + key + ", Numero°=" + z + "]\n";
    for (Soldado s : misSoldados) {
      result += s.toString() + "\n";
    }
    return result;
  }

  public List<Soldado> gen_ejercito(String name) {
    List<Soldado> soldados = new ArrayList<>();
    int n = (int) (Math.random() * 9) + 1;
    for (int i = 0; i < n; i++) {
      int tipoSoldado = (int) (Math.random() * 4) + 1;
      Soldado s;
      switch (tipoSoldado) {
        case 1:
          s = new Arquero((int) (Math.random() * 10) + 1);
          s.setName("Arquero" + "_" + name + " " + i);
          s.setArmyName(name);
          s.setAtkLvl(7);
          s.setDefLvl(3);
          s.setHp((int) (Math.random() * 5) + 1);
          s.setActHP(s.getHp());
          break;
        case 2:
          s = new Espadachin((int) (Math.random() * 100) + 1);
          s.setName("Espadachin" + "_" + name + " " + i);
          s.setArmyName(name);
          s.setAtkLvl(10);
          s.setDefLvl(8);
          s.setHp((int) (Math.random() * 10) + 1);
          s.setActHP(s.getHp());
          break;
        case 3:
          s = new Caballero((int) (Math.random() * 2) + 1, (int) (Math.random() * 2) + 1);
          s.setName("Caballero" + "_" + name + " " + i);
          s.setAtkLvl(13);
          s.setArmyName(name);
          s.setDefLvl(7);
          s.setHp((int) (Math.random() * 12) + 1);
          s.setActHP(s.getHp());
          break;
        case 4:
          s = new Lancero((int) (Math.random() * 100) + 1);
          s.setName("Lancero" + "_" + name + " " + i);
          s.setAtkLvl(5);
          s.setArmyName(name);
          s.setDefLvl(10);
          s.setHp((int) (Math.random() * 8) + 1);
          s.setActHP(s.getHp());
          break;
        default:
          throw new IllegalStateException("Tipo de soldado desconocido: " + tipoSoldado);
      }
      soldados.add(s);
    }
    return soldados;
  }

  public List<Soldado> getSoldados() {
    return misSoldados;
  }
}