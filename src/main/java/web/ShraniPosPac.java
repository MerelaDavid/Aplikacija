package web;

import dao.Pacient;
import dao.PacientDao;
import dao.PacientDaoH2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ShraniPosPac implements IAkcija{
    public String dobiIme() {
        return "shraniPosPacienta";
    }


    public String odzivJSP() {
        return "pacient.jsp";
    }

    public void izvediAkcijo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            PacientDao od=new PacientDaoH2();
            Pacient vstavljena=new Pacient(Integer.parseInt(req.getParameter("id")),req.getParameter("ime"),req.getParameter("priimek"),req.getParameter("email"),req.getParameter("rojstniDatum"),req.getParameter("posebnosti"));
            od.posodobi(vstavljena);
            req.setAttribute("pacient",vstavljena);
            req.setAttribute("sporocilo","Pacient je bil uspesno dodan.");
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}
