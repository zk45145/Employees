package pracownicy;

import java.io.Serializable;

public class Pracownik implements Serializable {
    private String pesel;
    private String imie;
    private String nazwisko;
    private String stanowisko;
    private int wynagrodzenie;
    private int telefon;

    void setPesel (String pesel) { this.pesel = pesel; }
    String getPesel() { return this.pesel; }
    public void setImie(String imie) { this.imie = imie; }
    String getImie(){return this.imie;}
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    String getNazwisko(){ return this.nazwisko; }
    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }
    String getStanowisko (){ return this.stanowisko; }
    public void setWynagrodzenie(int wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }
    int getWynagrodzenie(){ return this.wynagrodzenie; }
    public void setTelefon(int telefon) { this.telefon = telefon; }
    int getTelefon(){ return this.telefon;}


}
