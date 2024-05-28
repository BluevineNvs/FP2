public class Rectangulo {
    private double longi;
    private double ancho;
    // Constructor
    public Rectangulo() {
        this.longi= 0.0;
        this.ancho = 0.0;
    }
    public Rectangulo(double longi, double ancho) {
        this.longi = longi;
        this.ancho = ancho;
    }
    // Método constructor sobrecargado
    public Rectangulo(double lado) {
        this.longi = lado;
        this.ancho = lado;
    }
    public void setLong(double longi) {
        this.longi = longi;
    }
    public double getLong() {
        return longi;
    }
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
    public double getAncho() {
        return ancho;
    }
    public double calcularArea() {
        return longi * ancho;
    }
    public double calcularPerimetro() {
        return 2 * (longi + ancho);
    }
    public boolean esCuadrado() {
        return longi == ancho;
    }
}
