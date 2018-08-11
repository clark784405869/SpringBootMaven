package com.artiope.springbootmaven.service;

import java.util.List;

import javax.annotation.Resource;

import com.artiope.springbootmaven.config.TargetDataSource;
import com.artiope.springbootmaven.entity.Demo;
import org.springframework.stereotype.Service;

import com.artiope.springbootmaven.dao.TestDao;

@Service
public class TestService {
   
    @Resource
    private TestDao testDao;
   
    /**
     * 不指定数据源使用默认数据源
     * @return
     */
    public List<Demo> getList(){
       return testDao.getList();
    }
   
    /**
     * 指定数据源
     * @return
     */
    @TargetDataSource("ds1")
    public List<Demo> getListByDs1(){
        return testDao.getListByDs1();
    }
}
