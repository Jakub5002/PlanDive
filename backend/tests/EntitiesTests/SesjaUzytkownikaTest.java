package EntitiesTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import Entities.*;

import static org.junit.jupiter.api.Assertions.*;

class SesjaUzytkownikaTest {

    private SesjaUzytkownika sesja;

    @BeforeEach
    void setUp() {
        sesja = new SesjaUzytkownika();
    }

    @Test
    void czyWazna_PowinnaZwrocicTrue_GdyDataWygasnieciaWPrzyszlosci() {
        // Given
        sesja.setDataWygasniecia(LocalDateTime.now().plusHours(1));

        // When & Then
        assertTrue(sesja.czyWazna(), "Sesja powinna być ważna, jeśli czas wygaśnięcia jeszcze nie minął.");
    }

    @Test
    void czyWazna_PowinnaZwrocicFalse_GdyDataWygasnieciaWPrzeszlosci() {
        // Given
        sesja.setDataWygasniecia(LocalDateTime.now().minusMinutes(5));

        // When & Then
        assertFalse(sesja.czyWazna(), "Sesja powinna być nieważna, jeśli czas wygaśnięcia minął.");
    }

    @Test
    void czyWazna_PowinnaZwrocicFalse_GdyDataWygasnieciaJestNull() {
        // Given
        sesja.setDataWygasniecia(null);

        // When & Then
        assertFalse(sesja.czyWazna(), "Sesja bez ustawionej daty wygasaśnięcia powinna być nieważna.");
    }
}