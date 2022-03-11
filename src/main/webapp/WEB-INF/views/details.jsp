<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서정보관리-도서정보</title>
</head>
<body>
	<h2>도서정보관리-도서정보</h2>
	<table border="1">
		<tr>
			<td rowspan="5" width="100px"><img
				src="<c:url value='/image/${bookinfo.image }'/>" width="300"></td>
			<td><spring:message code="isbn" /></td>
			<td>${bookinfo.isbn }</td>
		</tr>
		<tr>
			<td><spring:message code="bookname" /></td>
			<td>${bookinfo.bookname }</td>
		</tr>
		<tr>
			<td><spring:message code="writer" /></td>
			<td>${bookinfo.writer }</td>
		</tr>
		<tr>
			<td><spring:message code="publisher" /></td>
			<td>${bookinfo.publisher }</td>
		</tr>
		<tr>
			<td><spring:message code="price" /></td>
			<td>${bookinfo.price }</td>
		</tr>
		<tr>
			<td><spring:message code="introduction" /></td>
			<td colspan="2">${bookinfo.introduction }</td>
		</tr>
	</table>
	<input type="button" value="도서 정보 목록"
		onClick="location='<c:url value='/list'/>'" />
	<br>
	<!-- <a href="<c:url value='/list'/>"><button>도서 정보 목록</button></a> -->

</body>
</html>