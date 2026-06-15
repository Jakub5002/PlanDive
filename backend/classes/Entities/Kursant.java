package Entities;

import java.time.LocalDate;

public class Kursant extends Uzytkownik {
    private String numerPKK;
    private LocalDate dataUrodzenia;
    private String pesel;
    private String adres;
    private String rozmiarUbrania;
    private int rozmiarButa;
    private char plec;

    public Kursant() {}

    public Kursant(String numerPKK, LocalDate dataUrodzenia, String pesel, String adres, String rozmiarUbrania, int rozmiarButa, char plec) {
        this.numerPKK = numerPKK;
        this.dataUrodzenia = dataUrodzenia;
        this.pesel = pesel;
        this.adres = adres;
        this.rozmiarUbrania = rozmiarUbrania;
        this.rozmiarButa = rozmiarButa;
        this.plec = plec;
    }

    public String getNumerPKK() { return numerPKK; }
    public void setNumerPKK(String numerPKK) { this.numerPKK = numerPKK; }
    public LocalDate getDataUrodzenia() { return dataUrodzenia; }
    public void setDataUrodzenia(LocalDate dataUrodzenia) { this.dataUrodzenia = dataUrodzenia; }
    public String getPesel() { return pesel; }
    public void setPesel(String pesel) { this.pesel = pesel; }
    public String getAdres() { return adres; }
    public void setAdres(String adres) { this.adres = adres; }
    public String getRozmiarUbrania() { return rozmiarUbrania; }
    public void setRozmiarUbrania(String rozmiarUbrania) { this.rozmiarUbrania = rozmiarUbrania; }
    public int getRozmiarButa() { return rozmiarButa; }
    public void setRozmiarButa(int rozmiarButa) { this.rozmiarButa = rozmiarButa; }
    public char getPlec() { return plec; }
    public void setPlec(char plec) { this.plec = plec; }
}