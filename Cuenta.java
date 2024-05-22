public class Cuenta {
    private String name;
    private double saldo;

    public Cuenta(String name, double saldo) {
        this.name = name;
        this.saldo = saldo;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double getSaldo() {
        return saldo;
    }
    public void depositar(double cant) {
        saldo += cant;
    }
    public boolean retirar(double cant) {
        if (cant <= saldo) {
            saldo -= cant;
            return true;
        } else {
            return false;
        }
    }
    public boolean esPremium() {
        return saldo >= 10000;
    }
}