package sda.java6.twitter.service;

import sda.java6.twitter.dto.TweetDto;
import sda.java6.twitter.exceptions.RequiredSearchParamsException;

import java.util.ArrayList;
import java.util.List;

public class TwitterSearchServiceImpl implements TwitterSearchService {

    private TwitterService twitterService = new TwitterServiceImpl();

    @Override
    public List<TweetDto> find(String keyword, String title, String message)
    throws RequiredSearchParamsException {
        List<TweetDto> allTweets = twitterService.findAll();
        List<TweetDto> foundTweets = new ArrayList<TweetDto>();
        checkRequiredParams(keyword, title, message);
        if (keyword==null)
            keyword="";
        if (title==null)
            title="";
        if (message==null)
            message="";
        keyword = keyword.toLowerCase();
        title = title.toLowerCase();
        message = message.toLowerCase();

        for (TweetDto tweetDto : allTweets) {
            String tweetMessage = tweetDto.getMessage().toLowerCase();
            String tweetTitle = tweetDto.getTitle().toLowerCase();
            tweetMessage = tweetMessage.toLowerCase();
            tweetTitle = tweetTitle.toLowerCase();
            if (("".equals(keyword) || tweetMessage.contains(keyword) || tweetTitle.contains(keyword))
                    && ("".equals(message) || tweetMessage.contains(message))
                    && ("".equals(title) || tweetTitle.contains(title)) ) {
                foundTweets.add(tweetDto);
            }
        }
        return foundTweets;
    }

    private void checkRequiredParams(String keyword, String title, String message) throws RequiredSearchParamsException {
        if ((keyword==null || "".equals(keyword)) &&
                (title==null || "".equals(title))
                && (message==null|| "".equals(message))) {
            throw new RequiredSearchParamsException("Tweet search params were empty");
        }
    }
}
