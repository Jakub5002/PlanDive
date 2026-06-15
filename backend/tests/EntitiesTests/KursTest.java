package EntitiesTests;

import Entities.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KursTest {

    private Kurs kurs;

    @BeforeEach
    void setUp() {
        kurs = new Kurs();
        kurs.setLimitMiejsc(2);
        kurs.setZapisy(new ArrayList<>());
        kurs.setKroki(Arrays.asList("Teoria", "Plac manewrowy", "Miasto"));
        kurs.setProgres(0);
    }

    @Test
    void sprawdzLimit_PowinnaZwrocicFalse_GdyLiczbaPotwierdzonychZapisowJestMniejszaNizLimit() {
        // Given
        ZapisKursanta z1 = new ZapisKursanta();
        z1.setStatus(StatusZapisu.POTWIERDZONY);

        ZapisKursanta z2 = new ZapisKursanta();
        z2.setStatus(StatusZapisu.OCZEKUJACY); // Ten nie powinien być wliczany

        kurs.getZapisy().add(z1);
        kurs.getZapisy().add(z2);

        // When & Then
        assertFalse(kurs.sprawdzLimit(), "Limit nie powinien być przekroczony, jest tylko 1 potwierdzony zapis na 2 miejsca.");
    }

    @Test
    void sprawdzLimit_PowinnaZwrocicTrue_GdyOsiagnietoLimitMiejsc() {
        // Given
        ZapisKursanta z1 = new ZapisKursanta();
        z1.setStatus(StatusZapisu.POTWIERDZONY);

        ZapisKursanta z2 = new ZapisKursanta();
        z2.setStatus(StatusZapisu.POTWIERDZONY);

        kurs.getZapisy().add(z1);
        kurs.getZapisy().add(z2);

        // When & Then
        assertTrue(kurs.sprawdzLimit(), "Limit powinien być oznaczony jako osiągnięty (2 z 2 miejsc zajęte).");
    }

    @Test
    void nastepnyKrok_PowinnaZwiekszacProgres_GdySaDostepneKroki() {
        // When
        kurs.nastepnyKrok();

        // Then
        assertEquals(1, kurs.getProgres(), "Progres powinien wzrosnąć z 0 do 1.");
    }

    @Test
    void nastepnyKrok_NiePowinnaZwiekszacProgresu_GdyOsiagnietoOstatniKrok() {
        // Given - ustawiamy maksymalny możliwy progres równy rozmiarowi listy kroków
        kurs.setProgres(3);

        // When
        kurs.nastepnyKrok();

        // Then
        assertEquals(3, kurs.getProgres(), "Progres nie powinien wyjść poza rozmiar listy kroków (maksymalnie 3).");
    }
}