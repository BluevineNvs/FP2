package Aedo06;
import java.util.*;
public class MiFacebook {
    public class MiFaceBook {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            ArrayList<Contacto> misContactos = new ArrayList<>();
            llenarContactos(misContactos, sc);
            System.out.println("Contactos:");
            for (Contacto contacto : misContactos) {
                System.out.println(contacto);
            }
            ordenarContactos(misContactos);
            System.out.println("Ingresar el nombre a buscar:");
            String busqueda = sc.nextLine();
            Contacto encontrado = busquedaBinaria(misContactos, busqueda);
            if (encontrado != null) {
                System.out.println("Contacto encontrado: " + encontrado);
            } else {
                System.out.println("Contacto no encontrado.");
            }
        }

        public static void llenarContactos(ArrayList<Contacto> contactos, Scanner sc) {
            String continuar;
            do {
                Contacto contacto = new Contacto();
                System.out.println("Ingresa el nombre del contacto:");
                contacto.setNombre(sc.nextLine());
                System.out.println("Ingresa la edad del contacto:");
                contacto.setEdad(sc.nextInt());
                sc.nextLine();
                System.out.println("Ingresa el estado civil del contacto:");
                contacto.setEstadoCivil(sc.nextLine());
                contactos.add(contacto);
                System.out.println("¿Deseas añadir otro contacto? (s/n)");
                continuar = sc.nextLine();
            } while (continuar.equalsIgnoreCase("s"));
        }

        public static void ordenarContactos(ArrayList<Contacto> contactos) {
            int n = contactos.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (contactos.get(j).getNombre().compareToIgnoreCase(contactos.get(j + 1).getNombre()) > 0) {
                        Contacto temp = contactos.get(j);
                        contactos.set(j, contactos.get(j + 1));
                        contactos.set(j + 1, temp);
                    }
                }
            }
        }

        public static Contacto busquedaBinaria(ArrayList<Contacto> contactos, String nombre) {
            int inicio = 0;
            int fin = contactos.size() - 1;
            while (inicio <= fin) {
                int medio = (inicio + fin) / 2;
                Contacto contactoMedio = contactos.get(medio);
                int comparacion = contactoMedio.getNombre().compareToIgnoreCase(nombre);
                if (comparacion == 0) {
                    return contactoMedio;
                } else if (comparacion < 0) {
                    inicio = medio + 1;
                } else {
                    fin = medio - 1;
                }
            }
            return null;
        }
    }
}
