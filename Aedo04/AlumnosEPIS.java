import java.util.*;
public class AlumnosEPIS {
    private static Alumno[][] alumnos = new Alumno[5][100]; 
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Ingresar datos");
            System.out.println("2. Consultar por año");
            System.out.println("3. Consultar todos");
            System.out.println("4. Promedio ponderado por año");
            System.out.println("5. Promedio ponderado de todos");
            System.out.println("6. Mayor promedio por año");
            System.out.println("7. Menor promedio por año");
            System.out.println("8. Mayor promedio de todos");
            System.out.println("9. Menor promedio de todos");
            System.out.println("10. Rankear por año");
            System.out.println("11. Rankear todos");
            System.out.println("12. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    enterData();
                    break;
                case 2:
                    queryByAge();
                    break;
                case 3:
                    queryAll();
                    break;
                case 4:
                    AgeWeightedAverage();
                    break;
                case 5:
                    weightedAverageOfAll();
                    break;
                case 6:
                    greatestAverageByAge();
                    break;
                case 7:
                    leastAverageByAge();
                    break;
                case 8:
                    greatestAverageOfAll();
                    break;
                case 9:
                    leastAverageOfAll();
                    break;
                case 10:
                    rankByAge();
                    break;
                case 11:
                    rankAll();
                    break;
                case 12:
                    System.out.println("Programa Finalizado");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 12);
    }
    public static void enterData() {
        System.out.print("Ingrese el año (1-5): ");
        int year = sc.nextInt() - 1;
        System.out.print("Ingrese el índice del alumno (0-99): ");
        int index = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el nombre: ");
        String name = sc.nextLine();
        System.out.print("Ingrese la edad: ");
        int age = sc.nextInt();
        System.out.print("Ingrese el promedio ponderado: ");
        double average = sc.nextDouble();
        alumnos[year][index] = new Alumno(name, age, average);
    }
    public static void queryByAge() {
        System.out.print("Ingrese el año de consulta (1-5): ");
        int year = sc.nextInt() - 1;
        for (int i = 0; i < 100; i++) {
            if (alumnos[year][i] != null) {
                System.out.println("Alumno " + (i + 1) + ": " + alumnos[year][i].name +
                        ", Edad: " + alumnos[year][i].age +
                        ", Promedio Ponderado: " + alumnos[year][i].weightedAverage);
            }
        }
    }
    public static void queryAll() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Año " + (i + 1) + ":");
            for (int j = 0; j < 100; j++) {
                if (alumnos[i][j] != null) {
                    System.out.println("Alumno " + (j + 1) + ": " + alumnos[i][j].name +
                            ", Edad: " + alumnos[i][j].age +
                            ", Promedio Ponderado: " + alumnos[i][j].weightedAverage);
                }
            }
        }
    }
    public static void AgeWeightedAverage() {
        System.out.print("Ingrese el año de consulta (1-5): ");
        int year = sc.nextInt() - 1;
        double add = 0;
        int counter = 0;
        for (int i = 0; i < 100; i++) {
            if (alumnos[year][i] != null) {
                add += alumnos[year][i].weightedAverage;
                counter++;
            }
        }
        if (counter > 0) {
            System.out.println("Promedio ponderado del año " + (year + 1) + ": " + (add / counter));
        } else {
            System.out.println("No hay alumnos en este año.");
        }
    }
    public static void weightedAverageOfAll() {
        double add = 0;
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 100; j++) {
                if (alumnos[i][j] != null) {
                    add += alumnos[i][j].weightedAverage;
                    counter++;
                }
            }
        }
        if (counter > 0) {
            System.out.println("Promedio ponderado de todos los alumnos: " + (add / counter));
        } else {
            System.out.println("No hay alumnos registrados.");
        }
    }
    public static void greatestAverageByAge() {
        System.out.print("Ingrese el año de consulta (1-5): ");
        int year = sc.nextInt() - 1;
        double greatestAverage = 0;
        for (int i = 0; i < 100; i++) {
            if (alumnos[year][i] != null) {
                if (alumnos[year][i].weightedAverage > greatestAverage) {
                    greatestAverage = alumnos[year][i].weightedAverage;
                }
            }
        }
        System.out.println("Mayor promedio del año " + (year + 1) + ": " + greatestAverage);
    }
    public static void leastAverageByAge() {
        System.out.print("Ingrese el año de consulta (1-5): ");
        int year = sc.nextInt() - 1;
        double leastAverage = Double.MAX_VALUE;
        for (int i = 0; i < 100; i++) {
            if (alumnos[year][i] != null) {
                if (alumnos[year][i].weightedAverage < leastAverage) {
                    leastAverage = alumnos[year][i].weightedAverage;
                }
            }
        }
        System.out.println("Menor promedio del año " + (year + 1) + ": " + leastAverage);
    }
    public static void greatestAverageOfAll() {
        double greatestAverage = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 100; j++) {
                if (alumnos[i][j] != null) {
                    if (alumnos[i][j].weightedAverage > greatestAverage) {
                        greatestAverage = alumnos[i][j].weightedAverage;
                    }
                }
            }
        }
        System.out.println("Mayor promedio de todos los alumnos: " + greatestAverage);
    }
    public static void leastAverageOfAll() {
        double leastAverage = Double.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 100; j++) {
                if (alumnos[i][j] != null) {
                    if (alumnos[i][j].weightedAverage < leastAverage) {
                        leastAverage = alumnos[i][j].weightedAverage;
                    }
                }
            }
        }
        System.out.println("Menor promedio de todos los alumnos: " + leastAverage);
    }
    public static void rankByAge() {
        System.out.print("Ingrese el año a rankear (1-5): ");
        int year = sc.nextInt() - 1;
        Alumno[] list = new Alumno[100];
        int counter = 0;
        for (int i = 0; i < 100; i++) {
            if (alumnos[year][i] != null) {
                list[counter] = alumnos[year][i];
                counter++;
            }
        }
        for (int i = 0; i < counter - 1; i++) {
            for (int j = i + 1; j < counter; j++) {
                if (list[i].weightedAverage < list[j].weightedAverage) {
                    Alumno temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        for (int i = 0; i < counter; i++) {
            System.out.println((i + 1) + ". " + list[i].name + " - " + list[i].weightedAverage);
        }
    }
    public static void rankAll() {
        Alumno[] list = new Alumno[500];
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 100; j++) {
                if (alumnos[i][j] != null) {
                    list[counter] = alumnos[i][j];
                    counter++;
                }
            }
        }
        for (int i = 0; i < counter - 1; i++) {
            for (int j = i + 1; j < counter; j++) {
                if (list[i].weightedAverage < list[j].weightedAverage) {
                    Alumno temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        for (int i = 0; i < counter; i++) {
            System.out.println((i + 1) + ". " + list[i].name + " - " + list[i].weightedAverage);
        }
    }
}