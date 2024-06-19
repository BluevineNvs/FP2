import java.util.ArrayList;
import java.util.List;

public class Ejercito {
  private String key;
  private List<Soldado> soldadosTeam1;
  private String name;

  public String getName() {
    return name;
  }

  public String getKey() {
    return key;
  }

  public Ejercito(String name, String key, int z) {
    this.name = name;
    this.key = key;
    this.soldadosTeam1 = gen_ejercito(name);
    /*System.out.println("Ejercito " + name + " N°" + (z + 1) + ": ");
    for (Soldado s : soldadosTeam1) {
      System.out.println(s.getName() + " HP: " + s.getHp() + " ActHP: " + s.getActHP());
    }*/
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

  // Método para obtener los soldados de este ejército
  public List<Soldado> getSoldados() {
    return soldadosTeam1;
  }
}