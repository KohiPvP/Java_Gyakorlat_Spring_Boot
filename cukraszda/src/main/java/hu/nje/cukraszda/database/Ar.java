package hu.nje.cukraszda.database;

import jakarta.persistence.*;

@Entity
@Table(name = "ar")
public class Ar {
    @Id
    private int id;
    private int ertek;
    private String egyseg;

    @ManyToOne
    @JoinColumn(name = "sutiid")
    private Suti suti;

    public Suti getSuti() {
        return suti;
    }

    public void setSuti(Suti suti) {
        this.suti = suti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getErtek() {
        return ertek;
    }

    public void setErtek(int ertek) {
        this.ertek = ertek;
    }

    public String getEgyseg() {
        return egyseg;
    }

    public void setEgyseg(String egyseg) {
        this.egyseg = egyseg;
    }
}
