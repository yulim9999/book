<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />

<title>도서 정보 관리-도서추가</title>
</head>
<body>
	<h2>도서정보관리-도서추가</h2>
	<form:form commandName="bookInfo" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td colspan="3">*표시는 필수 입니다.</td>
			</tr>
			<tr>
				<td rowspan="6" width="100px">
					<div id="image_container"></div> <script>
						function setThumbnail(event) {
							var reader = new FileReader();
							reader.onload = function(event) {
								var img = document.createElement("img");
								img.setAttribute("src", event.target.result);
								document.querySelector("div#image_container")
										.appendChild(img);
							};
							reader.readAsDataURL(event.target.files[0]);
						}
					</script>

				</td>
				<td><spring:message code="isbn" /></td>
				<td><form:input path="isbn"  pattern="[0-9]+"/> <form:errors path="isbn" /></td>
			</tr>
			<tr>
				<td><spring:message code="bookname" /></td>
				<td><form:input path="bookname" /> <form:errors
						path="bookname" /></td>
			</tr>
			<tr>
				<td><spring:message code="writer" /></td>
				<td><form:input path="writer" />
					<form:errors path="writer" /></td>
			</tr>
			<tr>
				<td><spring:message code="publisher" /></td>
				<td><form:input path="publisher" />
					<form:errors path="publisher" /></td>
			</tr>
			<tr>
				<td><spring:message code="price" /></td>
				<td><form:input path="price"  pattern="[0-9]+"/>
					<form:errors path="price" /></td>
			</tr>
			<tr>
				<td><spring:message code="image" /></td>
				<td><form:input path="file" type="file"
						onchange="setThumbnail(event);" />
					<form:errors path="file" /></td>
			</tr>
			<tr>
				<td><spring:message code="introduction" /></td>
				<td colspan="2"><form:textarea path="introduction" cols="50"
						rows="10" />
					<form:errors path="introduction" /></td>
			</tr>
		</table>
		<input type="submit" value="<spring:message code="add.btn"/>">
		<input type="button" value="<spring:message code="add.list"/>"
			onClick="location='list'">
	</form:form>
</body>
</html>