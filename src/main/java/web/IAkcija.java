package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface IAkcija {

    void izvediAkcijo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;

    String dobiIme();

    String odzivJSP();

}
