package com.example.mbboard.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextBootListener implements ServletContextListener {

    public ContextBootListener() {
        
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	// 외부저장공간 : DB
    	// Was(Tomcat) 안에 저장공간: application, session, request
    	// 웹브라우저안에 저장공간 : cookie, api
    	ServletContext sc = sce.getServletContext(); // sce이벤트가 발생한 객체 -> Tomcat
    	sc.setAttribute("currentConnectCount", 0); // == Jsp: application.setAttribute()
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }
	
}
