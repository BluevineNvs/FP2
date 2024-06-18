import java.util.ArrayList;
import java.util.List;
public class Ejercito { 
  private String key;

  public String getKey() {
    return key;
  }

  public Ejercito(String name, String key, int z) {
    this.key = key;
    List<Soldado>soldadosTeam1 = new ArrayList<>();
    soldadosTeam1 = gen_ejercito(name);
    System.out.println("Ejercito " + name + " N°" + (z + 1) + ": ");
    for (Soldado s : soldadosTeam1) {
      System.out.println(s.getName() + " HP: " + s.getHp() + " ActHP: " + s.getActHP());
    }
  }

  public List<Soldado> gen_ejercito(String name) {
    List<Soldado>soldadosTeam1 = new ArrayList<>();
    // Inicializar el ejercito
      int n = (int) (Math.random() * 9) + 1;
      for (int i = 0; i < n; i++) {
        Soldado s = new Soldado();
        s.setName("Soldado" + "_" + name + " " + i);
        s.setHp((int) (Math.random() * 5) + 1);
        s.setActHP((int) (Math.random() * 5) + 1);
        soldadosTeam1.add(s);
      }
      return soldadosTeam1;
  }
}
