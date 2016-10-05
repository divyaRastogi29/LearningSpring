package com.divya.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by divya on 5/10/16.
 */

@Repository
public class HibernateDaoImpl {

    @Autowired
    private SessionFactory sessionFactory ;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


   /* public int getCount(){
        String hql = "select count(*) from Spittle" ;
        Query query =  getSessionFactory().openSession().createQuery(hql);
        return ((Long)query.uniqueResult()).intValue();
    }*/
}
