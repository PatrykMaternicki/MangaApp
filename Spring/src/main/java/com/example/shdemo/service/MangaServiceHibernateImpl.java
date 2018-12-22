package com.example.shdemo.service;

import com.example.shdemo.domain.Manga;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class MangaServiceHibernateImpl {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long create(Manga manga) {
        manga.setId(null);
        return (Long) sessionFactory.getCurrentSession().save(manga);
    }

    public Boolean delete(Long id) {
        List<Manga> list = sessionFactory.getCurrentSession().getNamedQuery("manga.all").list();

        for (Manga manga : list) {
            if (manga.getId().equals(id)) {
                sessionFactory.getCurrentSession().delete(manga);
            }
        }
        return true;
    }

    public List<Manga> getAllManga() {
        return sessionFactory.getCurrentSession().getNamedQuery("manga.all").list();
    }

    public Boolean update(Long id) {
        List<Manga> list = sessionFactory.getCurrentSession().getNamedQuery("manga.all").list();
        for (Manga manga : list) {
            if (manga.getId().equals(id)) {
                sessionFactory.getCurrentSession().update(manga);
            }
        }
        return true;
    }

    public Manga read(Long id) {
        return (Manga) sessionFactory.getCurrentSession().get(Manga.class, id);
    }
}
