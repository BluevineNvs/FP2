import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise1 {
  public static void main(String[] args) {
    String inputFile = "Pruebas.txt";
    String outputFile = "Salida.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

      String line;
      int lineCount = 0;

      while ((line = br.readLine()) != null) {
        lineCount++;
        bw.write(line);
        bw.newLine();
      }

      System.out.println("El Numero de lineas es: " + lineCount);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
