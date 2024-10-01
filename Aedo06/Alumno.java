package Aedo06;
class Alumno {
    private String name;
    private int age;
    private double average;

    public Alumno(String name, int age, double average) {
        this.name = name;
        this.age = age;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + ", Edad: " + age + ", Promedio: " + average;
    }
}
