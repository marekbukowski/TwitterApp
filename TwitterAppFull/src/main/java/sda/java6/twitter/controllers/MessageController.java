package sda.java6.twitter.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "messageController", value = "/message")
public class MessageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String messageInfo = req.getParameter("messageInfo");
        // validate
        req.setAttribute("message", messageInfo);
        RequestDispatcher rd = req.getRequestDispatcher("/tweets_jsp/message.jsp");
        rd.forward(req, resp);
    }
}
