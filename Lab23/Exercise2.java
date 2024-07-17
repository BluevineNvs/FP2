import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise2 {
  public static void main(String[] args) {
    String inputFile = "Pruebas2.txt";
    String outputFile = "Salida2.txt";
    String targetWord = "línea";
    String replacementWord = "lineaEstuvoAqui";

    try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

      String line;

      while ((line = br.readLine()) != null) {
        line = line.replace(targetWord, replacementWord);
        bw.write(line);
        bw.newLine();
      }
      System.out.println("Se ha reemplazado la palabra " + targetWord + " por " + replacementWord);
    } catch (IOException e) {
      System.err.println("No finca" + e.getMessage());
      e.printStackTrace();
    }
  }
}
