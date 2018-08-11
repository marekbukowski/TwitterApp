package sda.java6.twitter.controllers;

import sda.java6.twitter.dto.TweetDto;
import sda.java6.twitter.service.TwitterService;
import sda.java6.twitter.service.TwitterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebEndpoint;
import java.io.IOException;

@WebServlet(name = "saveTweetController", value = "/saveTweet")
public class SaveTweetController extends HttpServlet {

    private TwitterService twitterService = new TwitterServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tweetTitle = req.getParameter("title");
        String tweetMessage = req.getParameter("message");
        String tweetId = req.getParameter("id");
        try {
            int id = 0;
            if (tweetId!=null&& !tweetId.equals("")) {
                id = Integer.valueOf(tweetId);
            }
            TweetDto tweetDto = new TweetDto(id, tweetTitle, tweetMessage, 0);
            twitterService.save(tweetDto);
            resp.sendRedirect("/message?messageInfo=Tweet was saved");
        } catch (NumberFormatException ex) {

        }

    }
}
