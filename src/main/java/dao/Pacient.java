package dao;

import java.util.Date;

public class Pacient {
    public Pacient() {
        this(-1,"","");
    }

    private int id;
    private String ime;
    private String priimek;

    private String email;

    private String rojstniDatum;

    private String posebnosti;

    private Zdravnik osebniZdravnik;

    private boolean isZdravnik;



    public Pacient(int id, String ime, String priimek) {
        this.id = id;
        this.ime = ime;
        this.priimek = priimek;
    }

    public Pacient(int id, String ime, String priimek, String email, String rojstniDatum, String posebnosti) {
        this.id = id;
        this.ime = ime;
        this.priimek = priimek;
        this.email = email;
        this.rojstniDatum = rojstniDatum;
        this.posebnosti = posebnosti;
        this.isZdravnik = false;
    }

    public Pacient(int id, String ime, String priimek, String email, String rojstniDatum, String posebnosti, Zdravnik osebniZdravnik) {
        this.id = id;
        this.ime = ime;
        this.priimek = priimek;
        this.email = email;
        this.rojstniDatum = rojstniDatum;
        this.posebnosti = posebnosti;
        this.osebniZdravnik = osebniZdravnik;
        this.isZdravnik = false;
    }

    public Pacient(int id, String ime, String priimek, String email, String rojstniDatum, String posebnosti, Zdravnik osebniZdravnik, boolean isZdravnik) {
        this.id = id;
        this.ime = ime;
        this.priimek = priimek;
        this.email = email;
        this.rojstniDatum = rojstniDatum;
        this.posebnosti = posebnosti;
        this.osebniZdravnik = osebniZdravnik;
        this.isZdravnik = isZdravnik;
    }

    public boolean isZdravnik() {
        return isZdravnik;
    }


    public void setZdravnik(boolean zdravnik) {
        isZdravnik = zdravnik;
    }

    public Zdravnik getOsebniZdravnik() {
        return osebniZdravnik;
    }

    public void setOsebniZdravnik(Zdravnik osebniZdravnik) {
        this.osebniZdravnik = osebniZdravnik;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRojstniDatum() {
        return rojstniDatum;
    }

    public void setRojstniDatum(String rojstniDatum) {
        this.rojstniDatum = rojstniDatum;
    }

    public String getPosebnosti() {
        return posebnosti;
    }

    public void setPosebnosti(String posebnosti) {
        this.posebnosti = posebnosti;
    }

    public final String type = "Pacient";


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getType() {
        return type;
    }
}
