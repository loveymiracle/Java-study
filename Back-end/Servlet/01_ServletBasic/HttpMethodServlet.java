package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

//http://localhost/01_ServletBasic/method.do?name=hong+gil+dong&age=31&gender=%EB%82%A8%EC%84%B1&height=181&hobby=%EC%95%BC%EA%B5%AC&hobby=%EA%B2%8C%EC%9E%84&hobby=%ED%85%8C%EB%8B%88%EC%8A%A4

@WebServlet("/method.do")
public class HttpMethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("method.do - doGet 호출됨!");
		
		// 사용자 파라메터 처리하는 방법, request에서 getParameter를 통해 처리가능
		// getParameter에서 파라메터를 가져올때는 태그의 name 속성으로 가져온다.
		String name = req.getParameter("name");
		String age = req.getParameter("age");
//		int ageVal = Integer.parseInt(age); // 숫자처리가 필요없으면 문자열로 처리하는 것이 일반적
		String gender = req.getParameter("gender");
		String height = req.getParameter("height");
		String hobby = req.getParameter("hobby");
		String[] hobbies = req.getParameterValues("hobby"); // 다중값 처리를 위해서는 getParameterValues로 배열로 가져올수 있다.
		
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("gender : " + gender);
		System.out.println("height : " + height);
		System.out.println("hobby : " + hobby);
		System.out.println("hobbies : " + Arrays.toString(hobbies));
		
		
		// 응답 처리부
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>사용자 정보 출력</h1>");
		out.println("이름 : " + name + "<br>");
		out.println("나이 : " + age + "<br>");
		out.println("성별 : " + gender + "<br>");
		out.println("신장 : " + height + "<br>");
		out.println("취미 : " + hobby + "<br>");
		out.println("취미(전체) : " + Arrays.toString(hobbies) + "<br>");
		out.println("<body>");
		out.println("</html>");
	}
	
	// post 메소드가 없는 상태에서 post 요청시 405 에러 발생!
	// HTTP 상태 405 – 허용되지 않는 메소드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("method.do - doPost 호출됨!");
		req.setCharacterEncoding("UTF-8"); // req객체의 파라메터의 인코딩을 셋팅하는 방법
		doGet(req, resp);
	}
}
