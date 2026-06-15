package DatasTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Datas.*;
import Entities.*;
import static org.junit.jupiter.api.Assertions.*;

class BazaUzytkownikowTest {

    private BazaUzytkownikow baza;

    @BeforeEach
    void setUp() {

        baza = new BazaUzytkownikow();

        Uzytkownik uzytkownik =
                new Kursant();

        uzytkownik.setId(1L);
        uzytkownik.setLogin("jan");
        uzytkownik.setHaslo("1234");

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

}