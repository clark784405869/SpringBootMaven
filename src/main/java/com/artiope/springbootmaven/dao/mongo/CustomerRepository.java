package com.artiope.springbootmaven.dao.mongo;

import java.util.List;

import com.artiope.springbootmaven.entity.mongo.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends PagingAndSortingRepository<Customer,String>{
    public List<Customer> findByName();
		
	
}