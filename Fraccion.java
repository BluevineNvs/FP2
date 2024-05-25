public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion() {
        this(0, 1);
    }
    public Fraccion(int numerador) {
        this(numerador, 1);
    }
    public Fraccion(int numerador, int denominador) {
        setFraccion(numerador, denominador);
    }
    public Fraccion(Fraccion f) {
        this(f.numerador, f.denominador);
    }
    public void setFraccion(int numerador, int denominador) {
        if (denominador == 0) {
            denominador = 1; 
        }
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
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
    public Fraccion sumar(Fraccion f) {
        int n = this.numerador * f.denominador + f.numerador * this.denominador;
        int d = this.denominador * f.denominador;
        return new Fraccion(n, d);
    }
    public Fraccion restar(Fraccion f) {
        int n = this.numerador * f.denominador - f.numerador * this.denominador;
        int d = this.denominador * f.denominador;
        return new Fraccion(n, d);
    }
    public Fraccion multiplicar(Fraccion f) {
        return new Fraccion(this.numerador * f.numerador, this.denominador * f.denominador);
    }
    public Fraccion dividir(Fraccion f) {
        return new Fraccion(this.numerador * f.denominador, this.denominador * f.numerador);
    }
    public int getNumerador() { 
        return numerador; 
    }
    public void setNumerador(int numerador) { 
        setFraccion(numerador, this.denominador); 
    }
    public int getDenominador() { 
        return denominador; 
    }
    public void setDenominador(int denominador) { 
        setFraccion(this.numerador, denominador); 
    }
}