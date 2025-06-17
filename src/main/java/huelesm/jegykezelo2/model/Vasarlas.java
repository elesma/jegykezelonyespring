package huelesm.jegykezelo2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vasarlas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rendezveny;
    private String vasarlasdatum;
    private int vasarlo;

    public Long getId() { return id; }

    public String getRendezvenyNev() {
        return rendezveny;
    }

    public void setRendezvenyNev(String rendezveny) {
        this.rendezveny = rendezveny;
    }

    public String getVasarlasdatum() {
        return vasarlasdatum;
    }

    public void setVasarlasdatum(String vasarlasdatum) {
        this.vasarlasdatum = vasarlasdatum;
    }

    public int getVasarlo() {
        return vasarlo;
    }

    public void setVasarlo(int vasarlo) {
        this.vasarlo = vasarlo;
    }
}