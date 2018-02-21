package com.sapphire.mvc.interceptors;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sapphire.mvc.HitCounter;


public class GlobalInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private HitCounter counter;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		counter.setHits(counter.getHits()+1);
		System.out.println("Hits: "+counter.getHits());
		request.setAttribute("currentDate", new Date());
		return super.preHandle(request, response, handler);
	}

	

	
	

}
