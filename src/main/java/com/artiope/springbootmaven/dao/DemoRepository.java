package com.artiope.springbootmaven.dao;


import java.util.List;

import com.artiope.springbootmaven.entity.Demo;
import org.springframework.data.repository.CrudRepository;

/*
 * 在CrudRepository自带常用的crud方法.
 * 这样一个基本dao就写完了.
 */

public interface DemoRepository extends CrudRepository<Demo, Long>{
	 //public User findByName(String name);
    public List<Demo> findByName(String name);
    
}
