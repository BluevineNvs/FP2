import java.util.*;

public class Reino {
  private String name;
  private String key;
  private List <Ejercito> ejercitos = new ArrayList<>();

  public List<Ejercito> getEjercitos() {
    return ejercitos;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Reino(String name) {
    this.key = name.substring(0, 1);
    int n = (int) (Math.random() * 9) + 1;
    for (int i = 0; i < n; i++) {
      Ejercito ejercito = new Ejercito(name, key, i);
      ejercitos.add(ejercito);
    }
  }
}
