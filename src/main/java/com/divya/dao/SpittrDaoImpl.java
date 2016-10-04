package com.divya.dao;

import com.divya.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by divya on 3/10/16.
 */
@Repository("spittrDao")
public class SpittrDaoImpl implements SpittrDao{

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate ;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate ;

    @Override
    public List<Spittle> getAllSpittles() {
        String sql = "select * from spittle";
        return jdbcTemplate.query(sql,new SpittleMapper());
    }

    @Override
    public Spittle getSpittle(long id){
        String sql = "select * from spittle where id= ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new SpittleMapper());
    }

    @Override
    public int getCount(){
        String sql = "select count(*) from spittle";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

   /* @Override
    public int addSpittle(Spittle spittle){
        String sql = "Insert into spittle(message,latitude,longitude) VALUES(?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{spittle.getMessage(),
                spittle.getLatitude(),spittle.getLongitude()});
    }*/

    @Override
    public int addSpittle(Spittle spittle){
        String sql = "Insert into spittle(message,latitude,longitude) VALUES(:message,:latitude,:longitude)";
        SqlParameterSource namedParameters = new MapSqlParameterSource("message",spittle.getMessage()).
                addValue("latitude",spittle.getLatitude()).addValue("longitude",spittle.getLongitude());
        return namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final class SpittleMapper implements RowMapper<Spittle>{

        @Override
        public Spittle mapRow(ResultSet rs, int i) throws SQLException {
            Spittle spittle = new Spittle();
            spittle.setId(rs.getLong("id"));
            spittle.setMessage(rs.getString("message"));
            spittle.setTime(rs.getTimestamp("time").toString());
            spittle.setLatitude(rs.getDouble("latitude"));
            spittle.setLongitude(rs.getDouble("longitude"));
            return spittle;
        }
    }

}
