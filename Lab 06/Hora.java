public class Hora {
    private int hour;
    private int minute;
    private int second;

    public Hora(int hour, int minute, int second) {
        if (hour >= 0 && hour < 24 && minute >= 0 && minute < 60 && second >= 0 && second < 60) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        } else {
            this.hour = 0;
            this.minute = 0;
            this.second = 0;
        }
    }
    public void setHora(int hour) {
        if (hour >= 0 && hour < 24) {
            this.hour = hour;
        }
    }
    public int getHora() {
        return hour;
    }
    public void setMinuto(int minute) {
        if (minute >= 0 && minute < 60) {
            this.minute = minute;
        }
    }
    public int getMinuto() {
        return minute;
    }
    public void setSegundo(int second) {
        if (second >= 0 && second < 60) {
            this.second = second;
        }
    }
    public int getSegundo() {
        return second;
    }
    public void aumentarMinuto() {
        minute++;
        if (minute == 60) {
            minute = 0;
            aumentarHora();
        }
    }
    public void aumentarSegundo() {
        second++;
        if (second == 60) {
            second = 0;
            aumentarMinuto();
        }
    }
    public void aumentarHora() {
        hour++;
        if (hour == 24) {
            hour = 0;
        }
    }
    public String mostrarHora() {
        return (String.format("%02d:%02d:%02d", hour, minute, second));
    }
}