package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UstawieniaAplikacji {
    private String jezyk;
    private String strefaCzasowa;
    private String hashedHaslo;
    private List<String> urzadzenia;

    public UstawieniaAplikacji() {}

    public UstawieniaAplikacji(String jezyk, String strefaCzasowa, String hashedHaslo, List<String> urzadzenia) {
        this.jezyk = jezyk;
        this.strefaCzasowa = strefaCzasowa;
        this.hashedHaslo = hashedHaslo;
        this.urzadzenia = urzadzenia;
    }

    public String getJezyk() { return jezyk; }
    public void setJezyk(String jezyk) { this.jezyk = jezyk; }
    public String getStrefaCzasowa() { return strefaCzasowa; }
    public void setStrefaCzasowa(String strefaCzasowa) { this.strefaCzasowa = strefaCzasowa; }
    public String getHashedHaslo() { return hashedHaslo; }
    public void setHashedHaslo(String hashedHaslo) { this.hashedHaslo = hashedHaslo; }
    public List<String> getUrzadzenia() { return urzadzenia; }
    public void setUrzadzenia(List<String> urzadzenia) { this.urzadzenia = urzadzenia; }

    public void zmienHaslo(String stare, String nowe) {
        if(stare == hashedHaslo) {
            hashedHaslo = nowe;
        }
    }


    public void zarzadzajUrzadzeniami() {
        if (this.urzadzenia == null) {
            this.urzadzenia = new ArrayList<>();
            return;
        }

        this.urzadzenia = this.urzadzenia.stream().distinct().collect(Collectors.toList());

        final int MAX_URZADZEN = 5;
        while (this.urzadzenia.size() > MAX_URZADZEN) {
            this.urzadzenia.removeFirst();
        }
    }
}