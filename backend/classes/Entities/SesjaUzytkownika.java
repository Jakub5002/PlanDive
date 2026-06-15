package Entities;

import java.time.LocalDateTime;

public class SesjaUzytkownika {
    private String token;
    private Long userId;
    private LocalDateTime dataUtworzenia;
    private LocalDateTime dataWygasniecia;

    public SesjaUzytkownika() {}

    public SesjaUzytkownika(String token, Long userId, LocalDateTime dataUtworzenia, LocalDateTime dataWygasniecia) {
        this.token = token;
        this.userId = userId;
        this.dataUtworzenia = dataUtworzenia;
        this.dataWygasniecia = dataWygasniecia;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public LocalDateTime getDataUtworzenia() { return dataUtworzenia; }
    public void setDataUtworzenia(LocalDateTime dataUtworzenia) { this.dataUtworzenia = dataUtworzenia; }
    public LocalDateTime getDataWygasniecia() { return dataWygasniecia; }
    public void setDataWygasniecia(LocalDateTime dataWygasniecia) { this.dataWygasniecia = dataWygasniecia; }

    public boolean czyWazna() {
        if (this.dataWygasniecia == null) {
            return false;
        }
        return LocalDateTime.now().isBefore(this.dataWygasniecia);
    }
}