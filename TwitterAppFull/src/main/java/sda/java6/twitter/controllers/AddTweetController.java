package sda.java6.twitter.controllers;

import sda.java6.twitter.dto.TweetDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addTweetController", value="/addTweet")
public class AddTweetController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TweetDto tweetDto = new TweetDto();
        req.setAttribute("tweet", tweetDto);
        RequestDispatcher rd =req.getRequestDispatcher("/tweets_jstl/tweet.jsp");
        rd.forward(req, resp);
    }
}
