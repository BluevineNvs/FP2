public class Fecha {
    private int dia;
    private int mes;
    private long año;

    public Fecha() {
        this(1, 1, 1900);
    }
    public Fecha(long año) {
        this(1, 1, año);
    }
    public Fecha(int mes, int año) {
        this(1, mes, año);
    }
    public Fecha(int dia, int mes, long año2) {
        setFecha(dia, mes, año2);
    }
    public Fecha(Fecha f) {
        this(f.dia, f.mes, f.año);
    }
    public Fecha(int diasDesde2000) {
        setFechaDesde2000(diasDesde2000);
    }
    public void setFecha(int dia, int mes, long año2) {
        if (esFechaValida(dia, mes, año2)) {
            this.dia = dia;
            this.mes = mes;
            this.año = año2;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.año = 1900;
        }
    }
    public boolean esFechaValida(int dia, int mes, long año2) {
        if (mes < 1 || mes > 12) return false;
        if (dia < 1 || dia > diasEnMes(mes, año2)) return false;
        return true;
    }
    public int diasEnMes(int mes, long año2) {
        switch (mes) {
            case 4: 
            case 6: 
            case 9: 
            case 11: 
            return 30;
            case 2: 
            return esBisiesto(año2) ? 29 : 28;
            default: 
            return 31;
        }
    }
    public boolean esBisiesto(long año2) {
        return (año2 % 4 == 0 && año2 % 100 != 0) || (año2 % 400 == 0);
    }
    public void setFechaDesde2000(int dias) {
        this.año = 2000 + dias / 365;
        int diasRestantes = dias % 365;
        this.mes = diasRestantes / 30 + 1;
        this.dia = diasRestantes % 30 + 1;
    }
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, año);
    }
    public int getDia() { 
        return dia; 
    }
    public void setDia(int dia) { 
        setFecha(dia, this.mes, this.año); 
    }
    public int getMes() { 
        return mes; 
    }
    public void setMes(int mes) { 
        setFecha(this.dia, mes, this.año); 
    }
    public int getAño() { 
        return (int) año; 
    }
    public void setAño(int año) { 
        setFecha(this.dia, this.mes, año); 
    }
}