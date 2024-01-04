package com.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet이란?
 * - 외부에서 특정 페이지(url)의 요청(Request)에 따라 응답(Response) 내용을 사용자가 정의한 Class
 * - ex) login 요청 -> id, pw를 통해 사용자 인증여부 확인 -> 로그인 결과(성공/실패) 응답
 * - 서블릿은 요청과 응답 사이에 사용자가 정의한 기능에 대한 비지니스 로직(알고리즘, 코드)을 구현한 구조로 구성됨
 * 
 *  사용법 : HttpServlet을 상속하고, doGet, doPost를 재정의(오버라이딩 @Override)하여 사용함
 */


public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 객체직렬화를 위한 코드 버전으로 버전이 바뀔때마다 변경되어야 하지만 일반적으로 신경쓰지 않는다.
	
	// doGet : 사용자의 get 요청을 처리하는 메소드, 일반적인 url을 접근 모두 get
		// HttpServletRequest : 사용자의 요청 정보를 담는 객체, 요청url, 파라메터★, 각종 사용자 정보(ip, 브라우저)
		// HttpServletResponse : 서버가 응답할 내용을 담는 객체, HTML 문서를 담는 공간 -> 향후 JSP에서 처리할 예정
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet에서 호출됨!");
		
		// 사용자의 요청정보를 확인하는 방법
		// HttpServletRequest를 통해 사용자 url을 확인하는 방법
		String url = req.getRequestURI();
		System.out.println("사용자 정보 URL : " + url);
		
		// 응답 방법 (고전적인 방법으로 응답을 만들껀데, 향후에는 이렇게 쓰지 않을 예정!)
		// HttpServletResponse 활용법
		resp.setContentType("text/html;charset=UTF-8"); // 응답할 페이지의 속성을 결정
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>FirstServlet에서 응답한 최초의 메세지!</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	// doPost : 사용자의 post 요청을 처리하는 메소드, form으로 부터 post로 지정했을때만 처리 가능
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost에서 호출됨!");
		doGet(req, resp); // doGet에서 처리하는 방법
	}
	
	

}
