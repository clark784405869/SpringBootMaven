package com.artiope.springbootmaven.dao;

import javax.annotation.Resource;

import com.artiope.springbootmaven.entity.Demo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * 使用JdbcTemplate操作数据库.
 * @author Administrator
 *
 */
@Repository
public class DemoDao {
   
    @Resource
    private JdbcTemplate jdbcTemplate;
   
    /**
     * 通过id获取demo对象.
     * @param id
     * @return
     */
    public Demo getById(long id){
       String sql = "select *from Demo where id=?";
       RowMapper<Demo> rowMapper = new BeanPropertyRowMapper<Demo>(Demo.class);
       return jdbcTemplate.queryForObject(sql, rowMapper,id);
    }
   
}
