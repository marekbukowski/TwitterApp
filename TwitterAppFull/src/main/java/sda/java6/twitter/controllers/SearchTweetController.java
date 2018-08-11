package sda.java6.twitter.controllers;

import sda.java6.twitter.dto.TweetDto;
import sda.java6.twitter.exceptions.RequiredSearchParamsException;
import sda.java6.twitter.service.TwitterSearchService;
import sda.java6.twitter.service.TwitterSearchServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "searchTweetController", value = "/tweet/search")
public class SearchTweetController extends HttpServlet {

    private TwitterSearchService twitterSearchService = new TwitterSearchServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        String message = req.getParameter("message");
        String title = req.getParameter("title");

        if (keyword!=null && !"".equals(keyword) || message!=null && !"".equals(message)
                || title!=null && !"".equals(title)) {
            try {
                List<TweetDto> foundTweets =twitterSearchService.find(keyword, title, message);
                req.setAttribute("foundTweetsModel", foundTweets);
            } catch (RequiredSearchParamsException e) {
                req.setAttribute("errorMsg", "You haven't added required search params");
            }
        }

        RequestDispatcher rd = req.getRequestDispatcher("/tweets_jsp/searchTweet.jsp");
        rd.forward(req,resp);
    }
}
