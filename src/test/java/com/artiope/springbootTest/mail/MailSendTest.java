package com.artiope.springbootTest.mail;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.artiope.springbootmaven.SpringBootMaven;

import freemarker.template.Template;

/**
*
* @author zhangpeng_tom@tom.com
* @version v.0.1
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootMaven.class)
public class MailSendTest {
   @Autowired
   private JavaMailSender mailSender;
   @Autowired
   private FreeMarkerConfigurer freeMarkerConfigurer;
   /**
    * 修改application.properties的用户，切该用户账户中开启SMTP服务才能发送。
    */
   /*@Test
   public void sendSimpleEmail(){
      SimpleMailMessage message = new SimpleMailMessage();
     
      message.setFrom("784405869@qq.com");//发送者.
      message.setTo("zhangpeng_tom@tom.com_tom@tom.com");//接收者.
      message.setSubject("测试邮件（邮件主题）");//邮件主题.
      message.setText("这是邮件内容");//邮件内容.
     
      mailSender.send(message);//发送邮件
   }*/
   /**
    * 测试发送附件.(这里发送图片.)
    * @throws MessagingException
    */
   //@Test
   public void sendAttachmentsEmail() throws MessagingException{
      //这个是javax.mail.internet.MimeMessage下的，不要搞错了。
      MimeMessage mimeMessage =  mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
     
      //基本设置.
      helper.setFrom("784405869@qq.com");//发送者.
      helper.setTo("zhangpeng_tom@tom.com_tom@tom.com");//接收者.
      helper.setSubject("测试附件（邮件主题）");//邮件主题.
      helper.setText("这是邮件内容（有附件哦.）");//邮件内容.
     
      //org.springframework.core.io.FileSystemResource下的:
      //附件1,获取文件对象.
     //  FileSystemResource file1 = new FileSystemResource(new File("resources/static/img/test.png"));
      //添加附件，这里第一个参数是在邮件中显示的名称，也可以直接是head.jpg，但是一定要有文件后缀，不然就无法显示图片了。
      //helper.addAttachment("头像1.jpg", file1);
      //附件2
      FileSystemResource file2 = new FileSystemResource(new File("/Users/zhangpeng_tom@tom.com/Desktop/head.jpg"));
      helper.addAttachment("头像2.jpg", file2);
       System.out.println(file2);
      
       mailSender.send(mimeMessage);
	   //Assert.assertEquals(file1, null);
   }
   /**
    * 邮件中使用静态资源.
    * @throws Exception
    */
   //@Test
   public void sendInlineMail() throws Exception {
       MimeMessage mimeMessage = mailSender.createMimeMessage();

       MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
     //基本设置.
      helper.setFrom("784405869@qq.com");//发送者.
      helper.setTo("zhangpeng_tom@tom.com_tom@tom.com");//接收者.
      helper.setSubject("测试静态资源（邮件主题）");//邮件主题.
      // 邮件内容，第二个参数指定发送的是HTML格式 
      //说明：嵌入图片<img src='cid:head'/>，其中cid:是固定的写法，而aaa是一个contentId。
       helper.setText("<body>这是图片：<img src='cid:head' /></body>", true);
      
       FileSystemResource file = new FileSystemResource(new File("/Users/zhangpeng_tom@tom.com/Desktop/head.jpg"));
       helper.addInline("head",file);

       mailSender.send(mimeMessage);

   }
   /**
    * 模板邮件；
    * @throws Exception
    */
   @Test
   public void sendTemplateMail() throws Exception {

       MimeMessage mimeMessage = mailSender.createMimeMessage();

       MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
       //基本设置.
      helper.setFrom("784405869@qq.com");//发送者.
      helper.setTo("zhangpeng_tom@tom.com_tom@tom.com");//接收者.
      helper.setSubject("模板邮件（邮件主题）");//邮件主题.

       Map<String, Object> model = new HashMap<String, Object>();
       model.put("username", "傻逼！");
       model.put("userImg", "./img/head.jpg");
      
//       Template template = freeMarkerConfigurer.getConfiguration().getTemplate("email.ftl");//加载资源文件 
       //实际开发中这个定义一个bean进行使用，上一个代码就是定义为bean进行加入的，这里为了方便直接new使用。
      // FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
      // configurer.setTemplateLoaderPath("classpath:templates");
       Template template = freeMarkerConfigurer.getConfiguration().getTemplate("email.ftl");//加载资源文件 
      
       String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
       helper.setText(html, true);
       mailSender.send(mimeMessage);
   }
   
}