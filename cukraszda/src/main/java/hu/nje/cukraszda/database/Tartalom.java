package hu.nje.cukraszda.database;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tartalom")
public class Tartalom {
    @Id
    private int id;
    private int sutiid;
    private String mentes;

    @OneToOne(mappedBy = "tartalom")
    private Suti suti;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSutiid() {
        return sutiid;
    }

    public void setSutiid(int sutiid) {
        this.sutiid = sutiid;
    }

    public String getMentes() {
        return mentes;
    }

    public void setMentes(String mentes) {
        this.mentes = mentes;
    }

    public Suti getSuti() {
        return suti;
    }

    public void setSuti(Suti suti) {
        this.suti = suti;
    }
}
