package Services;

import Entities.Kurs;
import Entities.Instruktor;
import java.util.List;

public class SystemKursow {

    private List<Kurs> kursy;
    private List<Instruktor> instruktorzy;

    public SystemKursow(List<Kurs> kursy, List<Instruktor> instruktorzy) {
        this.kursy = kursy;
        this.instruktorzy = instruktorzy;
    }

    public void przypiszInstruktora(Long kursId, Long instruktorId) {
        Kurs kurs = kursy.stream()
                .filter(k -> k.getKursId().equals(kursId))
                .findFirst()
                .orElse(null);

        Instruktor instruktor = instruktorzy.stream()
                .filter(i -> i.getId().equals(instruktorId))
                .findFirst()
                .orElse(null);

        if (kurs != null && instruktor != null) {
            kurs.setInstruktor(instruktor);
        }
    }

    public boolean sprawdzKwalifikacje(Long instruktorId, Long kursId) {
        Instruktor instruktor = instruktorzy.stream()
                .filter(i -> i.getId().equals(instruktorId))
                .findFirst()
                .orElse(null);
        if(instruktor != null) return true;
        return false;
    }

    public void odrzucPrzypis(String powod) {
        // TODO
    }

    public void potwierdzPrzypis() {
        // TODO
    }
}