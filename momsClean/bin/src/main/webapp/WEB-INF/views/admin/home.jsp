<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mom's Clean</title>
</head>
<body>
	<h1>
		<!-- 메시지 프로퍼티 파일로부터 메시지 내용을 읽어온다. -->
		<spring:message code="common.homeWelcome"></spring:message>
	</h1>
</body>
</html>