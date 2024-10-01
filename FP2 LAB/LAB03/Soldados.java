package LAB03;
//Laboratorio N° 03 - Ejercicio 1
//Autor: Nikole Valery Salas Idme
class Soldados{
    private String name;
    private int hp;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPoints(int hp){
        this.hp = hp;
    }

    public int getPoint(){
        return hp;
    }

    public String toString(){
        return "Nombre: " + name + " Puntos: " + hp;
    }
    
}