import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.agh.edu.fis.PojedynekRobotow.model.PreferencjePowiadomien;
import pl.agh.edu.fis.PojedynekRobotow.model.Uzytkownik;

import static org.junit.jupiter.api.Assertions.*;

class BazaUzytkownikowTest {

    private BazaUzytkownikow baza;

    @BeforeEach
    void setUp() {

        baza = new BazaUzytkownikow();

        PreferencjePowiadomien pref =
                new PreferencjePowiadomien();

        Uzytkownik uzytkownik =
                new Uzytkownik();

        uzytkownik.setId(1L);
        uzytkownik.setLogin("jan");
        uzytkownik.setHaslo("1234");
        uzytkownik.setPreferencjePowiadomien(pref);

        baza.dodajUzytkownika(uzytkownik);
    }

    @Test
    void powinienZnalezcUzytkownikaPoLoginieIHasle() {

        Uzytkownik wynik =
                baza.znajdzUzytkownika(
                        "jan",
                        "1234"
                );

        assertNotNull(wynik);
        assertEquals("jan", wynik.getLogin());
    }

    @Test
    void powinienZwrocicNullDlaBlednychDanych() {

        Uzytkownik wynik =
                baza.znajdzUzytkownika(
                        "jan",
                        "zleHaslo"
                );

        assertNull(wynik);
    }

    @Test
    void powinienPotwierdzicPoprawneLogowanie() {

        assertTrue(
                baza.sprawdzDaneLogowania(
                        "jan",
                        "1234"
                )
        );
    }

    @Test
    void powinienOdrzucicNiepoprawneLogowanie() {

        assertFalse(
                baza.sprawdzDaneLogowania(
                        "jan",
                        "xxxx"
                )
        );
    }

    @Test
    void powinienPobracPreferencjePowiadomien() {

        PreferencjePowiadomien wynik =
                baza.pobierzPreferencje(1L);

        assertNotNull(wynik);
    }

    @Test
    void dlaNieistniejacegoUzytkownikaPowinienZwrocicNull() {

        assertNull(
                baza.pobierzPreferencje(999L)
        );
    }
}