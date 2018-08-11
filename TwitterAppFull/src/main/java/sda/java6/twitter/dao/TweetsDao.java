package sda.java6.twitter.dao;

import sda.java6.twitter.entities.Message;
import sda.java6.twitter.exceptions.TwitterDatabaseException;

import java.util.List;

public interface TweetsDao {

    public List<Message> findAll() throws TwitterDatabaseException;

    public Message findById(Long id) throws TwitterDatabaseException;
}
