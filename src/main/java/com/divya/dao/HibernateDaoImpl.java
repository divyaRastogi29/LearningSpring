package com.divya.dao;


import com.divya.model.Spitter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public void saveSpittr(Spitter spitter){
         getSessionFactory().openSession().save(spitter);
    }

   /* public Spitter findByUserName(String username){
        return (Spitter) getSessionFactory().openSession().createCriteria(Spitter.class).
                add()
    }
*/
    public List<Spitter> findAll(){
        return (List<Spitter>) getSessionFactory().openSession().createCriteria(Spitter.class).list();
    }
}
