package sda.java6.twitter.service;

import sda.java6.twitter.dto.TweetDto;
import sda.java6.twitter.exceptions.TweetNotFoundException;

import java.util.List;

public interface TwitterService {

    public List<TweetDto> findAll();

    public TweetDto findById(int id) throws TweetNotFoundException;

    public void save(TweetDto tweetDto);

    public void delete(int id);
}
