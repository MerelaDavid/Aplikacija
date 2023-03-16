package web;

import java.io.IOException;


import dao.ZdravnikDaoH2;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.ZdravnikDao;

/**
 * akcija vse
 * v odziv vstavi objekt "List<Oseba>" pod imenom osebe
 */
public class PregledVsehZdravnikov implements IAkcija {


    public String dobiIme() {
        return "PregledVsehZdravnikov";
    }


    public String odzivJSP() {
        return "zdravniki.jsp";
    }

    public void izvediAkcijo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            ZdravnikDao od=new ZdravnikDaoH2();
            req.setAttribute("osebe",od.vrniVse());
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }

}
