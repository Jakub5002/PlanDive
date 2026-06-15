import java.util.ArrayList;
import java.util.List;

public class BazaUzytkownikow {

    private final List<Uzytkownik> uzytkownicy = new ArrayList<>();

    public Uzytkownik znajdzUzytkownika(String login, String haslo) {

        return uzytkownicy.stream().filter(u -> u.getLogin().equals(login) && u.getHaslo().equals(haslo)).findFirst().orElse(null);
    }

    public boolean sprawdzDaneLogowania(String login, String haslo) {
        return znajdzUzytkownika(login, haslo) != null;
    }

    public PreferencjePowiadomien pobierzPreferencje(Long userId) {

        return uzytkownicy.stream().filter(u -> u.getId().equals(userId)).findFirst().map(Uzytkownik::getPreferencjePowiadomien).orElse(null);
    }

    public void dodajUzytkownika(Uzytkownik uzytkownik) {
        uzytkownicy.add(uzytkownik);
    }
}