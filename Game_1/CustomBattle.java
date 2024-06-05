import java.util.*;

class CustomBattle {
  public void a() {
    System.out.println();
    // Inicializar tablero
    Soldado[][] tablero = new Soldado[10][10];
    List<Soldado> todosLosSoldados = new ArrayList<>();

    int n = 2;
    // Army 1
    for (int i = 0; i < n; i++) {
      Soldado s = new Soldado();
      s.setName("SoldadoEj1_" + i);
      s.setHp((int) (Math.random() * (5 - 1 + 1) + 1));
      s.setActHP((int) (Math.random() * (5 - 1 + 1) + 1));
      int fila, col;
      do {
        fila = (int) (Math.random() * 10);
        col = (int) (Math.random() * 10);
      } while (tablero[fila][col] != null);
      s.setFila(fila);
      s.setColumna(col);
      s.setTeam(1);
      tablero[fila][col] = s;
      todosLosSoldados.add(s);
    }

    // Army 2
    for (int i = 0; i < n; i++) {
      Soldado s = new Soldado();
      s.setName("SoldadoEj2_" + i);
      s.setHp((int) (Math.random() * (5 - 1 + 1) + 1));
      s.setActHP((int) (Math.random() * (5 - 1 + 1) + 1));
      int fila, col;
      do {
        fila = (int) (Math.random() * 10);
        col = (int) (Math.random() * 10);
      } while (tablero[fila][col] != null);
      s.setFila(fila);
      s.setColumna(col);
      s.setTeam(2);
      tablero[fila][col] = s;
      todosLosSoldados.add(s);
    }
    // Mostrar tablero
    Methods.mostrarTablero(tablero);
  }

  public void newSoldier(Soldado[][] tablero, String name, int atk, int def, int hp, int speed, int team, List<Soldado> todosLosSoldados) {
    Soldado soldado = new Soldado(name, atk, def, hp, speed, team);
    if (todosLosSoldados.size() >= 20) {
      System.out.println("No se pueden agregar más soldados");
    } else {
      int fila, col;
      fila = (int) (Math.random() * 10);
      col = (int) (Math.random() * 10);
      if (tablero[fila][col] != null) {
        soldado.setFila(fila);
        soldado.setColumna(col);
        tablero[fila][col] = soldado;
      }
    }
  }
}