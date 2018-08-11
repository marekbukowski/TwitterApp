package sda.java6.twitter.controllers;

import sda.java6.twitter.dto.TweetDto;
import sda.java6.twitter.service.TwitterDatabaseServiceImpl;
import sda.java6.twitter.service.TwitterService;
import sda.java6.twitter.service.TwitterServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="twitterListController", value = "/tweets")
public class TwitterListController extends HttpServlet {

    private TwitterService twitterService = new TwitterDatabaseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TweetDto> tweets = twitterService.findAll();
        req.setAttribute("tweetsModel", tweets);
        req.setAttribute("tweetsSize", tweets.size());
        RequestDispatcher rd =
                req.getRequestDispatcher("/tweets_jstl/tweets.jsp");
        rd.forward(req, resp);
    }
}
