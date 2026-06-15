package Services;

import Entities.*;
import java.util.Date;
import java.util.List;

public class SystemZapisow {

    private List<Kurs> kursy;
    private List<ZapisKursanta> zapisy;

    public SystemZapisow(List<Kurs> kursy, List<ZapisKursanta> zapisy) {
        this.kursy = kursy;
        this.zapisy = zapisy;
    }

    public ZapisKursanta zapiszNaKurs(Long kursId, Kursant kursant) {
        if (!sprawdzDostepnoscMiejsc(kursId)) return null;
        if (!sprawdzWaznosBadan(kursant)) return null;
        return utworzZapis(kursId, kursant);
    }

    public boolean sprawdzDostepnoscMiejsc(Long kursId) {
        Kurs kurs = znajdzKurs(kursId);
        if (kurs == null) return false;
        return !kurs.sprawdzLimit();
    }

    public boolean sprawdzWaznosBadan(Kursant kursant) {
        // TODO: docelowo sprawdzać datę ważności badań
        return kursant != null && kursant.getPesel() != null;
    }

    public boolean sprawdzLimit(Long kursId) {
        Kurs kurs = znajdzKurs(kursId);
        if (kurs == null) return false;
        return kurs.sprawdzLimit();
    }

    public ZapisKursanta utworzZapis(Long kursId, Kursant kursant) {
        Kurs kurs = znajdzKurs(kursId);
        if (kurs == null) return null;

        ZapisKursanta zapis = new ZapisKursanta();
        zapis.setZapisId((long) (zapisy.size() + 1));
        zapis.setKurs(kurs);
        zapis.setKursant(kursant);
        zapis.setStatus(StatusZapisu.OCZEKUJACY);
        zapis.setDataZapisu(new Date());

        zapisy.add(zapis);
        kurs.getZapisy().add(zapis);
        return zapis;
    }

    private Kurs znajdzKurs(Long kursId) {
        return kursy.stream()
                .filter(k -> k.getKursId().equals(kursId))
                .findFirst()
                .orElse(null);
    }
}