package com.divya.data;

import com.divya.dao.SpittrDao;
import com.divya.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * Created by divya on 28/9/16.
 */
@Component
public class SpittleRepositoryImpl implements SpittleRepository {

    @Autowired
    SpittrDao spittrDao;

    @Override
    public List<Spittle> findSpittles(long max, int count) {
       List<Spittle> list = spittrDao.getAllSpittles();
        return list;
    }

    @Override
    public Spittle findOne(long id) {
        return spittrDao.getSpittle(id);
    }

    @Override
    public int spittleCount(){
        return spittrDao.getCount();
    }

    @Override
    public int addSpittle(String message){
        Spittle spittle = new Spittle(message, new Random().nextDouble(), new Random().nextDouble());
        return spittrDao.addSpittle(spittle);
    }
}
