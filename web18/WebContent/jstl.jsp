<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,com.dlj.domain.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//存储字符串
	request.setAttribute("company", "黑马程序员");
	//存储对象
	User user1=new User(1,"zhangsan1","1231");
	session.setAttribute("user", user1);
	//存储集合
	List<User>  list=new ArrayList<User>();
	User user2=new User(2,"zhangsan2","1232");
	User user3=new User(3,"zhangsan3","1233");
	list.add(user2);
	list.add(user3);
	application.setAttribute("list", list);
	List<String> strl=new ArrayList<String>();
	strl.add("dlj\n");
	strl.add("love\n");
	strl.add("zhangfan\n");
	application.setAttribute("string",strl);
	%>
	<c:forEach items="${applicationScope.list}" var="l">
		${l.password }
	</c:forEach>
	<c:forEach items="${applicationScope.string }" var="str">
	${str }
	</c:forEach>
</body>
</html>