package sda.java6.twitter.dao;

import org.junit.Assert;
import org.junit.Test;
import sda.java6.twitter.entities.Message;
import sda.java6.twitter.exceptions.TwitterDatabaseException;

import static org.junit.Assert.*;

public class TweetsDaoImplTest {

    private TweetsDao tweetsDao = new TweetsDaoImpl();

    @Test
    public void shouldFindTweetById() throws TwitterDatabaseException {
        Message message =tweetsDao.findById(1l);
        Assert.assertEquals("first tweet", message.getTitle());
        Assert.assertEquals("admin@sda.pl", message.getUser().getEmail());
    }

}