package sda.java6.twitter.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sda.java6.twitter.entities.Message;
import sda.java6.twitter.exceptions.TwitterDatabaseException;
import sda.java6.twitter.hibernate.HibernateConfigurationLoader;

import javax.persistence.Query;
import java.util.List;


public class TweetsDaoImpl implements TweetsDao {

    private Logger logger = Logger.getLogger(TweetsDaoImpl.class);

    private SessionFactory sessionFactory =
            HibernateConfigurationLoader.getSessionFactory();

    @Override
    public List<Message> findAll() throws TwitterDatabaseException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Message");
            return null;//(List<Message>)query.list();

        } catch (HibernateException e) {
            logger.error("Problem during retriving tweets form database", e);
            throw new TwitterDatabaseException("Problem during retriving tweets from database");
        }
    }

    @Override
    public Message findById(Long id) throws TwitterDatabaseException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Message message=session.find(Message.class, id);
            return message;
        } catch (HibernateException e) {
            logger.error("Problem during retrieving tweet from database",e );
            throw new TwitterDatabaseException("Problem during retrieving tweet from database");
        }
    }
}
