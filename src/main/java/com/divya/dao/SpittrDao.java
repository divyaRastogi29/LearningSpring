package com.divya.dao;

import com.divya.model.Spittle;

import java.util.List;

/**
 * Created by divya on 3/10/16.
 */
public interface SpittrDao {
    public List<Spittle> getAllSpittles();
    public Spittle getSpittle(long id);
    public int getCount();
    public int addSpittle(Spittle spittle);
}
