package hu.nje.cukraszda.message;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nev;

    @Column(name = "email")
    private String email;

    @Column(name = "subject")
    private String targy;

    @Column(name = "message", columnDefinition = "TEXT")
    private String uzenet;

    @Column(name = "letrehozva")
    private LocalDateTime letrehozva;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getLetrehozva() {
        return letrehozva;
    }

    public void setLetrehozva(LocalDateTime letrehozva) {
        this.letrehozva = letrehozva;
    }
}