package sda.java6.twitter.controllers;

import sda.java6.twitter.dto.TweetDto;
import sda.java6.twitter.exceptions.TweetNotFoundException;
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

@WebServlet(name = "singleTweetController", value = "/tweet")
public class SingleTweetController extends HttpServlet {

    private TwitterService twitterService = new TwitterDatabaseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String tweetIdString = req.getParameter("tweetId");
        int tweetId = 0;
        try {
            tweetId = Integer.valueOf(tweetIdString);
            TweetDto tweetDto = twitterService.findById(tweetId);
            req.setAttribute("tweet", tweetDto);
            req.setAttribute("activeTab", "tweetAdd");
        } catch (TweetNotFoundException ex) {
            req.setAttribute("errorMsg", "Tweet with id"+tweetId+ "was not found in database");
        } catch (NumberFormatException e) {
            req.setAttribute("errorMsg", "It is not valid tweet id: "+tweetIdString);
        } finally {
            RequestDispatcher rd =req.getRequestDispatcher("/tweets_jstl/tweet.jsp");
            rd.forward(req, resp);

        }

    }
}
