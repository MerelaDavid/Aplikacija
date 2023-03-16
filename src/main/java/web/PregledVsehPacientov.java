package web;

import dao.Pacient;
import dao.PacientDao;
import dao.PacientDaoH2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * akcija vse
 * v odziv vstavi objekt "List<Oseba>" pod imenom osebe
 */


public class PregledVsehPacientov implements IAkcija {
    public String dobiIme() {
        return "PregledVsehPacientov";
    }


    public String odzivJSP() {
        return "pacienti.jsp";
    }

    public void izvediAkcijo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            List<Pacient> pacientiZZdravnikom = new ArrayList<Pacient>();
            List<Pacient> pacientiBrezZdravnika = new ArrayList<Pacient>();

            PacientDao od=new PacientDaoH2();
            req.setAttribute("pacienti",od.vrniVse());

            for (Pacient pacient: od.vrniVse()){
                if (pacient.isZdravnik()){
                    System.out.println("DODAN  :"+pacient.getOsebniZdravnik().getIme());
                    pacientiZZdravnikom.add(pacient);
                }
                else {
                    pacientiBrezZdravnika.add(pacient);
                }
            }
            req.setAttribute("pacientiZZdravnikom",pacientiZZdravnikom);
            req.setAttribute("pacientiBrezZdravnika",pacientiBrezZdravnika);

        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}
