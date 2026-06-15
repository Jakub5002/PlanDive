package Services_tests;

import Entities.*;
import Services.SerwisHarmonogramu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SerwisHarmonogramuTest {

    private SerwisHarmonogramu serwis;
    private Zajecia zajecia;
    private Kalendarz kalendarz;
    private Kursant kursant;
    private GrupaZajeciowa grupa;

    @BeforeEach
    void setUp() {
        zajecia = new Zajecia();
        zajecia.setZajeciaId(1L);
        zajecia.setNazwa("Teoria");
        zajecia.setMiejsce("Sala 1");
        zajecia.setDataRozpoczecia(LocalDateTime.of(2025, 6, 15, 10, 0));
        zajecia.setDataZakonczenia(LocalDateTime.of(2025, 6, 15, 12, 0));
        zajecia.setOdwolane(false);

        kalendarz = new Kalendarz();
        kalendarz.setZajecia(new ArrayList<>(List.of(zajecia)));

        kursant = new Kursant();
        kursant.setId(1L);

        grupa = new GrupaZajeciowa();
        grupa.setKursanci(new ArrayList<>(List.of(kursant)));
        grupa.setHarmonogram(new ArrayList<>(List.of(zajecia)));

        serwis = new SerwisHarmonogramu(
                new ArrayList<>(List.of(kalendarz)),
                new ArrayList<>(List.of(grupa))
        );
    }

    @Test
    void pobierzUczestnikow_PowinienZwrocicListeKursantow() {
        List<Kursant> uczestnicy = serwis.pobierzUczestnikow(1L);
        assertEquals(1, uczestnicy.size());
    }

    @Test
    void sprawdzKonfliktTerminu_PowinienZwrocicTrue_GdyTerminWKolizji() {
        LocalDateTime termin = LocalDateTime.of(2025, 6, 15, 11, 0);
        assertTrue(serwis.sprawdzKonfliktTerminu(1L, termin));
    }

    @Test
    void sprawdzKonfliktTerminu_PowinienZwrocicFalse_GdyBrakKolizji() {
        LocalDateTime termin = LocalDateTime.of(2025, 6, 16, 11, 0);
        assertFalse(serwis.sprawdzKonfliktTerminu(1L, termin));
    }

    @Test
    void zapiszZmiany_PowinienZmienicDateIMiejsce() {
        LocalDateTime nowaData = LocalDateTime.of(2025, 7, 1, 9, 0);
        serwis.zapiszZmiany(1L, nowaData, "Sala 2");
        assertEquals("Sala 2", zajecia.getMiejsce());
        assertEquals(nowaData, zajecia.getDataRozpoczecia());
    }
}