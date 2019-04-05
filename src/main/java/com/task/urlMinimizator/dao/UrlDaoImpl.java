package com.task.urlMinimizator.dao;

import com.task.urlMinimizator.beans.Url;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UrlDaoImpl implements UrlDao {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(UrlDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveUrl(Url url) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(url);
        LOGGER.info("Url successfully saved. Url details: " + url);
    }

    @Override
    public void deleteUrl(Url url) {
        Session session = this.sessionFactory.getCurrentSession();
        if(url != null) session.delete(url);
        LOGGER.info("Url successfully delete. Url details: " + url);
    }

    @Override
    public void updateUrl(Url url) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(url);
        LOGGER.info("Url successfully update. Url details: " + url);
    }

    @Override
    public List<Url> getAllUrls() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Url> urlList = session.createQuery("Select * FROM url").list();
        LOGGER.info("All urls successfully loaded.");
        return urlList;
    }
}
