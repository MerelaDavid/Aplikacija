package web;

import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * akcija pregled
 * parameter id
 * v odziv vstavi objekt "Oseba" pod imenom oseba
 * ter sporocilo (prazen niz)
 */

public class PregledPacienta implements IAkcija{
    public String dobiIme() {
        return "pregledPacient";
    }

    public String odzivJSP() {
        return "pacient.jsp";
    }

    public void izvediAkcijo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            PacientDao pacientDao = new PacientDaoH2();

            Pacient pacient = pacientDao.najdiPacienta(Integer.parseInt(req.getParameter("id")));
            Zdravnik zdravnik = pacient.getOsebniZdravnik();


            System.out.println("PREGLED: "+pacient.getId());

            req.setAttribute("pacient",pacient);
            req.setAttribute("zdravnik",zdravnik);

        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}
