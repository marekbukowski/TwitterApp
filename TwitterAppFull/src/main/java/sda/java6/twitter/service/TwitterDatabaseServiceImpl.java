package sda.java6.twitter.service;

import sda.java6.twitter.dao.TweetsDao;
import sda.java6.twitter.dao.TweetsDaoImpl;
import sda.java6.twitter.dto.TweetDto;
import sda.java6.twitter.entities.Message;
import sda.java6.twitter.exceptions.BaseTwitterException;
import sda.java6.twitter.exceptions.TweetNotFoundException;
import sda.java6.twitter.exceptions.TwitterDatabaseException;

import java.util.List;
import java.util.stream.Collectors;

public class TwitterDatabaseServiceImpl implements TwitterService {

    private TweetsDao tweetsDao = new TweetsDaoImpl();

    private TwitterDtoConverter twitterDtoConverter = new TwitterDtoConverter();

    @Override
    public List<TweetDto> findAll() {
        /*try {
            List<Message> messages = tweetsDao.findAll();
            tweets.stream()
                    .map(tweet -> twitterDtoConverter.convert(tweet))
                    .collect(Collectors.toList());
        }catch (TwitterDatabaseException e){
        }*/
        return null;
    }

    @Override
    public TweetDto findById(int id) throws TweetNotFoundException {
        try {
            Message message=tweetsDao.findById(Long.valueOf(id));
            TweetDto tweetDto = twitterDtoConverter.convert(message);
            return tweetDto;
        } catch (TwitterDatabaseException e) {
            throw new TweetNotFoundException("Problem getting tweet from database");
        }
    }

    @Override
    public void save(TweetDto tweetDto) {
        throw new UnsupportedOperationException("Save is not implemented yet");
    }

    @Override
    public void delete(int id) {

    }

    private class TwitterDtoConverter {

        public TweetDto convert(Message message) {
            TweetDto tweetDto = new TweetDto(message.getId().intValue(),
                    message.getTitle(),
                    message.getMessage(), 0);
            return tweetDto;
        }

    }

}
