package com.cookie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 쿠키란(cookie)? 
 *  - HTTP의 기록서의 일종으로 사용자가 웹사이트를 방문하면 사이트에서 사용하는 정보를 저장할수 있는 기능
 *  - 쿠키 표준 : 최대 4kb, 저장갯수 3000개, 문자열만 저장 가능!
 *  - 기록 장소 : 웹브라우저가 지정한 고유 path에 저장됨 (Client)
 *  - 특징 : 보안에 취약하다고 알려짐 -> 개발자가 안전하게 사용할수 있도록 기술적 보완(JWT)을 하거나 중요하지 않은 기능만 저장. 
 */

@WebServlet("/cookietest.do")
public class CreateCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 쿠키를 생성하는 방법
		// 1. 쿠키 객체를 생성하고, key-value 패턴으로 값을 넣어줌
		Cookie cookie1 = new Cookie("C_ID", "test12345"); 
		Cookie cookie2 = new Cookie("C_NAME", "홍길동");
		
		// 2. 필요한 쿠키 설정을 추가한다. (보존 시간, 경로, 도메인)
//		cookie1.setDomain("www.foo.com"); // 쿠키의 유효 도메인 
//		cookie1.setSecure(true); // https로 전달받았을 때만 유효한 방법
		cookie1.setPath(req.getContextPath()); // 쿠키의 유효 경로 설정, /03_SessionCookie에서만 쿠키가 유효함
		cookie1.setMaxAge(60 * 60 * 24); // 쿠키가 client에서 살아있는 시간을 설정, 초단위 입력, 하루 = 60*60*24
		cookie2.setMaxAge(60*2); // 2분 설정
		
		// 3. 응답에 쿠키를 담아 클라이언트로 전송
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		
		// 응답페이지 만들기
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
				
		out.append("<html>");
		out.append("<body>");
		out.append("<h1>쿠키를 생성하였습니다.</h1>");
		out.append("<a href = 'checkcookie.do'>저장된 쿠키 확인</a>");
		out.append("</body>");
		out.append("</html>");
	}
}
