package sda.java6.twitter.controllers;

import sda.java6.twitter.service.TwitterService;
import sda.java6.twitter.service.TwitterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteController", value = "/deleteTweet")
public class DeleteController extends HttpServlet {

    private TwitterService twitterService = new TwitterServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tweetId = req.getParameter("tweetId");
        int id = 0;
        try {
            id = Integer.valueOf(tweetId);
        } catch (NumberFormatException e) {

        }
        twitterService.delete(id);
        resp.sendRedirect("/message?messageInfo=Tweet with id="+id+" " +
                "was deleted");
    }
}
