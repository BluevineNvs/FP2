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

  public Ejercito(String name, String key, int z, int x) {
    this.name = name;
    this.key = key;
    this.misSoldados = gen_ejercito(name, x);
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

  public List<Soldado> gen_ejercito(String name, int x) {
    List<Soldado> soldados = new ArrayList<>();
    // Inicializar el ejercito
    switch (x) {
      case 1:
        System.out.println("Ejercito de Arqueros");
        int n = (int) (Math.random() * 9) + 1;
        for (int i = 0; i < n; i++) {
          int u = (int) (Math.random() * 10) + 1;
          Arquero s = new Arquero(u);
          s.setName("Arquero" + "_" + name + " " + i);
          s.setHp((int) (Math.random() * 3) + 1);
          s.setActHP((int) (Math.random() * 3) + 1);
          soldados.add(s);
        }
        break;
      case 2:
        System.out.println("Ejercito de Espadachines");
        int k = (int) (Math.random() * 9) + 1;
        for (int i = 0; i < k; i++) {
          int r = (int) (Math.random() * 100) + 1;
          Espadachin s = new Espadachin(r);
          s.setName("Espadachin" + "_" + name + " " + i);
          s.setHp((int) (Math.random() * 4) + 1);
          s.setActHP((int) (Math.random() * 4) + 1);
          soldados.add(s);
        }
        break;
      case 3:
        System.out.println("Ejercito de Caballeros");
        int l = (int) (Math.random() * 9) + 1;
        for (int i = 0; i < l; i++) {
          int y = (int) (Math.random() * 2) + 1;
          int t = (int) (Math.random() * 2) + 1;
          Caballero s = new Caballero(y,t);
          s.setName("Caballero" + "_" + name + " " + i);
          s.setHp((int) (Math.random() * 5) + 1);
          s.setActHP((int) (Math.random() * 5) + 1);
          soldados.add(s);
        }
        break;
    }
    return soldados;
  }

  public List<Soldado> getSoldados() {
    return misSoldados;
  }
}