package web;

import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class vnosPacient implements IAkcija {
    public String dobiIme() {
        return "vnosPacient";
    }


    public String odzivJSP() {
        return "pacient.jsp";
    }

    public void izvediAkcijo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            PacientDao od=new PacientDaoH2();
            Pacient vstavljena=new Pacient(0,req.getParameter("ime"),req.getParameter("priimek"),req.getParameter("email"),req.getParameter("rojstniDatum"),req.getParameter("posebnosti"));
            od.shrani(vstavljena);
            req.setAttribute("pacient",vstavljena);
            req.setAttribute("sporocilo","Pacient je bil uspesno dodan.");
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}
