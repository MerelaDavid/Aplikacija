package web;


import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DodajZdravnika implements IAkcija{
    public String dobiIme() {
        return "dodajZDPacientu";
    }


    public String odzivJSP() {
        return "Krmilnik?akcija=PregledVsehPacientov";
    }

    @Override
    public void izvediAkcijo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            PacientDao pacientDao = new PacientDaoH2();
            ZdravnikDao zdravnikDao = new ZdravnikDaoH2();
            int pacientId = Integer.parseInt(req.getParameter("pacientId"));
            int zdravnikId = Integer.parseInt(req.getParameter("id"));


            System.out.println("PACIENT ID: "+pacientId);
            System.out.println("ZDRAVNIK ID: "+zdravnikId);

            Zdravnik zdravnik = zdravnikDao.najdiOsebo(zdravnikId);
            Pacient pacient = pacientDao.najdiPacienta(pacientId);
            pacient.setOsebniZdravnik(zdravnik);
            pacient.setZdravnik(true);

            System.out.println("ZDRAVNIK DODAN :"+ pacient.getOsebniZdravnik().getIme());

            zdravnik.setStPacientov(zdravnik.getStPacientov()+1);
            zdravnikDao.posodobi(zdravnik);

            pacientDao.dodajZdravnika(pacient);

            Pacient posodobljeniPacient = pacientDao.najdiPacienta(pacientId);

            System.out.println("POSODOBLJENI PACIENT: "+ posodobljeniPacient.getId());

            System.out.println("ZDRAVNIK PACIENTA :" + posodobljeniPacient.getOsebniZdravnik().getIme()+" "+posodobljeniPacient.getOsebniZdravnik().getPriimek()+" "+ posodobljeniPacient.getOsebniZdravnik().getId());

        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }

    }

}
