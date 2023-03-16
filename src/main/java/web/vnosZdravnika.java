package web;

import java.io.IOException;

import dao.Zdravnik;
import dao.ZdravnikDaoH2;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.ZdravnikDao;

public class vnosZdravnika implements IAkcija {


    public String dobiIme() {
        return "vnosZdravnik";
    }


    public String odzivJSP() {
        return "zdravnik.jsp";
    }

    public void izvediAkcijo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            ZdravnikDao od=new ZdravnikDaoH2();
            Zdravnik vstavljena=new Zdravnik(0,req.getParameter("ime"),req.getParameter("priimek"),req.getParameter("email"),Integer.parseInt(req.getParameter("kvotaPacientov")),0);
            od.shrani(vstavljena);
            req.setAttribute("oseba",vstavljena);
            req.setAttribute("sporocilo","Oseba je bila uspesno dodana.");
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }

}
