package Entities;

import java.time.LocalDateTime;

public class Zajecia {
    private Long zajeciaId;
    private String nazwa;
    private LocalDateTime dataRozpoczecia;
    private LocalDateTime dataZakonczenia;
    private String grupa;
    private String miejsce;
    private boolean odwolane;

    public Zajecia() {}

    public Zajecia(Long zajeciaId, String nazwa, LocalDateTime dataRozpoczecia, LocalDateTime dataZakonczenia, String grupa, String miejsce, boolean odwolane) {
        this.zajeciaId = zajeciaId;
        this.nazwa = nazwa;
        this.dataRozpoczecia = dataRozpoczecia;
        this.dataZakonczenia = dataZakonczenia;
        this.grupa = grupa;
        this.miejsce = miejsce;
        this.odwolane = odwolane;
    }

    public Long getZajeciaId() { return zajeciaId; }
    public void setZajeciaId(Long zajeciaId) { this.zajeciaId = zajeciaId; }
    public String getNazwa() { return nazwa; }
    public void setNazwa(String nazwa) { this.nazwa = nazwa; }
    public LocalDateTime getDataRozpoczecia() { return dataRozpoczecia; }
    public void setDataRozpoczecia(LocalDateTime dataRozpoczecia) { this.dataRozpoczecia = dataRozpoczecia; }
    public LocalDateTime getDataZakonczenia() { return dataZakonczenia; }
    public void setDataZakonczenia(LocalDateTime dataZakonczenia) { this.dataZakonczenia = dataZakonczenia; }
    public String getGrupa() { return grupa; }
    public void setGrupa(String grupa) { this.grupa = grupa; }
    public String getMiejsce() { return miejsce; }
    public void setMiejsce(String miejsce) { this.miejsce = miejsce; }
    public boolean isOdwolane() { return odwolane; }
    public void setOdwolane(boolean odwolane) { this.odwolane = odwolane; }

    public void odwolaj() {
        this.odwolane = true;
    }

    public void zaproponujZmiane(LocalDateTime nowaData, String noweMiejsce) {
        if (nowaData == null) {
            return;
        }
        if (this.dataRozpoczecia != null && this.dataZakonczenia != null) {
            java.time.Duration czasTrwania = java.time.Duration.between(this.dataRozpoczecia, this.dataZakonczenia);
            this.dataRozpoczecia = nowaData;
            this.dataZakonczenia = nowaData.plus(czasTrwania);
        } else {
            this.dataRozpoczecia = nowaData;
            this.dataZakonczenia = nowaData.plusHours(2);
        }

        if (noweMiejsce != null && !noweMiejsce.trim().isEmpty()) {
            this.miejsce = noweMiejsce;
        }
        this.odwolane = false;
    }
}