package Services;

import Entities.Zajecia;
import Entities.Kalendarz;
import Entities.Kursant;
import Entities.GrupaZajeciowa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class SerwisHarmonogramu {

    private List<Kalendarz> kalendarze;
    private List<GrupaZajeciowa> grupy;

    public SerwisHarmonogramu(List<Kalendarz> kalendarze, List<GrupaZajeciowa> grupy) {
        this.kalendarze = kalendarze;
        this.grupy = grupy;
    }

    public List<Kursant> pobierzUczestnikow(Long sesjaId) {
        for (GrupaZajeciowa grupa : grupy) {
            if (grupa.getHarmonogram() != null) {
                boolean maZajecia = grupa.getHarmonogram().stream()
                        .anyMatch(z -> z.getZajeciaId().equals(sesjaId));
                if (maZajecia) {
                    return grupa.getKursanci();
                }
            }
        }
        return new ArrayList<>();
    }

    public void zaktualizujZajecia(Long sesjaId, Zajecia dane) {
        for (Kalendarz kalendarz : kalendarze) {
            if (kalendarz.getZajecia() == null) continue;
            for (Zajecia z : kalendarz.getZajecia()) {
                if (z.getZajeciaId().equals(sesjaId)) {
                    z.setNazwa(dane.getNazwa());
                    z.setMiejsce(dane.getMiejsce());
                    z.setDataRozpoczecia(dane.getDataRozpoczecia());
                    z.setDataZakonczenia(dane.getDataZakonczenia());
                    return;
                }
            }
        }
    }

    public void zapiszZmiany(Long sesjaId, LocalDateTime nowaData, String noweMiejsce) {
        for (Kalendarz kalendarz : kalendarze) {
            if (kalendarz.getZajecia() == null) continue;
            for (Zajecia z : kalendarz.getZajecia()) {
                if (z.getZajeciaId().equals(sesjaId)) {
                    z.zaproponujZmiane(nowaData, noweMiejsce);
                    return;
                }
            }
        }
    }

    public boolean sprawdzKonfliktTerminu(Long instruktorId, LocalDateTime termin) {
        for (Kalendarz kalendarz : kalendarze) {
            if (kalendarz.getZajecia() == null) continue;
            for (Zajecia z : kalendarz.getZajecia()) {
                if (!z.isOdwolane()
                        && z.getDataRozpoczecia() != null
                        && z.getDataZakonczenia() != null
                        && !termin.isBefore(z.getDataRozpoczecia())
                        && !termin.isAfter(z.getDataZakonczenia())) {
                    return true;
                }
            }
        }
        return false;
    }
}