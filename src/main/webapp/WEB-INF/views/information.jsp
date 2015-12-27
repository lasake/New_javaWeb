<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:out value="${guest.time}"></c:out> 
<br>
hello！<c:out value="${guest.name}"></c:out> !你是第 <c:out value="${num}"></c:out> 位访问者，你前面的访问者是
 <table cellpadding="5" cellspacing="0" border="1">
<tr>
<th width="300">姓名</th>
<th width="300">访问时间</th>
</tr>
<c:forEach var="a" items="${map}">
<tr align="center">
<td>${a.name }</td>
<td>${a.time }</td>
</tr>
</c:forEach>
</table>
       
</body>
</html>