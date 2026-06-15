package Entities;

public class Administrator extends Uzytkownik {

    public Administrator() {
        super();
    }
    public Administrator(Long id, String email, String login, String haslo, String imie, String nazwisko, String rola, UstawieniaAplikacji ustawienia, SesjaUzytkownika sesja) {
        super(id, email, login, haslo, imie, nazwisko, rola, ustawienia, sesja);
    }
}