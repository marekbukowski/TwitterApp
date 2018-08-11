package sda.java6.twitter.hibernate;

import org.junit.Test;

import static org.junit.Assert.*;

public class HibernateConfigurationLoaderTest {

    @Test
    public void shouldLoadHibernateConfiguration() {
        HibernateConfigurationLoader.getSessionFactory();
    }

}