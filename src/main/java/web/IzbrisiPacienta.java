package web;

import dao.Pacient;
import dao.PacientDao;
import dao.PacientDaoH2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class IzbrisiPacienta implements IAkcija{
    public String dobiIme() {
        return "izbrisPacienta";
    }


    public String odzivJSP() {
        return "/Krmilnik?akcija=PregledVsehPacientov";
    }
    @Override
    public void izvediAkcijo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            PacientDao pacientDao = new PacientDaoH2();
            Pacient pacient = pacientDao.najdiPacienta(Integer.parseInt(req.getParameter("id")));
            pacientDao.izbrisi(pacient);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
