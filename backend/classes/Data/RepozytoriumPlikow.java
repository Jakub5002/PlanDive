import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class RepozytoriumPlikow {

    private final Map<Long, String> pliki = new HashMap<>();

    public void zapiszPlik(Long id, String sciezka) {
        pliki.put(id, sciezka);
    }

    public String pobierzSciezke(Long id) {
        return pliki.get(id);
    }
}