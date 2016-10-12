package com.divya.data;

import com.divya.model.Spittle;

import java.util.List;

/**
 * Created by divya on 28/9/16.
 */

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(long id);
    int spittleCount();
    int addSpittle(String message);
    /*int saveSpittr(Spitter spitter);
    Spitter findByUserName(String username);*/
}
