package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import dao.*;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PregledZdravnika implements IAkcija {

    public String dobiIme() {
        return "pregledZdravnik";
    }

    public String odzivJSP() {
        return "zdravnik.jsp";
    }

    public void izvediAkcijo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            List<Pacient> zdravnikoviPacienti = new ArrayList<Pacient>();

            ZdravnikDao od=new ZdravnikDaoH2();
            PacientDao pacientDao = new PacientDaoH2();

            Zdravnik zdravnik=od.najdiOsebo(Integer.parseInt(req.getParameter("id")));

            for (Pacient pacient : pacientDao.vrniVse()){
                if (pacient.isZdravnik()){
                    if (pacient.getOsebniZdravnik().getId() == zdravnik.getId()){
                        zdravnikoviPacienti.add(pacient);
                    }
                }
            }
            req.setAttribute("pacienti",zdravnikoviPacienti);
            req.setAttribute("prostaMesta",zdravnik.getKvotaPacientov()-zdravnik.getStPacientov());
            req.setAttribute("oseba",zdravnik);
            req.setAttribute("sporocilo","");
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }

}
