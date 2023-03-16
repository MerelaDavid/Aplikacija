package web;

import dao.Zdravnik;
import dao.ZdravnikDao;
import dao.ZdravnikDaoH2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class IzbrisiZdravnika implements IAkcija{
    public String dobiIme() {
        return "izbrisZdravnika";
    }


    public String odzivJSP() {
        return "/Krmilnik?akcija=PregledVsehZdravnikov";
    }

    @Override
    public void izvediAkcijo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            ZdravnikDao zdravnikDao = new ZdravnikDaoH2();
            Zdravnik zdravnik = zdravnikDao.najdiOsebo(Integer.parseInt(req.getParameter("id")));
            zdravnikDao.izbrisi(zdravnik);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
