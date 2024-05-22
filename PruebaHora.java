public class PruebaHora {
    public static void main(String[] args) {
        Hora hora = new Hora(10, 30, 59);

        System.out.println("Hora actual: " + hora.mostrarHora());

        hora.aumentarMinuto();
        hora.aumentarSegundo();
        hora.aumentarHora();

        System.out.println("Hora actual después de los cambios: " + hora.mostrarHora());
    }
}