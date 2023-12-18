<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // reqeust, response 사용 가능 -> jsp도 결국 servlet으로 자동 변환되므로 쓸 수 있다.
  MemberRepository memberRepository = MemberRepository.getInstance();

  System.out.println("MemberSaveServlet.service");
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(username, age);
  memberRepository.save(member);
%>

<%--<%%> 표시가 없을 경우 http response에 그대로 담는다.--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
  성공
<ul>
<%-- <%= %> 자바 코드 출력 --%>
  <li>id=<%=member.getId()%></li>
  <li>username=<%=member.getUsername()%></li>
  <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
