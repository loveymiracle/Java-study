package com.data.controller.ex02;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* 서버에서 page 이동에 관련한 방법 정리
* 
* 1. forward 방식
*   - Response - RequestDispatcher에서 forward 메소드를 활용하여 이동하는 방식
*   - 서버 내부적인 페이지 이동(연결)으로 가지고 있던 파라메터 및 Attribute를 모두 유지 됨
*   - 예시) 로그인 Controller(Servlet) -> 로그인 결과 View (JSP) 
*     [MVC 패턴2] 에서 활용됨 
*   - 메커니즘 : Class간 내부에서 이동하는 방식
*  
* 2. SendRedirect 방식 - 301 Moved Permanently
*   - Request - SendRedirect 함수를 호출하는 방식
*   - Client에게 특정 페이지 url을 다시 요청하라는 명령으로 응답 받은 페이지가 다시 요청됨
*   - 페이지가 재요청 되면서 기존에 가진 파라메터 및 Attribute를 초기화 함
*   - 예시) 로그인 실패 -> 메인페이지로 이동 시킬때, 기존 data를 소거하고 get 방식
* 	   주로 단순 페이지 이동에도 활용됨.
*   - 메커니즘 : 사용자 브라우저에서 페이지가 다시 요청되어 이동되는 원리
*/

// 전달 경로 : ForwardServlet -> JoinMemberServlet으로 보내는 과정
// forward 방식
// : 해당 페이지에서 파라메터를 받아서 다른 페이지로 동일한 파라메터를 전달할 때 사용한다.
@WebServlet("/forward.do")
public class ForwardServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ForwardServlet - doPost 호출됨");
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		// 파라메터를 전달 받고 , JoinMemberServlet로 이동하는 코드
		
		// 1. setAttribute를 통해 페이지간 추가적인 정보를 전달하는 방법
		// setAttribute : key-Value를 통해 추가적인 정보를 담는 공간
		req.setAttribute("MSG", "안녕하세요? 메세지입니다.");
		req.setAttribute("MSG_DATE", new Date()); // 객체로도 전달할 수 있다.
		req.setAttribute("MSG_LIST", List.of(1,2,3,4,5)); // List 객체로도 전달할 수 있다.
		req.setAttribute("MSG", "덮어 쓴 메세지입니다."); // 덮어 써진 메세지로 기존 데이터를 지운다.
		
		// 2. Attribute 값 읽어오기 (다른 Servlet이나 JSP에서 읽어온다.)
		String msg = (String) req.getAttribute("MSG");
		Date date = (Date) req.getAttribute("MSG_DATE");
		List list = (List) req.getAttribute("MSG_LIST"); // List<Integer> list 가능
		System.out.println(msg);
		System.out.println(date);
		System.out.println(list);
		
		// 3. request 접근하기
		System.out.println("id : " + req.getParameter("id"));
		
		// 4. page를 forward로 이동하는 방법
		RequestDispatcher rd = req.getRequestDispatcher("joinMember.do");
		rd.forward(req,  resp); // 실제 페이지가 이동되는 코드!
//		req.getRequestDispatcher("joinMember.do").forward(req, resp); // 한줄로 표현!
		System.out.println("페이지가 이동 되었습니다.");
	}
}
