package sda.java6.twitter.service;

import org.junit.Assert;
import org.junit.Test;
import sda.java6.twitter.dto.TweetDto;
import sda.java6.twitter.exceptions.RequiredSearchParamsException;

import java.util.List;

import static org.junit.Assert.*;

public class TwitterSearchServiceImplTest {

    private TwitterSearchService twitterSearchService = new TwitterSearchServiceImpl();

    @Test
    public void shouldFindTweetsByKeyword() throws RequiredSearchParamsException {
        List<TweetDto> tweets=twitterSearchService.find("description 2", null, null);
        Assert.assertEquals(1,tweets.size());
    }

    @Test
    public void shouldFindAllTweetsByKeyword() throws RequiredSearchParamsException {
        List<TweetDto> tweets=twitterSearchService.find("description",null, "");
        Assert.assertEquals(2, tweets.size());
    }

    @Test
    public void shouldFindTweetsByKeywordAndTitle() throws RequiredSearchParamsException {
        List<TweetDto> tweets=twitterSearchService.find("description 2", "title 2", null);
        Assert.assertEquals(1,tweets.size());
    }

    @Test
    public void shouldFindTweetsByKeywordAndTitleAndMessage() throws RequiredSearchParamsException {
        List<TweetDto> tweets=twitterSearchService.find("description 2", "title 2", "description 2");
        Assert.assertEquals(1,tweets.size());
    }

    @Test(expected = RequiredSearchParamsException.class)
    public void shouldThrowRequiredSearchParamsExceptionWhenSearchParamsAreEmpty() throws RequiredSearchParamsException {
        List<TweetDto> tweets = twitterSearchService.find(null, "", null);
    }
}