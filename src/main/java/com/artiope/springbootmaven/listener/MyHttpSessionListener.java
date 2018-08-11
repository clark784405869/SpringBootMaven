package com.artiope.springbootmaven.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
 
/**
 * 监听Session的创建与销毁
 *
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
 
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.err.println("Session 被创建");
    }
 
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.err.println("Session 被销毁");
    }
 
}
