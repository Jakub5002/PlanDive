package Entities;

import java.util.List;

public class Kurs {
    private Long kursId;
    private String nazwa;
    private int czasTrwaniaTygodni;
    private int limitMiejsc;
    private Instruktor instruktor;
    private int progres;
    private List<String> kroki;
    private List<ZapisKursanta> zapisy;

    public Kurs() {}

    public Kurs(Long kursId, String nazwa, int czasTrwaniaTygodni, int limitMiejsc, Instruktor instruktor, int progres, List<String> kroki, List<ZapisKursanta> zapisy) {
        this.kursId = kursId;
        this.nazwa = nazwa;
        this.czasTrwaniaTygodni = czasTrwaniaTygodni;
        this.limitMiejsc = limitMiejsc;
        this.instruktor = instruktor;
        this.progres = progres;
        this.kroki = kroki;
        this.zapisy = zapisy;
    }

    public Long getKursId() { return kursId; }
    public void setKursId(Long kursId) { this.kursId = kursId; }
    public String getNazwa() { return nazwa; }
    public void setNazwa(String nazwa) { this.nazwa = nazwa; }
    public int getCzasTrwaniaTygodni() { return czasTrwaniaTygodni; }
    public void setCzasTrwaniaTygodni(int czasTrwaniaTygodni) { this.czasTrwaniaTygodni = czasTrwaniaTygodni; }
    public int getLimitMiejsc() { return limitMiejsc; }
    public void setLimitMiejsc(int limitMiejsc) { this.limitMiejsc = limitMiejsc; }
    public Instruktor getInstruktor() { return instruktor; }
    public void setInstruktor(Instruktor instruktor) { this.instruktor = instruktor; }
    public int getProgres() { return progres; }
    public void setProgres(int progres) { this.progres = progres; }
    public List<String> getKroki() { return kroki; }
    public void setKroki(List<String> kroki) { this.kroki = kroki; }
    public List<ZapisKursanta> getZapisy() { return zapisy; }
    public void setZapisy(List<ZapisKursanta> zapisy) { this.zapisy = zapisy; }

    public boolean sprawdzLimit() {
        if (this.zapisy == null) {
            return false;
        }
        long liczbaPotwierdzonychKursantow = this.zapisy.stream().filter(zapis -> zapis.getStatus() == StatusZapisu.POTWIERDZONY).count();

        return liczbaPotwierdzonychKursantow >= this.limitMiejsc;
    }

    public void nastepnyKrok() {
        if (this.kroki != null && this.progres < this.kroki.size()) {
            this.progres++;
        }
    }
}