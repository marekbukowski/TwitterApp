package sda.java6.twitter.servlets;

import sda.java6.twitter.dto.TweetDto;
import sda.java6.twitter.service.TwitterService;
import sda.java6.twitter.service.TwitterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "twitterListServlet", value = "/tweetsServlet")
public class TwitterListServlet extends HttpServlet {

    private TwitterService twitterService = new TwitterServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<TweetDto> tweets = twitterService.findAll();
        PrintWriter writer = resp.getWriter();
        writer.print("<HTML>");
        writer.print("<HEAD>");
        writer.print("<TITLE>Twitter List Servlet</TITLE>");
        writer.print("</HEAD>");
        writer.print("<BODY>");
        writer.print("<UL>");
        for (TweetDto tweetDto : tweets) {
            writer.print("<LI>id="+tweetDto.getId()+" title: "
                    +tweetDto.getTitle()+" message: "+tweetDto.getMessage()+"</LI>");
        }
        writer.print("</UL>");
        writer.print("</BODY>");
        writer.print("</HTML>");

    }
}
