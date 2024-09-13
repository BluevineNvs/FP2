import java.util.*;
public class ArregloPersona{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese número de personas: ");
        int n = sc.nextInt();
        Persona[] personas = new Persona[n];
        for(int i = 0; i < n; i++){
            personas[i] = new Persona();
            System.out.println("Ingrese los datos: ");
            sc.nextLine();
            System.out.println("Nombre: ");
            personas[i].setName(sc.nextLine());
            System.out.println("Edad: ");
            personas[i].setAge(sc.nextInt());
            System.out.println("Género(M/F): ");
            personas[i].setGender(sc.next().charAt(0));
        }
        System.out.println("Datos ingresados: ");
        for(int i = 0; i<personas.length; i++){
            System.out.println("PERSONA" + (i+1) + ":");
            System.out.println("Nombre: " + personas[i].getName());
            System.out.println("Edad: " + personas[i].getAge());
            System.out.println("Género: " + personas[i].getGender());
        }
        sc.close();
    }
}