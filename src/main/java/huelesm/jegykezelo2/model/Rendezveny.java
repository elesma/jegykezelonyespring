package huelesm.jegykezelo2.model;

import jakarta.persistence.*;

@Entity
public class Rendezveny {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cim;
    private String datum;
    private int ertekeles;
    private int ar;
    private String link;

    public Long getId() { return id; }
    public String getCim() { return cim; }
    public void setCim(String cim) { this.cim = cim; }
    public String getDatum() { return datum; }
    public void setDatum(String datum) { this.datum = datum; }
    public int getErtekeles() { return ertekeles; }
    public void setErtekeles(int ertekeles) { this.ertekeles = ertekeles; }
    public int getAr() { return ar; }
    public void setAr(int ar) { this.ar = ar; }
    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
}