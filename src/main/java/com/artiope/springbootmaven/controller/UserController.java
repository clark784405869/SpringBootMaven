package com.artiope.springbootmaven.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.artiope.springbootmaven.entity.mongo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.artiope.springbootmaven.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
   
    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    public String userInfo(String name,Map<String, Object> map){
    	System.out.println("name:"+name);
    	List<User> users =userService.findByName(name);
    	for (User user : users) {
			System.out.println(user);
		}
    	map.put("username", name);
       return "test";
    }
    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/user2")
    public String userInfo2(String name,String pwd,Map<String, Object> map){
    	System.out.println("name:"+name+"&pwd:"+pwd);
    	//User user = userService.findUserByNameAndPwd(name, pwd);
    	//User user = userService.findUserByNameOrPwd(name, pwd);
    	List<User> users =userService.findUserByNameOrPwd(name, pwd);
    	
    	System.out.println(users.size());
    	System.out.println(users.get(0));
    	for (User user : users) {
			System.out.println(user);
		}
    	//System.out.println(user);
    	map.put("username", name);
       return "test";
    }
    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAddPage")
    public String page(){ 
    	/*User user= new User();
    	user.setName("测试Mongo");
    	user.setPwd("123456");
    	userService.save(user);
    	map.put("username", user.getName());*/
    	
       return "userAdd";
    }
    

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping(value="/userAdd",method=RequestMethod.POST)
    public String userAdd(@RequestParam("username") String name,
    	    @RequestParam(value="password") String pwd,Map<String, Object> map){ 
    	User user= new User();
    	user.setName(name);
    	user.setPwd(pwd);
    	userService.save(user);
    	map.put("msg", user.getName()+"增加成功！");
    	
       return "userAdd";
    }
   
}
