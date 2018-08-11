package sda.java6.twitter.controllers;

import sda.java6.twitter.service.LoginService;
import sda.java6.twitter.service.LoginServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginController", value = "/login")
public class LoginController extends HttpServlet {

    private LoginService loginService = new LoginServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/user/login.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean logged = loginService.login(email,password);
        if (logged) {
            HttpSession session =req.getSession();
            session.setAttribute("email", email);
            resp.sendRedirect("/tweets");
        } else {

        }
    }
}
