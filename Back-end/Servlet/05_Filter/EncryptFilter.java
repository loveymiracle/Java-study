package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.multi.wrapper.EncryptWrapper;

//@WebFilter(filterName = "EncryptFilter", servletNames = {"loginServlet", "enrollServlet"})
@WebFilter(filterName = "EncryptFilter", urlPatterns = "/views/member/enrollResult.jsp")
public class EncryptFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("EncryptFilter가 호출됨");

		// EncryptWrapper로 필터링 할 예정
		EncryptWrapper warpper = new EncryptWrapper((HttpServletRequest)request);
		
		// request 자리에 wrapper로 교체해서 들어간다.
		chain.doFilter(warpper, response);
	}
}
