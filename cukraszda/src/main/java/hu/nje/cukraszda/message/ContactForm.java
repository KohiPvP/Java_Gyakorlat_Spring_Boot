package hu.nje.cukraszda.message;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContactForm {

    @NotBlank(message = "A név megadása kötelező.")
    @Size(max = 100, message = "A név legfeljebb 100 karakter lehet.")
    private String nev;

    @NotBlank(message = "Az e-mail cím megadása kötelező.")
    @Email(message = "Érvényes e-mail címet adjon meg.")
    @Size(max = 150, message = "Az e-mail legfeljebb 150 karakter lehet.")
    private String email;

    @NotBlank(message = "A tárgy megadása kötelező.")
    @Size(max = 150, message = "A tárgy legfeljebb 150 karakter lehet.")
    private String targy;

    @NotBlank(message = "Az üzenet megadása kötelező.")
    @Size(max = 2000, message = "Az üzenet legfeljebb 2000 karakter lehet.")
    private String uzenet;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTargy() {
        return targy;
    }

    public void setTargy(String targy) {
        this.targy = targy;
    }

    public String getUzenet() {
        return uzenet;
    }

    public void setUzenet(String uzenet) {
        this.uzenet = uzenet;
    }
}