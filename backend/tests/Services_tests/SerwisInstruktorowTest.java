package Services_tests;
import Services.*;

import org.junit.Test;
import static org.junit.Assert.*;


public class SerwisInstruktorowTest {
    @Test
    public void testPobieranieKwalifikacji(){
        SerwisInstuktorow serwis = new SerwisInstuktorow();
        assertEquals("Kwalifikacje", serwis.pobierzKwalifikacje(1));
    }
}
