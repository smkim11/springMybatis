package com.example.mbboard.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mbboard.dto.ConnectCount;
import com.example.mbboard.mapper.IRootService;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component //Autowired 사용하기위해 Component
public class ConnectCountListener implements HttpSessionListener {
	@Autowired IRootService rootService;
	
    public void sessionCreated(HttpSessionEvent se)  { 
    	log.info("새로운 세션 생성");
    	// 처음 세션이 만들어 졌을때
    	// 클라이언트(쿠키) - 서버(세션)
    	ConnectCount cc = new ConnectCount();
    	cc.setMemberRole("ANONYMOUS");
    	if(rootService.selectConnectDateBykey(cc) == null) {
    		rootService.insertConnectCount(cc);
    	}else {
    		rootService.updateConnectCount(cc);
    	}
    }
    
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	// session.invalidate()
    }
	
}
