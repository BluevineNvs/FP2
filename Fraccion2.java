public class Fraccion2 {
    private int numerador;
    private int denominador;

    public Fraccion2() {
        this(0, 1);
    }
    public Fraccion2(int numerador) {
        this(numerador, 1);
    }
    public Fraccion2(int numerador, int denominador) {
        setFraccion(numerador, denominador);
    }
    public Fraccion2(Fraccion2 f) {
        this(f.numerador, f.denominador);
    }
    public Fraccion2 setFraccion(int numerador, int denominador) {
        if (denominador == 0) {
            denominador = 1;
        }
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
        return this;
    }
    public void simplificar() {
        int gcd = gcd(Math.abs(numerador), Math.abs(denominador));
        numerador /= gcd;
        denominador /= gcd;
    }
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }
    public String toDecimalString() {
        return String.format("%.3f", (double) numerador / denominador);
    }
    public Fraccion2 sumar(Fraccion2 f) {
        int n = this.numerador * f.denominador + f.numerador * this.denominador;
        int d = this.denominador * f.denominador;
        return setFraccion(n, d);
    }
    public Fraccion2 restar(Fraccion2 f) {
        int n = this.numerador * f.denominador - f.numerador * this.denominador;
        int d = this.denominador * f.denominador;
        return setFraccion(n, d);
    }
    public Fraccion2 multiplicar(Fraccion2 f) {
        return setFraccion(this.numerador * f.numerador, this.denominador * f.denominador);
    }
    public Fraccion2 dividir(Fraccion2 f) {
        return setFraccion(this.numerador * f.denominador, this.denominador * f.numerador);
    }
    public int getNumerador() {
        return numerador;
    }
    public Fraccion2 setNumerador(int numerador) {
        return setFraccion(numerador, this.denominador);
    }
    public int getDenominador() {
        return denominador;
    }
    public Fraccion2 setDenominador(int denominador) {
        return setFraccion(this.numerador, denominador);
    }
}