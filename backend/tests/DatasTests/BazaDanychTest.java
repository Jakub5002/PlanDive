import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BazaDanychTest {

    @Test
    void powinienZapisacIPobracEncje() {

        BazaDanych baza = new BazaDanych();

        String kurs = "Kurs A";

        baza.zapisz(1L, kurs);

        Object wynik = baza.pobierz(1L);

        assertEquals(kurs, wynik);
    }

    @Test
    void powinienZaktualizowacEncje() {

        BazaDanych baza = new BazaDanych();

        baza.zapisz(1L, "Stara");

        baza.aktualizuj(1L, "Nowa");

        assertEquals("Nowa", baza.pobierz(1L));
    }

    @Test
    void powinienUsunacEncje() {

        BazaDanych baza = new BazaDanych();

        baza.zapisz(1L, "Test");

        baza.usun(1L);

        assertNull(baza.pobierz(1L));
    }

    @Test
    void pobranieNieistniejacejEncjiPowinnoZwrocicNull() {

        BazaDanych baza = new BazaDanych();

        assertNull(baza.pobierz(999L));
    }
}