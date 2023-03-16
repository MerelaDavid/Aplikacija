package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Dummy DB
 */
public class ZdravnikDao {

    private static List<Zdravnik> zdravniki =Collections.synchronizedList(new ArrayList<Zdravnik>());

    public void shrani(Zdravnik o) throws Exception {
        zdravniki.add(o);
    }

    public void posodobi(Zdravnik zdravnik) throws Exception{
        for (Zdravnik zd : zdravniki){
            if(zd.getId()== zdravnik.getId()){
                zdravniki.remove(zd);
                zdravniki.add(zdravnik);
            }
        }
    }

    public void izbrisi(Zdravnik zdravnik){
        zdravniki.remove(zdravnik);
    }

    public Zdravnik najdiOsebo(int id) throws Exception {
        for (Zdravnik o: zdravniki)
            if (o.getId()==id)
                return o;
        return null;
    }

    public List<Zdravnik> vrniVse() throws Exception {
        return zdravniki;
    }

}
