import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CreateBinaryFile {
    public static void main(String[] args) {
        String fileName = "Entrada.bin";

        try (FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            // Escribir una lista de enteros
            int[] intList = { 10, 20, 30, 40, 50 };
            oos.writeObject(intList);

            // Escribir una cadena
            String message = "Este es un mensaje de prueba, espero que funcione.";
            oos.writeObject(message);

            System.out.println("Archivo binario creado exitosamente: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
