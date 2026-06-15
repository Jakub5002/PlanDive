package Entities;

import java.util.Date;

public class ZapisKursanta {
    private Long zapisId;
    private StatusZapisu status;
    private Date dataZapisu;
    private Kurs kurs;
    private Kursant kursant;

    public ZapisKursanta() {}

    public ZapisKursanta(Long zapisId, StatusZapisu status, Date dataZapisu, Kurs kurs, Kursant kursant) {
        this.zapisId = zapisId;
        this.status = status;
        this.dataZapisu = dataZapisu;
        this.kurs = kurs;
        this.kursant = kursant;
    }

    public Long getZapisId() { return zapisId; }
    public void setZapisId(Long zapisId) { this.zapisId = zapisId; }
    public StatusZapisu getStatus() { return status; }
    public void setStatus(StatusZapisu status) { this.status = status; }
    public Date getDataZapisu() { return dataZapisu; }
    public void setDataZapisu(Date dataZapisu) { this.dataZapisu = dataZapisu; }
    public Kurs getKurs() { return kurs; }
    public void setKurs(Kurs kurs) { this.kurs = kurs; }
    public Kursant getKursant() { return kursant; }
    public void setKursant(Kursant kursant) { this.kursant = kursant; }

    public void potwierdzZapis() {
        if (this.kurs == null) {
            System.out.println("Błąd: Nie można potwierdzić zapisu, ponieważ kurs nie istnieje.");
            return;
        }
        if (this.kurs.sprawdzLimit()) {
            System.out.println("Nie można potwierdzić zapisu. Brak wolnych miejsc na kursie: " + this.kurs.getNazwa());
            return;
        }
        this.status = StatusZapisu.POTWIERDZONY;
        System.out.println("Zapis o ID " + this.zapisId + " został pomyślnie potwierdzony.");
    }

    public void odrzucZapis() {
        this.status = StatusZapisu.ODRZUCONY;
        System.out.println("Zapis o ID " + this.zapisId + " został odrzucony.");
    }
}