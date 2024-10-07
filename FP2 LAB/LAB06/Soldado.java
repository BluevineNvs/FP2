package LAB06;
//Laboratorio N° 06 - Ejercicio 3
//Autor: Nikole Valery Salas Idme
public class Soldado {
    private String name;
    private int hp;
    private int fila;
    private int columna;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getFila() {
        return fila;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }
    public int getColumna() {
        return columna;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }
    public String toString() {
        return "Nombre: " + name + " Nivel de Vida: " 
        + hp + " Fila: " + fila + " Columna: " + columna;
    }
}