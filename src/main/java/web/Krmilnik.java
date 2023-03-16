package web;

import java.io.IOException;
import java.util.Vector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/Krmilnik")
public class Krmilnik extends HttpServlet {

    private static final long serialVersionUID = 149363537429656487L;

    private Vector<IAkcija> akcije=null;
    private Vector<IAkcija> akcijePacienti =null;


    public void init() throws ServletException {
        akcije=new Vector<IAkcija>();
        akcije.add(new PregledZdravnika());
        akcije.add(new PregledVsehZdravnikov());
        akcije.add(new vnosZdravnika());
        akcije.add(new PosodobiZdravnika());
        akcije.add(new ShraniPosZdr());
        akcije.add(new IzbrisiZdravnika());

        akcijePacienti= new Vector<IAkcija>();
        akcijePacienti.add(new PregledPacienta());
        akcijePacienti.add(new PregledVsehPacientov());
        akcijePacienti.add(new vnosPacient());
        akcijePacienti.add(new PosodobiPacienta());
        akcijePacienti.add(new ShraniPosPac());
        akcijePacienti.add(new IzbrisiPacienta());
        akcijePacienti.add(new DodajZdravnika());
    }
    
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        IAkcija uporabi=null;
        if (req.getParameter("akcija").toLowerCase().contains("zdravnik")){
            for (IAkcija a : akcije) {
                if (a.dobiIme().equals(req.getParameter("akcija"))) {
                    uporabi = a;
                    System.out.println("AKCIJA  "+req.getParameter("akcija"));
                }
            }
        }
        if(req.getParameter("akcija").toLowerCase().contains("pacient")) {
            for (IAkcija a : akcijePacienti) {
                if (a.dobiIme().equals(req.getParameter("akcija"))) {
                    uporabi = a;
                    System.out.println("AKCIJA  "+req.getParameter("akcija"));
                }
            }
        }

        if (uporabi==null) throw new ServletException("Akcije ni bilo mogoce najti");
        uporabi.izvediAkcijo(req,res);
        req.getRequestDispatcher(uporabi.odzivJSP()).include(req,res);
    }
}
