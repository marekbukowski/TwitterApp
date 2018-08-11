package sda.java6.twitter.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "languageController", value = "/language")
public class LanguageController extends HttpServlet {

    private static int HOURS = 24;

    private static int MINUTES = 60;

    private static int SECONDS = 60;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lang=req.getParameter("lang");
        Cookie cookie = new Cookie("lang", lang);
        cookie.setMaxAge(HOURS*MINUTES*SECONDS);
        resp.addCookie(cookie);
        resp.sendRedirect("/tweets");

     /*   for (Cookie cookie1 : req.getCookies()) {
            if (cookie1.getName().equals("lang")) {
                cookie1.getValue();
            }
        }*/
    }
}
