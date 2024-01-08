<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String height = request.getParameter("height");
	String[] hobbies = request.getParameterValues("hobby");
%>  
  
  
<%@ include file="/views/common/header.jsp" %>

<section>
	<h3>회원가입 결과</h3>
	- 아이디 : <%=id %><br>
	- 비번 : <%=pwd %><br>
	- 이름 : <%=name %><br>
	- 나이 : <%=age %><br>
	- 성별 : <%=gender %><br>
	- 신장 : <%=height %><br>
	- 취미 : <%=Arrays.toString(hobbies) %><br>
	- 취미2 :
	<%for(int i = 0; i < hobbies.length; i++){ %>
		<%="" + hobbies[i] + "," %>
	<%} %>
	<br>
	- 취미3 :
	<%for(String hobby : hobbies){ %>
		<%="" + hobby + ", " %>
	<%} %>
	<br>
</section>



<%@ include file="/views/common/footer.jsp" %>
