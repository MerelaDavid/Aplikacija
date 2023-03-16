package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PacientDao {
    private static List<Pacient> pacienti = Collections.synchronizedList(new ArrayList<Pacient>());

    public void shrani(Pacient o) throws Exception {
        pacienti.add(o);
    }

    public void posodobi(Pacient pacient) throws Exception{
        for (Pacient zd : pacienti){
            if(zd.getId()== pacient.getId()){
                pacienti.remove(zd);
                pacienti.add(pacient);
            }
        }
    }
    public void izbrisi(Pacient pacient){
        pacienti.remove(pacient);
    }

    public Pacient najdiPacienta(int id) throws Exception {
        for (Pacient o: pacienti)
            if (o.getId()==id)
                return o;
        return null;
    }

    public void dodajZdravnika(Pacient pacient) throws Exception {
        for (Pacient o: pacienti)
            if (o.getId()==pacient.getId()){
                pacienti.remove(o);
                pacienti.add(pacient);
            }
    }

    public int najdiIdZdravnika(Pacient pacient) throws Exception{
        return pacient.getOsebniZdravnik().getId();
    }

    public List<Pacient> vrniVse() throws Exception {
        return pacienti;
    }
}
