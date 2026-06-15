public class Instruktor extends Uzytkownik {
    private String legitymacja;
    private String uprawnieniaEgzaminatora;

    public Instruktor() {}

    public Instruktor(String legitymacja, String uprawnieniaEgzaminatora) {
        this.legitymacja = legitymacja;
        this.uprawnieniaEgzaminatora = uprawnieniaEgzaminatora;
    }

    public String getLegitymacja() { return legitymacja; }
    public void setLegitymacja(String legitymacja) { this.legitymacja = legitymacja; }
    public String getUprawnieniaEgzaminatora() { return uprawnieniaEgzaminatora; }
    public void setUprawnieniaEgzaminatora(String uprawnieniaEgzaminatora) { this.uprawnieniaEgzaminatora = uprawnieniaEgzaminatora; }
}