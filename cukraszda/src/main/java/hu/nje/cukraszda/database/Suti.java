package hu.nje.cukraszda.database;

import jakarta.persistence.*;

@Entity
@Table(name = "suti")
public class Suti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nev;
    private String tipus;
    private boolean dijazott;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Tartalom tartalom;

    public Tartalom getTartalom() {
        return tartalom;
    }

    public void setTartalom(Tartalom tartalom) {
        this.tartalom = tartalom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String name) {
        this.nev = name;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public boolean getDijazott() {
        return dijazott;
    }

    public void setDijazott(boolean dijazott) {
        this.dijazott = dijazott;
    }
}
