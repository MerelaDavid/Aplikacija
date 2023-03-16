package dao;

import java.util.ArrayList;
import java.util.List;

public class Zdravnik {

    public Zdravnik() {
        this(-1,"","");
    }

    /**
     * Konstruktor
     * @param id zaèetni id
     * @param ime zaèetno ime
     * @param priimek zaèetni priimek
     */
    public Zdravnik(int id, String ime, String priimek) {
        this.id = id;
        this.ime = ime;
        this.priimek = priimek;
    }

    public Zdravnik(int id, String ime, String priimek, String email, int kvotaPacientov) {
        this.id = id;
        this.ime = ime;
        this.priimek = priimek;
        this.email = email;
        this.kvotaPacientov = kvotaPacientov;
    }

    public Zdravnik(int id, String ime, String priimek, String email, int kvotaPacientov,int stPacientov) {
        this.id = id;
        this.stPacientov = stPacientov;
        this.ime = ime;
        this.priimek = priimek;
        this.email = email;
        this.kvotaPacientov = kvotaPacientov;
    }

    private int id;

    private int stPacientov;

    private String ime;

    private String priimek;

    private String email;

    private int kvotaPacientov;

    private List<Pacient> izbraniPacienti = new ArrayList<Pacient>();

    public String getEmail() {
        return email;
    }

    public int getStPacientov() {
        return stPacientov;
    }

    public void setStPacientov(int stPacientov) {
        this.stPacientov = stPacientov;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getKvotaPacientov() {
        return kvotaPacientov;
    }

    public void setKvotaPacientov(int kvotaPacientov) {
        this.kvotaPacientov = kvotaPacientov;
    }

    public List<Pacient> getIzbraniPacienti() {
        return izbraniPacienti;
    }

    public void setIzbraniPacienti(List<Pacient> izbraniPacienti) {
        this.izbraniPacienti = izbraniPacienti;
    }

    public void addPacient(Pacient pacient){
        this.izbraniPacienti.add(pacient);
    }

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

    @Override
    public String toString() {
        return ime+" "+priimek+" (id:"+id+")";
    }

}
