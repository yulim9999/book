<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>도서정보관리-리스트</title>
</head>
<body>
	<h2>도서정보관리-리스트</h2>
	<form name="bookInfo" action="<c:url value='/search'/>" method="get">
	<select name="option">
		<option value="bookname">책 제목</option>
		<option value="writer">저자</option>
		<option value="publisher">출판사</option>
	</select> 
		<input type="text" name="keyword" placeholder="제목, 저자, 출판사 검색"> 
		<input type="submit" value="검색">
	</form>
	

	
	
	<form:form commandName="bookInfo" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>등록 번호</th>
				<th>도서 표지</th>
				<th>도서 ISBN</th>
				<th>도서 제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
			</tr>
			<c:forEach var="book" items="${bookinfoList}">
				<tr>
					<td>${book.regnum }</td>
					<td><img src="<c:url value='/image/${book.image }'/>"
						width="300"></td>
					<td>${book.isbn }</td>
					<td><a href="<c:url value='/read/${book.regnum }'/>">
							${book.bookname }</a></td>
					<td>${book.writer }</td>
					<td>${book.publisher }</td>
					<td>${book.price }</td>
				</tr>
			</c:forEach>
			
			
			<c:if test="${! empty searchList }">
				<c:forEach var="book" items="${searchList}">
				<tr>
					<td>${book.regnum }</td>
					<td><img src="<c:url value='/image/${book.image }'/>"
						width="300"></td>
					<td>${book.isbn }</td>
					<td><a href="<c:url value='/read/${book.regnum }'/>">
							${book.bookname }</a></td>
					<td>${book.writer }</td>
					<td>${book.publisher }</td>
					<td>${book.price }</td>
				</tr>
				</c:forEach>
			</c:if>
			
		</table>
		<input type="button" value="도서 정보 추가" onClick="location='add'" />
	</form:form>
</body>
</html>