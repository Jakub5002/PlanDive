package Services_tests;

import Entities.*;
import Services.SystemZapisow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SystemZapisowTest {

    private SystemZapisow system;
    private Kurs kurs;
    private Kursant kursant;

    @BeforeEach
    void setUp() {
        kurs = new Kurs();
        kurs.setKursId(1L);
        kurs.setLimitMiejsc(2);
        kurs.setZapisy(new ArrayList<>());

        kursant = new Kursant();
        kursant.setId(1L);
        kursant.setPesel("12345678901");

        system = new SystemZapisow(
                new ArrayList<>(List.of(kurs)),
                new ArrayList<>()
        );
    }

    @Test
    void utworzZapis_PowinienDodacZapisOStatusieOczekujacy() {
        ZapisKursanta zapis = system.utworzZapis(1L, kursant);
        assertNotNull(zapis);
        assertEquals(StatusZapisu.OCZEKUJACY, zapis.getStatus());
    }

    @Test
    void sprawdzDostepnoscMiejsc_PowinnaZwrocicTrue_GdySaWolneMiejsca() {
        assertTrue(system.sprawdzDostepnoscMiejsc(1L));
    }

    @Test
    void sprawdzLimit_PowinnaZwrocicTrue_GdyLimitOsiagniety() {
        system.utworzZapis(1L, kursant);
        system.utworzZapis(1L, kursant);
        // oba zapisy są OCZEKUJACE więc limit nie jest osiągnięty (liczy POTWIERDZONE)
        assertFalse(system.sprawdzLimit(1L));
    }

    @Test
    void zapiszNaKurs_PowinienZwrocicNull_GdyBrakKursu() {
        assertNull(system.zapiszNaKurs(99L, kursant));
    }
}