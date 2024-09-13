import java.util.*;
public class ArregloPersona2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese número de personas: ");
        int n = sc.nextInt();
        Persona[] personas = new Persona[n];
        for(int i = 0; i < n; i++){
            personas[i] = new Persona();
            System.out.println("Ingrese los datos: ");
            sc.nextLine();
            System.out.print("Nombre: ");
            personas[i].setName(sc.nextLine());
            System.out.print("Edad: ");
            personas[i].setAge(sc.nextInt());
            System.out.print("Género(M/F): ");
            personas[i].setGender(sc.next().charAt(0));
        }
        Persona joven = personas[0];
        Persona mayor = personas[0];
        for(int i = 1; i < personas.length; i++){
            if(personas[i].getAge() < joven.getAge()){
                joven = personas[i];
            }
            if(personas[i].getAge() > mayor.getAge()){
                mayor = personas[i];
            }
        }
        System.out.println("Persona más joven: ");
        System.out.println("Nombre: " + joven.getName());
        System.out.println("Edad: " + joven.getAge());
        System.out.println("Género: " + joven.getGender());
        System.out.println("Persona mayor: ");
        System.out.println("Nombre: " + mayor.getName());
        System.out.println("Edad: " + mayor.getAge());
        System.out.println("Género: " + mayor.getGender());
        sc.close();
    }
}
