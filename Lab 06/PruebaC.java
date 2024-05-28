public class PruebaC {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta("Jhossep", 5000);

        System.out.println("Información de la cuenta :");
        mostrarInformacionCuenta(cuenta);

        cuenta.depositar(2000);
        cuenta.retirar(1500);

        System.out.println("Después de las transacciones:");
        mostrarInformacionCuenta(cuenta);

        System.out.println("¿La cuenta es Premium? " + cuenta.esPremium());
    }
    public static void mostrarInformacionCuenta(Cuenta cuenta) {
        System.out.println("Titular: " + cuenta.getName());
        System.out.println("Saldo: " + cuenta.getSaldo());
    }
}
