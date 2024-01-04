package com.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 버전 1의 문제점 : xml로 관리하기 어려움 -> 개발자 실수가 많이 발생한다. -> 생산성 저하
 * 해결방법 : 어노테이션(@Annotation) 활용하여 class와 별도의 파라메터를 맵핑 시킨다.
 * 방법 : @WebServlet(....)를 활용하여, 서블릿 이름과 url을 맵핑 시킨다.
 *
 */


// 방법1. name, urlPATTERNS를 모두 사용하는 방법
//@WebServlet(name = "second", urlPatterns = "/second.do")
//@WebServlet(name = "second", urlPatterns = {"/second.do", "/second2.do"})

// 방법2. 단축된 표현 사용
@WebServlet("/second.do") // '/' 빠지면 안돌아간다!!

public class SecondServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SecondServlet.doGet 호출됨");
		
		System.out.println("요청 URL : " + req.getRequestURI());
		System.out.println("서버 이름 : " + req.getServerName());
		System.out.println("서버 주소 : " + req.getLocalAddr());
		System.out.println("서버 포트 : " + req.getServerPort());
		System.out.println("Context path : " + req.getContextPath()); // ★★★★★ 프로젝트의 path 식별자를 의미함
		System.out.println("사용자 IP : " + req.getRemoteAddr());
		System.out.println("사용자 port : " + req.getRemotePort());
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>SecondServlet에서 응답한 최초의 메세지!</h1>");
		out.println("<div>사용자 IP : " + req.getRemoteAddr() + "</div>");
		out.println("<div>사용자 Port : " + req.getRemotePort() + "</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
