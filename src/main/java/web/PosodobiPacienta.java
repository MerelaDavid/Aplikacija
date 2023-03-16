package web;

import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PosodobiPacienta implements IAkcija{
    public String dobiIme() {
        return "PosodobiPacienta";
    }


    public String odzivJSP() {
        return "posodobi_pacienta_forma.jsp";
    }

    public void izvediAkcijo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            PacientDao od=new PacientDaoH2();
            Pacient najdena=od.najdiPacienta(Integer.parseInt(req.getParameter("id")));
            List<Zdravnik> prostiZdravniki = new ArrayList<Zdravnik>();
            ZdravnikDao zdravnikDao =new ZdravnikDaoH2();
            for (Zdravnik zd : zdravnikDao.vrniVse()){
                if (zd.getKvotaPacientov() - zd.getStPacientov() > 0){
                    prostiZdravniki.add(zd);
                }
            }
            req.setAttribute("zdravniki",prostiZdravniki);
            req.setAttribute("pacient",najdena);

        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}
