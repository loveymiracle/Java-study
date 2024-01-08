<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Scope 간 생명주기 실습 - index.jsp</h1>
	<%
		application.setAttribute("name", "홍길동"); // 제일 오래 유지
		session.setAttribute("name", "최길동"); // 세션이 해지될 때 까지
		request.setAttribute("name", "박길동"); // 다음 페이지 전달까지 유효, 단 forward일 경우
		pageContext.setAttribute("name", "김길동"); // 현재 페이지에서만 유효
	%>
	
	application : <%=application.getAttribute("name") %> <br>
	session : <%=session.getAttribute("name") %> <br>
	request : <%=request.getAttribute("name") %> <br>
	pageContext : <%=pageContext.getAttribute("name") %> <br>
	
	<a href="scopeTest.jsp">다음 페이지로 이동</a>
	<!-- a태그 = redirect와 동일한 요청 -->

</body>
</html>
