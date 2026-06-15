package Entities;

public abstract class Uzytkownik {
    private Long id;
    private String email;
    private String login;
    private String haslo;
    private String imie;
    private String nazwisko;
    private String rola;
    private UstawieniaAplikacji ustawienia;
    private SesjaUzytkownika sesja;

    public Uzytkownik() {}

    public Uzytkownik(Long id, String email, String login, String haslo, String imie, String nazwisko, String rola, UstawieniaAplikacji ustawienia, SesjaUzytkownika sesja) {
        this.id = id;
        this.email = email;
        this.login = login;
        this.haslo = haslo;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rola = rola;
        this.ustawienia = ustawienia;
        this.sesja = sesja;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getHaslo() { return haslo; }
    public void setHaslo(String haslo) { this.haslo = haslo; }
    public String getImie() { return imie; }
    public void setImie(String imie) { this.imie = imie; }
    public String getNazwisko() { return nazwisko; }
    public void setNazwisko(String nazwisko) { this.nazwisko = nazwisko; }
    public String getRola() { return rola; }
    public void setRola(String rola) { this.rola = rola; }
    public UstawieniaAplikacji getUstawienia() { return ustawienia; }
    public void setUstawienia(UstawieniaAplikacji ustawienia) { this.ustawienia = ustawienia; }
    public SesjaUzytkownika getSesja() { return sesja; }
    public void setSesja(SesjaUzytkownika sesja) { this.sesja = sesja; }
}