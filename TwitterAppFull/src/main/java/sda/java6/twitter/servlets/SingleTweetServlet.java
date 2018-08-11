package sda.java6.twitter.servlets;

import sda.java6.twitter.dto.TweetDto;
import sda.java6.twitter.exceptions.TweetNotFoundException;
import sda.java6.twitter.service.TwitterService;
import sda.java6.twitter.service.TwitterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "singleTweetServlet", value = "/tweetServlet")
public class SingleTweetServlet extends HttpServlet {

    private TwitterService twitterService = new TwitterServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String tweetIdString = req.getParameter("tweetId");
        PrintWriter writer = resp.getWriter();
        int tweetId = 0;
        try {
            tweetId = Integer.valueOf(tweetIdString);
            TweetDto tweetDto = twitterService.findById(tweetId);
            writer.print("<HTML>");
            writer.print("<HEAD>");
            writer.print("<TITLE>Tweet Page</TITLE>");
            writer.print("</HEAD>");
            writer.print("<BODY>");
            writer.print("<H1>Tweet Page</H1>");
            writer.print("<FORM method=\"POST\" action=\"\">");
            writer.print("<input id=\"tweetId\" name=\"id\" type=\"TEXT\" value=\""+tweetDto.getId()+"\"/>\n");
            writer.print("<input name=\"title\" type=\"TEXT\" value=\""+tweetDto.getTitle()+"\"/>\n");
            writer.print("<input name=\"message\" type=\"TEXT\" value=\""+tweetDto.getMessage()+"\"/>\n");
            writer.print("<input name=\"userId\" type=\"HIDDEN\" value=\""+tweetDto.getUserId()+"\" />\n");
            writer.print("<input type=\"submit\" value=\"Add Tweet\"/>");
            writer.print("</FORM>");
            writer.print("</BODY>");
            writer.print("</HTML>");

        } catch (NumberFormatException e) {

        } catch (TweetNotFoundException ex) {

        }
    }
}
