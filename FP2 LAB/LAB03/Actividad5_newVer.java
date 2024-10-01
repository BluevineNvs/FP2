package LAB03;
//Laboratorio N° 03 - Ejercicio 3
//Autor: Nikole Valery Salas Idme
public class Actividad5_newVer {
    public static void main(String[] args) {
        start();
    }

    public static Soldados[] generador(){
        int longitud = (int)(Math.random() * (5 - 1 + 1) + 1);
        Soldados[] ejercito = new Soldados[longitud];
        for(int i = 0; i < longitud; i++){
            ejercito[i] = new Soldados();
            ejercito[i].setName("Soldado " + (i + 1));
        }
        return ejercito;
    }

    public static String mostrador(Soldados ejercito[], int x){
        String army = "Ejercito " + x + ": ";
        for(int i = 0; i < ejercito.length; i++){
            army = army + "\n" + ejercito[i].getName();
        }
        return army;
    }

    public static String ganador(String army1, String army2){
        if(army1.length() == army2.length()){
            return "¡La batalla esta muy encarnizada, termina en Empate!";
        }
        if(army1.length() > army2.length()){
            return "¡Ejercito 1 es el ganador! Congrats :)";
        }
        return "¡Ejercito 2 es el ganador! Congrats :)";
    }

    public static void start(){
        Soldados[] first = generador();
        Soldados[] second = generador();
        String team1 = mostrador(first, 1);
        String team2 = mostrador(second, 2);
        String winner = ganador(team1, team2);
        System.out.println(team1 + "\n" + "\n" + team2 + "\n" + "\n" + winner);
    }
}