package web;

import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class PosodobiZdravnika implements IAkcija{

    public String dobiIme() {
        return "PosodobiZdravnika";
    }


    public String odzivJSP() {
        return "posodobi_zdravnika_forma.jsp";
    }

    public void izvediAkcijo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            ZdravnikDao od=new ZdravnikDaoH2();
            Zdravnik najdena=od.najdiOsebo(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("zdravnik",najdena);

        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}
