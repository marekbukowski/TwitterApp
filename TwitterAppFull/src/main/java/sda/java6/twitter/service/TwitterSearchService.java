package sda.java6.twitter.service;

import sda.java6.twitter.dto.TweetDto;
import sda.java6.twitter.exceptions.RequiredSearchParamsException;

import java.util.List;

public interface TwitterSearchService {

    public List<TweetDto> find(String keyword, String title, String message)
            throws RequiredSearchParamsException;
}
