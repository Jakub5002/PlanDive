package EntitiesTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import Entities.*;

class UstawieniaAplikacjiTest {

    private UstawieniaAplikacji ustawienia;

    @BeforeEach
    void setUp() {
        ustawienia = new UstawieniaAplikacji();
        // Inicjalizujemy listę mutowalną (ArrayList), bo List.of() tworzy listę niemutowalną
        ustawienia.setUrzadzenia(new ArrayList<>(Arrays.asList("Telefon", "Laptop", "Tablet")));
    }

    @Test
    void zarzadzajUrzadzeniami_PowinnaUsunacDuplikaty_I_ZachowacLimitMaksymalniePieciu() {
        // Given - dodajemy duplikaty oraz przekraczamy limit 5 urządzeń (łącznie 7 wpisów, w tym powtórki)
        ustawienia.setUrzadzenia(new ArrayList<>(Arrays.asList(
                "Telefon", "Laptop", "Tablet", "Telefon", "PC", "Konsola", "SmartTV"
        )));

        // When
        ustawienia.zarzadzajUrzadzeniami();

        // Then
        assertTrue(ustawienia.getUrzadzenia().size() <= 5, "Liczba urządzeń po uporządkowaniu nie może przekraczać 5.");

        long unikalneWpisy = ustawienia.getUrzadzenia().stream().distinct().count();
        assertEquals(ustawienia.getUrzadzenia().size(), unikalneWpisy, "Na liście nie powinno być żadnych duplikatów.");
    }
}