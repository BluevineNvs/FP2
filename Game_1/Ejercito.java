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
    // Inicializar el ejercito
    int n = (int) (Math.random() * 9) + 1;
    for (int i = 0; i < n; i++) {
      Soldado s = new Soldado();
      s.setName("Soldado" + "_" + name + " " + i);
      s.setHp((int) (Math.random() * 5) + 1);
      s.setActHP((int) (Math.random() * 5) + 1);
      soldados.add(s);
    }
    return soldados;
  }

  public List<Soldado> getSoldados() {
    return misSoldados;
  }
}