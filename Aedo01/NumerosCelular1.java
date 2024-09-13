import java.util.Scanner;

public class NumerosCelular1 {

    public static void main(String[] args) {
        String[] numeros = new String[100];

        int cantidad = ingresar(numeros);
        imprimir(numeros, cantidad);
    }

    public static int ingresar(String[] arreglo) {
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        while (contador < arreglo.length) {
            System.out.print("Ingrese un número de celular o 'q' para salir: ");
            String num = sc.nextLine();
            if (num.equalsIgnoreCase("q")) {
                break; 
            }
            if (num.length() == 9) {
                arreglo[contador] = num;
                contador++;
            } else {
                System.out.println("Error: El número debe tener 9 dígitos");
            }
        }
        sc.close();
        return contador; 
    }

    public static void imprimir(String[] arreglo, int cantidad) {
        System.out.println("Números de celular ingresados:");
        for (int i = 0; i < cantidad; i++) {
            System.out.println(arreglo[i]);
        }
    }
}