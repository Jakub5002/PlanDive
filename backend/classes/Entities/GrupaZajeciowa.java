import java.util.List;

public class GrupaZajeciowa {
    private String nazwaGrupy;
    private Kurs kurs;
    private List<Kursant> kursanci;
    private List<Zajecia> harmonogram;

    public GrupaZajeciowa() {}

    public GrupaZajeciowa(String nazwaGrupy, Kurs kurs, List<Kursant> kursanci, List<Zajecia> harmonogram) {
        this.nazwaGrupy = nazwaGrupy;
        this.kurs = kurs;
        this.kursanci = kursanci;
        this.harmonogram = harmonogram;
    }

    public String getNazwaGrupy() { return nazwaGrupy; }
    public void setNazwaGrupy(String nazwaGrupy) { this.nazwaGrupy = nazwaGrupy; }
    public Kurs getKurs() { return kurs; }
    public void setKurs(Kurs kurs) { this.kurs = kurs; }
    public List<Kursant> getKursanci() { return kursanci; }
    public void setKursanci(List<Kursant> kursanci) { this.kursanci = kursanci; }
    public List<Zajecia> getHarmonogram() { return harmonogram; }
    public void setHarmonogram(List<Zajecia> harmonogram) { this.harmonogram = harmonogram; }
}