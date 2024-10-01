package Aedo06;
import java.util.*;
public class EstudiantesEPIS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Alumno>> studentsByYear = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            studentsByYear.add(new ArrayList<>());
        }
        int option;
        do {
            System.out.println("Menú:");
            System.out.println("1. Ingresar datos");
            System.out.println("2. Consultar por año");
            System.out.println("3. Consultar todos los años");
            System.out.println("4. Promedio ponderado por año");
            System.out.println("5. Promedio ponderado de todos");
            System.out.println("6. Mayor promedio por año");
            System.out.println("7. Menor promedio por año");
            System.out.println("8. Mayor promedio de todos");
            System.out.println("9. Menor promedio de todos");
            System.out.println("10. Rankear alumnos por año");
            System.out.println("11. Rankear todos los alumnos");
            System.out.println("12. Salir");
            System.out.print("Selecciona una opción: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    enterData(studentsByYear, scanner);
                    break;
                case 2:
                    consultByYear(studentsByYear, scanner);
                    break;
                case 3:
                    consultAll(studentsByYear);
                    break;
                case 4:
                    averageByYear(studentsByYear, scanner);
                    break;
                case 5:
                    totalAverage(studentsByYear);
                    break;
                case 6:
                    highestAverageByYear(studentsByYear, scanner);
                    break;
                case 7:
                    lowestAverageByYear(studentsByYear, scanner);
                    break;
                case 8:
                    highestTotalAverage(studentsByYear);
                    break;
                case 9:
                    lowestTotalAverage(studentsByYear);
                    break;
                case 10:
                    rankStudentsByYear(studentsByYear, scanner);
                    break;
                case 11:
                    rankAllStudents(studentsByYear);
                    break;
                case 12:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 12);
    }
    // Método para ingresar datos de los alumnos
    public static void enterData(ArrayList<ArrayList<Alumno>> studentsByYear, Scanner scanner) {
        System.out.print("Ingresa el año del alumno (1-5): ");
        int year = scanner.nextInt();
        scanner.nextLine();
        if (year < 1 || year > 5) {
            System.out.println("Año no válido.");
            return;
        }
        System.out.print("Ingresa el nombre del alumno: ");
        String name = scanner.nextLine();
        System.out.print("Ingresa la edad del alumno: ");
        int age = scanner.nextInt();
        System.out.print("Ingresa el promedio ponderado del alumno: ");
        double average = scanner.nextDouble();
        studentsByYear.get(year - 1).add(new Alumno(name, age, average));
        System.out.println("Alumno ingresado correctamente.");
    }
    // Método para consultar alumnos por año
    public static void consultByYear(ArrayList<ArrayList<Alumno>> studentsByYear, Scanner scanner) {
        System.out.print("Ingresa el año que deseas consultar (1-5): ");
        int year = scanner.nextInt();
        if (year < 1 || year > 5) {
            System.out.println("Año no válido.");
            return;
        }
        System.out.println("Alumnos del año " + year + ":");
        for (Alumno student : studentsByYear.get(year - 1)) {
            System.out.println(student);
        }
    }
    // Método para consultar todos los alumnos
    public static void consultAll(ArrayList<ArrayList<Alumno>> studentsByYear) {
        for (int i = 0; i < studentsByYear.size(); i++) {
            System.out.println("Alumnos del año " + (i + 1) + ":");
            for (Alumno student : studentsByYear.get(i)) {
                System.out.println(student);
            }
        }
    }
    // Método para calcular el promedio por año
    public static void averageByYear(ArrayList<ArrayList<Alumno>> studentsByYear, Scanner scanner) {
        System.out.print("Ingresa el año que deseas consultar el promedio (1-5): ");
        int year = scanner.nextInt();
        if (year < 1 || year > 5) {
            System.out.println("Año no válido.");
            return;
        }
        double totalAverages = 0;
        int studentCount = studentsByYear.get(year - 1).size();
        if (studentCount == 0) {
            System.out.println("No hay alumnos en el año " + year);
            return;
        }
        for (Alumno student : studentsByYear.get(year - 1)) {
            totalAverages += student.getAverage();
        }
        System.out.println("Promedio ponderado del año " + year + ": " + (totalAverages / studentCount));
    }
    // Método para calcular el promedio de todos los años
    public static void totalAverage(ArrayList<ArrayList<Alumno>> studentsByYear) {
        double totalAverages = 0;
        int totalStudents = 0;
        for (ArrayList<Alumno> students : studentsByYear) {
            for (Alumno student : students) {
                totalAverages += student.getAverage();
                totalStudents++;
            }
        }
        if (totalStudents == 0) {
            System.out.println("No hay alumnos.");
            return;
        }
        System.out.println("Promedio ponderado de todos los años: " + (totalAverages / totalStudents));
    }
    // Método para encontrar el mayor promedio por año
    public static void highestAverageByYear(ArrayList<ArrayList<Alumno>> studentsByYear, Scanner scanner) {
        System.out.print("Ingresa el año que deseas consultar (1-5): ");
        int year = scanner.nextInt();
        if (year < 1 || year > 5) {
            System.out.println("Año no válido.");
            return;
        }
        Alumno highest = Collections.max(studentsByYear.get(year - 1), Comparator.comparing(Alumno::getAverage));
        System.out.println("El alumno con mayor promedio en el año " + year + " es: " + highest);
    }
    // Método para encontrar el menor promedio por año
    public static void lowestAverageByYear(ArrayList<ArrayList<Alumno>> studentsByYear, Scanner scanner) {
        System.out.print("Ingresa el año que deseas consultar (1-5): ");
        int year = scanner.nextInt();
        if (year < 1 || year > 5) {
            System.out.println("Año no válido.");
            return;
        }
        Alumno lowest = Collections.min(studentsByYear.get(year - 1), Comparator.comparing(Alumno::getAverage));
        System.out.println("El alumno con menor promedio en el año " + year + " es: " + lowest);
    }
    // Método para encontrar el mayor promedio de todos los años
    public static void highestTotalAverage(ArrayList<ArrayList<Alumno>> studentsByYear) {
        Alumno highest = null;
        for (ArrayList<Alumno> students : studentsByYear) {
            for (Alumno student : students) {
                if (highest == null || student.getAverage() > highest.getAverage()) {
                    highest = student;
                }
            }
        }
        if (highest != null) {
            System.out.println("El alumno con mayor promedio de todos es: " + highest);
        } else {
            System.out.println("No hay alumnos registrados.");
        }
    }
    // Método para encontrar el menor promedio de todos los años
    public static void lowestTotalAverage(ArrayList<ArrayList<Alumno>> studentsByYear) {
        Alumno lowest = null;
        for (ArrayList<Alumno> students : studentsByYear) {
            for (Alumno student : students) {
                if (lowest == null || student.getAverage() < lowest.getAverage()) {
                    lowest = student;
                }
            }
        }
        if (lowest != null) {
            System.out.println("El alumno con menor promedio de todos es: " + lowest);
        } else {
            System.out.println("No hay alumnos registrados.");
        }
    }
    // Método para rankear alumnos por año
    public static void rankStudentsByYear(ArrayList<ArrayList<Alumno>> studentsByYear, Scanner scanner) {
        System.out.print("Ingresa el año que deseas rankear (1-5): ");
        int year = scanner.nextInt();
        if (year < 1 || year > 5) {
            System.out.println("Año no válido.");
            return;
        }
        ArrayList<Alumno> students = studentsByYear.get(year - 1);
        students.sort(Comparator.comparing(Alumno::getAverage).reversed());
        System.out.println("Ranking de alumnos del año " + year + ":");
        for (Alumno student : students) {
            System.out.println(student);
        }
    }
    // Método para rankear todos los alumnos
    public static void rankAllStudents(ArrayList<ArrayList<Alumno>> studentsByYear) {
        ArrayList<Alumno> allStudents = new ArrayList<>();
        for (ArrayList<Alumno> students : studentsByYear) {
            allStudents.addAll(students);
        }
        allStudents.sort(Comparator.comparing(Alumno::getAverage).reversed());
        System.out.println("Ranking de todos los alumnos:");
        for (Alumno student : allStudents) {
            System.out.println(student);
        }
    }
}