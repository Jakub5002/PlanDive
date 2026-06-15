package EntitiesTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import Entities.*;

class ZapisKursantaTest {

    private ZapisKursanta zapis;
    private Kurs mockKurs;

    @BeforeEach
    void setUp() {
        zapis = new ZapisKursanta();
        zapis.setZapisId(100L);
        zapis.setStatus(StatusZapisu.OCZEKUJACY);

        mockKurs = new Kurs();
        mockKurs.setLimitMiejsc(1);
        mockKurs.setZapisy(new ArrayList<>());

        zapis.setKurs(mockKurs);
    }

    @Test
    void potwierdzZapis_PowinnaZmienicStatusNaPotwierdzony_GdyKursMaWolneMiejsca() {
        // When
        zapis.potwierdzZapis();

        // Then
        assertEquals(StatusZapisu.POTWIERDZONY, zapis.getStatus(), "Status powinien zmienić się na POTWIERDZONY.");
    }

    @Test
    void potwierdzZapis_NiePowinnaZmieniacStatusu_GdyKursJestPelny() {
        // Given - symulujemy, że limit miejsc na kursie został już wyczerpany
        ZapisKursanta innyZapis = new ZapisKursanta();
        innyZapis.setStatus(StatusZapisu.POTWIERDZONY);
        mockKurs.getZapisy().add(innyZapis); // Zajmujemy jedyne wolne miejsce

        // When
        zapis.potwierdzZapis();

        // Then
        assertEquals(StatusZapisu.OCZEKUJACY, zapis.getStatus(), "Status powinien pozostać OCZEKUJACY, ponieważ brakowało wolnych miejsc.");
    }

    @Test
    void odrzucZapis_PowinnaZmienicStatusNaOdrzucony() {
        // When
        zapis.odrzucZapis();

        // Then
        assertEquals(StatusZapisu.ODRZUCONY, zapis.getStatus(), "Status powinien zmienić się na ODRZUCONY.");
    }
}