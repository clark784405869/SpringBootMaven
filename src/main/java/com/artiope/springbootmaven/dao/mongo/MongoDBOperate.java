package com.artiope.springbootmaven.dao.mongo;
import java.util.ArrayList;  
import java.util.List;  
import com.mongodb.MongoClient;  
import com.mongodb.MongoCredential;  
import com.mongodb.ServerAddress;  
import com.mongodb.client.MongoDatabase;
import com.mysql.jdbc.StringUtils;

  
public class MongoDBOperate {  
    public static void main(String[] args){  
        
    	   
    }  
    
    
    /**
     * 连接到mongo服务
     * @param ip
     * @param port
     * @param username
     * @param database
     * @param password
     * @return mongoClient对象
     */
    public MongoClient getMongoClient(String ip,int port,String username,String database,String password) {
    	MongoClient mongoClient=null;
    	try {  
    		
    		//TODO  增加对入参的为空判断
    		if (StringUtils.isNullOrEmpty(ip)) {
				ip="localhost";
			}
    		if (port==0) {
				port=27017;
			}
    		if (StringUtils.isNullOrEmpty(database)) {
    			throw new NullPointerException("请至少输入要连接的database");
			}
    		//如果密码或者用户名为空则尝试使用非安全连接
    		if (StringUtils.isNullOrEmpty(username)||StringUtils.isNullOrEmpty(password)) {
    			return new MongoClient(ip,port);
    		       
			}
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址  
            //ServerAddress()两个参数分别为 服务器地址 和 端口  
            ServerAddress serverAddress = new ServerAddress(ip,port);  
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();  
            addrs.add(serverAddress);  
              
            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码  
            MongoCredential credential = MongoCredential.createScramSha1Credential(username, database, password.toCharArray());  
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();  
            credentials.add(credential);  
              
            //通过连接认证获取MongoDB连接  
            mongoClient = new MongoClient(addrs,credentials);  
              
           
            System.out.println("Connect to database successfully");  
        } catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );  
        }  
    	return mongoClient;
	}
    public MongoDatabase getMongoDatabase(MongoClient mongoClient,String database) {
    	 //连接到数据库  
    	//TODO 增加对入参的为空判断
    	if (mongoClient==null||StringUtils.isNullOrEmpty(database)) {
			throw new NullPointerException("请输入要连接的mongoClient和database");
		}
           return mongoClient.getDatabase(database);  
        
	}
} 
