package com.artiope.springbootmaven.service;


import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.artiope.springbootmaven.dao.DemoDao;
import com.artiope.springbootmaven.entity.Demo;
import org.springframework.stereotype.Service;

import com.artiope.springbootmaven.dao.DemoRepository;

/**
 * 提供Demo服务类.
 * @author Administrator
 *
 */
@Service
public class DemoService {
   
    @Resource
    private DemoRepository demoRepository;
    
   @Resource
    private DemoDao demoDao;
    
    @Transactional
    public void save(Demo demo){
       demoRepository.save(demo);
    }
    
    public Demo getById(long id){
        //demoRepository.findOne(id);//在demoRepository可以直接使用findOne进行获取.
    
        return demoDao.getById(id);
    }
    
}
