package com.cookie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkcookie.do")
public class CheckCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 쿠키를 읽어오는 방법
		
		// 1. request 객체에서 쿠키 리스트 가져오기
		Cookie[] cookies = req.getCookies();
		Map<String, Cookie> cookieMap = new HashMap<>();
		
		// 2. 쿠키 탐색하기
		for(Cookie c : cookies) {
			System.out.println("name : " + c.getName() + ", value : " + c.getValue());
			cookieMap.put(c.getName(), c);
		}
		
		// 3. 응답페이지 구성
		String userId = null;
		String userName = null;
		try {
			userId = cookieMap.get("C_ID").getValue();
			userName = cookieMap.get("C_NAME").getValue();
		} catch (Exception e) {}
				
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
				
		PrintWriter out = resp.getWriter();
		out.append("<html><body>");
		out.append("User ID : " + userId +"<br>");
		out.append("User Name : " + userName +"<br>");
		out.printf("<a href='%s'>쿠키 삭제</a><br>", "deletecookie.do");
		out.printf("<a href='%s'>메인 페이지</a><br>", req.getContextPath());
		out.append("</body></html>");
	}
}
