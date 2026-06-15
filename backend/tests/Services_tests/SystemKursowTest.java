package Services_tests;

import Entities.Instruktor;
import Entities.Kurs;
import Services.SystemKursow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SystemKursowTest {

    private SystemKursow system;
    private Kurs kurs;
    private Instruktor instruktor;

    @BeforeEach
    void setUp() {
        instruktor = new Instruktor();
        instruktor.setId(1L);
        instruktor.setLegitymacja("LEG-123");

        kurs = new Kurs();
        kurs.setKursId(1L);

        system = new SystemKursow(
                new ArrayList<>(List.of(kurs)),
                new ArrayList<>(List.of(instruktor))
        );
    }

    @Test
    void przypiszInstruktora_PowinienPrzpisacInstruktora() {
        system.przypiszInstruktora(1L, 1L);
        assertEquals(instruktor, kurs.getInstruktor());
    }

    @Test
    void sprawdzKwalifikacje_PowinnaZwrocicTrue_GdyInstruktorMaLegitymacje() {
        assertTrue(system.sprawdzKwalifikacje(1L, 1L));
    }

    @Test
    void sprawdzKwalifikacje_PowinnaZwrocicFalse_GdyBrakInstruktora() {
        assertFalse(system.sprawdzKwalifikacje(99L, 1L));
    }
}