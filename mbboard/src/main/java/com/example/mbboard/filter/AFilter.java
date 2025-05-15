package com.example.mbboard.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter("/a")
public class AFilter implements Filter{

	public AFilter() {
		log.info("AFilter 객체 생성후 자동으로 빈등록");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 선행 필터 인증(세션안에 로그인정보가 없다 -> return;), 인가(세션안에 로그인정보는 있지만 이 요청을 허가할 정보가 없다 -> return;)
		log.info("/a 선행코드");
		
		chain.doFilter(request, response);
		
		// 후행 필터
		log.info("/a 후행코드");
	}

}
