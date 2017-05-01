<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="by.epam.course.basic.beans.users.User,java.util.List"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/customtags/webtag.tld" prefix="printUsers" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<a href="/WebProject/main.jsp"> Back to Main Page</a> <br />
	<printUsers:showAllUsersTag listItems="${listItems}"  />
</body>
</html>