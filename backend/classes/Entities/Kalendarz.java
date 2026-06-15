import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class Kalendarz {
    private List<Zajecia> zajecia;
    private int miesiac;
    private int rok;

    public Kalendarz() {}

    public Kalendarz(List<Zajecia> zajecia, int miesiac, int rok) {
        this.zajecia = zajecia;
        this.miesiac = miesiac;
        this.rok = rok;
    }

    public List<Zajecia> getZajecia() { return zajecia; }
    public void setZajecia(List<Zajecia> zajecia) { this.zajecia = zajecia; }
    public int getMiesiac() { return miesiac; }
    public void setMiesiac(int miesiac) { this.miesiac = miesiac; }
    public int getRok() { return rok; }
    public void setRok(int rok) { this.rok = rok; }

    public List<Zajecia> pobierzZajeciaNaDzien(LocalDateTime dzien) {
        if (dzien == null || this.zajecia == null) {
            return new ArrayList<>();
        }

        return this.zajecia.stream().filter(z -> z.getDataRozpoczecia() != null).filter(z -> z.getDataRozpoczecia().toLocalDate().equals(dzien.toLocalDate())).collect(Collectors.toList());
    }
}