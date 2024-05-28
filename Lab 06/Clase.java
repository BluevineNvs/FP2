public class Clase {
    public static void main(String[] args) {
        Bicicleta a = new Bicicleta("Pepe", 4);
        Bicicleta b = new Bicicleta("Juanita", 365);
        System.out.println(a.toString() + b.toString());
    }
}

class Bicicleta{
    private String owner;
    private int days;

    public Bicicleta(String owner, int days) {
        this.owner = owner;
        this.days = days;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public int getDays() {
        return days;
    }
    public void setDays(int days) {
        this.days = days;
    }
    public String toString(){
        return "El dueño es: " + owner + " Y está separado por: " + days + " días";
    }
}
