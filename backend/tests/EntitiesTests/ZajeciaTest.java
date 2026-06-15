package EntitiesTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import Entities.*;


class ZajeciaTest {

    private Zajecia zajecia;

    @BeforeEach
    void setUp() {
        zajecia = new Zajecia();
        zajecia.setOdwolane(false);
        zajecia.setMiejsce("Sala 101");

        // Ustawiamy zajęcia trwające dokładnie 2 godziny (12:00 - 14:00)
        zajecia.setDataRozpoczecia(LocalDateTime.of(2026, 6, 15, 12, 0));
        zajecia.setDataZakonczenia(LocalDateTime.of(2026, 6, 15, 14, 0));
    }

    @Test
    void odwolaj_PowinnaUstawicFlageOdwolaneNaTrue() {
        // When
        zajecia.odwolaj();

        // Then
        assertTrue(zajecia.isOdwolane(), "Flaga 'odwolane' powinna zmienić wartość na true.");
    }

    @Test
    void zaproponujZmiane_PowinnaZmienicMiejsce_I_PrzesunacTerminZachowujacCzasTrwania() {
        // Given
        LocalDateTime nowyTermin = LocalDateTime.of(2026, 6, 16, 16, 0); // Następny dzień 16:00
        String noweMiejsce = "Plac manewrowy A";
        zajecia.setOdwolane(true); // Wyjściowo odwołane

        // When
        zajecia.zaproponujZmiane(nowyTermin, noweMiejsce);

        // Then
        assertEquals(nowyTermin, zajecia.getDataRozpoczecia(), "Nowa data rozpoczęcia powinna być zgodna z propozycją.");
        assertEquals(LocalDateTime.of(2026, 6, 16, 18, 0), zajecia.getDataZakonczenia(),
                "Nowa data zakończenia powinna automatycznie zachować 2-godzinny czas trwania (16:00 + 2h = 18:00).");
        assertEquals("Plac manewrowy A", zajecia.getMiejsce(), "Miejsce powinno zostać zaktualizowane.");
        assertFalse(zajecia.isOdwolane(), "Zajęcia po zaproponowaniu nowej zmiany nie powinny być już oznaczone jako odwołane.");
    }
}