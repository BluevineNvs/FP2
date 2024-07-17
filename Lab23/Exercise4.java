import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Person implements Serializable {
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Nombre: " + name + ", Edad: " + age;
  }
}

public class Exercise4 {
  public static void main(String[] args) {
    String fileName = "Persons.bin";

    // Crear una lista de objetos Person
    List<Person> personList = new ArrayList<>();
    personList.add(new Person("Juan", 25));
    personList.add(new Person("Maria", 30));
    personList.add(new Person("Luis", 35));

    // Serializar la lista de objetos Person a un archivo binario
    try (FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {

      oos.writeObject(personList);
      System.out.println("Lista de objetos serializada exitosamente en " + fileName);

    } catch (IOException e) {
      System.err.println("Error al serializar la lista de objetos: :C" + e.getMessage());
      e.printStackTrace();
    }

    // Deserializar la lista de objetos Person desde el archivo binario
    try (FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis)) {

      List<Person> deserializedPersonList = (List<Person>) ois.readObject();
      System.out.println("Lista de objetos deserializada exitosamente desde " + fileName);

      // Mostrar los objetos deserializados
      System.out.println("Contenido de la lista deserializada:");
      for (Person person : deserializedPersonList) {
        System.out.println(person);
      }

    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Error al deserializar la lista de objetos: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
