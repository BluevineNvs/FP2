import java.util.*;
public class Batalla{
  public static void main(String[] args){
    System.out.println();
    // Inicializar tablero
    ArrayList<ArrayList<Soldado>> tablero = new ArrayList<>();
    for(int i = 0; i < 10; i++){
      ArrayList<Soldado> fila = new ArrayList<Soldado>();
      for(int j = 0; j < 10; j++){
        fila.add(null);
      }
      tablero.add(fila);
    }

    int n = 10;
    // Army 1
    for(int i = 0; i < n; i++){
      Soldado s = new Soldado();
      s.setName("SoldadoEj1_" + i);
      s.setHp((int) (Math.random() * (5 - 1 + 1) + 1));
      int fila, col;
      do{
        fila = (int) (Math.random() * 10);
        col = (int) (Math.random() * 10);
      }while (tablero.get(fila).get(col) != null);
      s.setFila(fila);
      s.setColumna(col);
      s.setTeam(1);
      tablero.get(fila).set(col, s);
    }

    // Army 2
    for(int i = 0; i < n; i++){
      Soldado s = new Soldado();
      s.setName("SoldadoEj2_" + i);
      s.setHp((int) (Math.random() * (5 - 1 + 1) + 1));
      int fila, col;
      do{
        fila = (int) (Math.random() * 10);
        col = (int) (Math.random() * 10);
      }while (tablero.get(fila).get(col) != null);
      s.setFila(fila);
      s.setColumna(col);
      s.setTeam(2);
      tablero.get(fila).set(col, s);
    }
    // Mostrar tablero
    for(int i = 0; i < 10; i++){
      for(int j = 0; j < 10; j++){
        // Tablero
        if(tablero.get(i).get(j) == null){
          System.out.print("|_|");
        }else{
          System.out.print("|" + tablero.get(i).get(j).getTeam() + "|");
        }
      }

      System.out.println();
    }
    // Soldado con mayor vida de cada ejército
    Soldado mayorVidaEj1 = null;
    Soldado mayorVidaEj2 = null;
    for(ArrayList<Soldado> fila : tablero){
      for(Soldado s : fila){
        if(s != null){
          if(s.getName().startsWith("SoldadoEj1_") && (mayorVidaEj1 == null || s.getHp() > mayorVidaEj1.getHp())){
            mayorVidaEj1 = s;
          }
          if(s.getName().startsWith("SoldadoEj2_") && (mayorVidaEj2 == null || s.getHp() > mayorVidaEj2.getHp())){
            mayorVidaEj2 = s;
          }
        }
      }
    }

    System.out.println();
    System.out.println("--------------------------------------------------------");
    System.out.println();
    System.out.println("Soldado con mayor vida Ejército 1:");
    System.out.println(mayorVidaEj1);
    System.out.println();
    System.out.println("--------------------------------------------------------");
    System.out.println();
    System.out.println("Soldado con mayor vida Ejército 2:");
    System.out.println(mayorVidaEj2);

    // Promedio vida de cada ejército
    int countEj1 = 0, countEj2 = 0;
    int sumaEj1 = 0, sumaEj2 = 0;

    for(ArrayList<Soldado> fila : tablero){
      for(Soldado s : fila){
        if(s != null){
          if(s.getName().startsWith("SoldadoEj1_")){
            sumaEj1 += s.getHp();
            countEj1++;
          }else{
            sumaEj2 += s.getHp();
            countEj2++;
          }
        }
      }
    }

    double promEj1 = (double) sumaEj1 / countEj1;
    double promEj2 = (double) sumaEj2 / countEj2;

    System.out.println();
    System.out.println("--------------------------------------------------------");
    System.out.println();
    System.out.println("Promedio vida Ejército 1: " + promEj1);
    System.out.println("Promedio vida Ejército 2: " + promEj2);

    // Soldados por orden de creación
    ArrayList<Soldado> soldadosEj1 = new ArrayList<>();
    ArrayList<Soldado> soldadosEj2 = new ArrayList<>();

    for(ArrayList<Soldado> fila : tablero){
      for(Soldado s : fila){
        if(s != null){
          if(s.getName().startsWith("SoldadoEj1_")){
            soldadosEj1.add(s);
          }else{
            soldadosEj2.add(s);
          }
        }
      }
    }

    System.out.println();
    System.out.println("--------------------------------------------------------");
    System.out.println();
    System.out.println("Soldados Ejército 1:");
    for(Soldado s : soldadosEj1){
      System.out.println(s);
    }

    System.out.println();
    System.out.println("--------------------------------------------------------");
    System.out.println();
    System.out.println("Soldados Ejército 2:");
    for(Soldado s : soldadosEj2){
      System.out.println(s);
    }

    // Ranking de poder 
    ArrayList<Soldado> soldadosEj1Sorted = new ArrayList<>(soldadosEj1);
    ArrayList<Soldado> soldadosEj2Sorted = new ArrayList<>(soldadosEj2);

    // Ordenamiento por selección
    for(int i = 0; i < soldadosEj1Sorted.size(); i++){
      int maxIndex = i;
      for(int j = i + 1; j < soldadosEj1Sorted.size(); j++){
        if(soldadosEj1Sorted.get(j).getHp() > soldadosEj1Sorted.get(maxIndex).getHp()){
          maxIndex = j;
        }
      }
      Soldado temp = soldadosEj1Sorted.get(maxIndex);
      soldadosEj1Sorted.set(maxIndex, soldadosEj1Sorted.get(i));
      soldadosEj1Sorted.set(i, temp);
    }

    for(int i = 0; i < soldadosEj2Sorted.size(); i++){
      int maxIndex = i;
      for(int j = i + 1; j < soldadosEj2Sorted.size(); j++){
        if (soldadosEj2Sorted.get(j).getHp() > soldadosEj2Sorted.get(maxIndex).getHp()){
          maxIndex = j;
        }
      }
      Soldado temp = soldadosEj2Sorted.get(maxIndex);
      soldadosEj2Sorted.set(maxIndex, soldadosEj2Sorted.get(i));
      soldadosEj2Sorted.set(i, temp);
    }

    System.out.println();
    System.out.println("--------------------------------------------------------");
    System.out.println();
    System.out.println("Ranking Ejército 1:");
    for(Soldado s : soldadosEj1Sorted){
      System.out.println(s);
    }

    System.out.println();
    System.out.println("--------------------------------------------------------");
    System.out.println();
    System.out.println("Ranking Ejército 2:");
    for(Soldado s : soldadosEj2Sorted){
      System.out.println(s);
    }

    // Select winner
    int sumaVidaEj1 = 0;
    for (Soldado s : soldadosEj1Sorted){
      sumaVidaEj1 += s.getHp();
    }

    int sumaVidaEj2 = 0;
    for (Soldado s : soldadosEj2Sorted){
      sumaVidaEj2 += s.getHp();
    }

    System.out.println();
    System.out.println("--------------------------------------------------------");
    System.out.println();
    System.out.println("-----------------------------");
    System.out.println();
    System.out.println("EN BASE A LOS PUNTOS DE VIDA:");
    System.out.println();
    if(sumaVidaEj1 > sumaVidaEj2){
      System.out.println("Gana el Ejército 1");
    }else if (sumaVidaEj2 > sumaVidaEj1){
      System.out.println("Gana el Ejército 2");
    }else{
      System.out.println("Empate");
    }
    System.out.println();
    System.out.println("-----------------------------");
  }
}