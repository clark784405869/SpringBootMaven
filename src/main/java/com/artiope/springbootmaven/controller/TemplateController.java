package com.artiope.springbootmaven.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
 
/**
 * 模板测试.
 * @author Administrator
 *
 */
@Controller
public class TemplateController {
	  // 从 application.properties 中读取配置，如取不到默认值为Hello Shanhy
    @Value("${application.hello:Hello Angel}")
    private String hello;
   
    /**
     * 返回html模板.
     */
    @RequestMapping("/helloHtml")
    public String helloHtml(Map<String,Object> map){
       map.put("hello","李翔SB！");
       return"/test";
    }
    /**
     * 返回ftl模板.
     */
    @RequestMapping("/helloFtl")
    public String helloFtl(Map<String,Object> map){
       map.put("username","李翔SB！");
       return"/test";
    }
    
    /**
     * 返回jsp页面.
     */
    @RequestMapping("/helloJSP")
    public String helloJSP(Map<String,Object> map){
       map.put("hello",hello);
       return "test";
    }
    
    /**
     * 文件上传具体实现方法;
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file")MultipartFile file){
       if(!file.isEmpty()){
           try {
              /*
               * 这段代码执行完毕之后，图片上传到了工程的跟路径；
               * 大家自己扩散下思维，如果我们想把图片上传到 d:/files大家是否能实现呢？
               * 等等;
               * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如：
               * 1、文件路径；
               * 2、文件名；
               * 3、文件格式;
               * 4、文件大小的限制;
               */
              BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
              out.write(file.getBytes());
              out.flush();
              out.close();
           } catch (FileNotFoundException e) {
              e.printStackTrace();
              return"上传失败,"+e.getMessage();
           } catch (IOException e) {
              e.printStackTrace();
              return"上传失败,"+e.getMessage();
           }
           System.out.println("success!");
           return"上传成功";
       }else{
           return"上传失败，因为文件是空的.";
       }
    }
    
    /**
    * 多文件具体上传时间，主要是使用了MultipartHttpServletRequest和MultipartFile
    * @param request
    * @return
    */
   @RequestMapping(value="/batch/upload", method= RequestMethod.POST) 
   @ResponseBody 
   public String handleFileUpload(HttpServletRequest request){ 
       List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file"); 
       MultipartFile file = null;
       BufferedOutputStream stream = null;
       for (int i =0; i< files.size(); ++i) { 
           file = files.get(i); 
           if (!file.isEmpty()) { 
               try { 
                   byte[] bytes = file.getBytes(); 
                   stream = 
                           new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename()))); 
                   stream.write(bytes); 
                   stream.close(); 
               } catch (Exception e) { 
                   stream =  null;
                   return"You failed to upload " + i + " => " + e.getMessage(); 
               } 
           } else { 
               return"You failed to upload " + i + " because the file was empty."; 
           } 
       } 
       return"upload successful"; 
   } 
   
}

