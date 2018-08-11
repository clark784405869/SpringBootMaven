package com.artiope.springbootmaven.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.artiope.springbootmaven.dao.mongo.CustomerRepository;
import com.artiope.springbootmaven.entity.mongo.Customer;

/**
 *  mongodb分页功能
 * @author zhangpeng_tom@tom.com
 *
 */
@RequestMapping("/customer")
@Controller
public class CustomerController implements ErrorController{
	
	
@Autowired
CustomerRepository customerDao;
//完成分页请求
@RequestMapping("/selectName")
    public String selectName(@RequestParam("id") int id,Map<String, Object> map){
        //构建分页信息
        PageRequest pageRequest = buildPageRequest(id,5,null);
        //查询指定分页的内容
        Iterator<Customer> customers =  customerDao.findAll(pageRequest).iterator();
        List<Customer> lists = new ArrayList<Customer>();
        while(customers.hasNext()){
            //lists.add(customers.next());
            System.out.println(customers.next());
        }
        map.put("msg", "查询成功！");
    	
        return "customerAdd";
    }
    /**
     *      * 创建分页请求.      
     */
    private PageRequest buildPageRequest(int pageNumber, int pageSize,String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Direction.DESC, "id");
        } else if ("birthday".equals(sortType)) {
            sort = new Sort(Direction.ASC, "birthday");
        }
        //参数1表示当前第几页,参数2表示每页的大小,参数3表示排序
        return new PageRequest(pageNumber-1,pageSize,sort);
    }
    
    
    /**
     * 用户添加;
     * @return
     */
    @RequestMapping(value="/customerAdd",method=RequestMethod.POST)
    public String userAdd( Customer customer,Map<String, Object> map){ 
    	customerDao.save(customer);
    	
    	map.put("msg", customer.getName()+"增加成功！");
    	
       return "customerAdd";
       
    }
    
    /**
     * 用户添加;
     * @return
     */
    @RequestMapping(value="/customerAddPage")
    public String customerAdd(Map<String, Object> map){ 
    Customer customer =new Customer();
    	map.put("customer", customer);
    	map.put("action", "customerAdd");
    	
       return "customerAdd";
       
    }
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
}