package web;

import dao.Zdravnik;
import dao.ZdravnikDao;
import dao.ZdravnikDaoH2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ShraniPosZdr implements IAkcija{
    public String dobiIme() {
        return "shraniPosZdravnika";
    }


    public String odzivJSP() {
        return "zdravnik.jsp";
    }

    public void izvediAkcijo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            ZdravnikDao od=new ZdravnikDaoH2();
            Zdravnik vstavljena=new Zdravnik(Integer.parseInt(req.getParameter("id")),req.getParameter("ime"),req.getParameter("priimek"),req.getParameter("email"),Integer.parseInt(req.getParameter("kvotaPacientov")));
            od.posodobi(vstavljena);
            req.setAttribute("oseba",vstavljena);
            req.setAttribute("sporocilo","Oseba je bila uspesno dodana.");
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}
