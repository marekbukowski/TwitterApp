package sda.java6.twitter.service;

import sda.java6.twitter.dto.TweetDto;
import sda.java6.twitter.exceptions.TweetNotFoundException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwitterServiceImpl implements TwitterService {

    @Override
    public List<TweetDto> findAll() {
        TweetDto tweetDto1 = new TweetDto(1, "tweet title 1",
                "tweet description 1", 2);
        TweetDto tweetDto2 = new TweetDto(2, "tweet title 2",
                "tweet description 2", 3);
        return Arrays.asList(tweetDto1, tweetDto2);
    }

    @Override
    public TweetDto findById(int id) throws TweetNotFoundException {
        Map<Integer, TweetDto> tweetsMap = new HashMap<Integer, TweetDto>();
        TweetDto tweetDto1 = new TweetDto(1, "tweet title 1",
                "tweet description 1", 2);
        TweetDto tweetDto2 = new TweetDto(2, "tweet title 2",
                "tweet description 2", 3);
        tweetsMap.put(tweetDto1.getId(), tweetDto1);
        tweetsMap.put(tweetDto2.getId(), tweetDto2);

        TweetDto tweetDto = tweetsMap.get(id);
        if (tweetDto!=null) {
            return tweetDto;
        } else {
            throw new TweetNotFoundException("Tweet was not found in database");
        }
    }

    @Override
    public void save(TweetDto tweetDto) {

    }

    @Override
    public void delete(int id) {

    }
}
