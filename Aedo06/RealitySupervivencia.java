package Aedo06;
import java.util.*;
public class RealitySupervivencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> people = new ArrayList<>();
        System.out.println("Ingresa el número de personas:");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Ingresa el nombre de la persona " + (i + 1) + ":");
            String name = sc.nextLine();
            people.add(name);
        }
        while (people.size() > 1) {
            int index = (int) (Math.random() * people.size());
            String eliminated = people.remove(index);
            System.out.println("Eliminado: " + eliminated);
            System.out.println("Personas restantes: " + people);
        }
        sc.close();
    }
}