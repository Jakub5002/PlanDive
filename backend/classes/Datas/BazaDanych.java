package Datas;

import java.util.HashMap;
import java.util.Map;


public class BazaDanych {

    private final Map<Long, Object> encje = new HashMap<>();
    
    public void zapisz(Long id, Object entity) {
        encje.put(id, entity);
    }

    public Object pobierz(Long id) {
        return encje.get(id);
    }

    public void aktualizuj(Long id, Object entity) {
        encje.put(id, entity);
    }

    public void usun(Long id) {
        encje.remove(id);
    }
}