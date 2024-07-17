import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise3 {
  public static void main(String[] args) {
    String inputFile = "Entrada.bin";
    String outputFile = "Salida.bin";

    // Copy binary file
    try (FileInputStream fis = new FileInputStream(inputFile);
        FileOutputStream fos = new FileOutputStream(outputFile)) {

      int byteData;
      while ((byteData = fis.read()) != -1) {
        fos.write(byteData);
      }
      System.out.println("Se ha copiado el archivo binario");
    } catch (IOException e) {
      System.err.println("No se pudo copiar el archivo binario pipipi :(" + e.getMessage());
      e.printStackTrace();
    }

    // Read and display the copied binary file
    try (FileInputStream fis = new FileInputStream(outputFile)) {
      int byteData;
      while ((byteData = fis.read()) != -1) {
        System.out.print(byteData + " ");
      }
      System.out.println("\nSe ha leido el archivo binario copiado");
    } catch (IOException e) {
      System.err.println("No se pudo leer el archivo binario copiado :(" + e.getMessage());
      e.printStackTrace();
    }
  }
}
