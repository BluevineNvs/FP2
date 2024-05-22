
public class Prueba {
    public static void main(String[] args) {
        Rectangulo rectangulo = new Rectangulo();
        
        rectangulo.setLong(5.0);
        rectangulo.setAncho(3.0);

        double area1 = rectangulo.calcularArea();
        double perimetro1 = rectangulo.calcularPerimetro();
        boolean esCuadrado1 = rectangulo.esCuadrado();
        
        System.out.println("Rectangulo: ");
        System.out.println("Área: " + area1);
        System.out.println("Perímetro: " + perimetro1);
        System.out.println("¿Es cuadrado? " + esCuadrado1);
        
    }
}