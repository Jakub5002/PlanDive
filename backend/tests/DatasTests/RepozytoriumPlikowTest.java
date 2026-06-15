package DatasTests;

import org.junit.jupiter.api.Test;
import Datas.*;
import static org.junit.jupiter.api.Assertions.*;

class RepozytoriumPlikowTest {

    @Test
    void powinienZapisacSciezkePliku() {

        RepozytoriumPlikow repozytorium = new RepozytoriumPlikow();

        repozytorium.zapiszPlik(
                1L,
                "C:/pliki/badanie.pdf"
        );

        String wynik = repozytorium.pobierzSciezke(1L);

        assertEquals(
                "C:/pliki/badanie.pdf",
                wynik
        );
    }

    @Test
    void pobranieNieistniejacegoPlikuPowinnoZwrocicNull() {

        RepozytoriumPlikow repozytorium =
                new RepozytoriumPlikow();

        assertNull(
                repozytorium.pobierzSciezke(100L)
        );
    }

    @Test
    void zapisPonownyPowinienNadpisacSciezke() {

        RepozytoriumPlikow repozytorium =
                new RepozytoriumPlikow();

        repozytorium.zapiszPlik(
                1L,
                "stara.pdf"
        );

        repozytorium.zapiszPlik(
                1L,
                "nowa.pdf"
        );

        assertEquals(
                "nowa.pdf",
                repozytorium.pobierzSciezke(1L)
        );
    }
}