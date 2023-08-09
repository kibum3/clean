<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<style type="text/css">
.logout
	{
	
	border-color:#6AAAFF;
	font-size:20px;
	background-color:white;
	font-weight:bold;
	margin-right:50px;

	}

.mom {
	font-family: "나눔바른고딕";
	font-weight: 50px;
	font-size: 100px;
	color: #6AAAFF;
}
.logo{
	
}

</style>
<div align="right">
<a href="/login" class="logout"><spring:message
		code="header.admin.logout"/></a>
</div>
<div align="center" class="mom">
		<img class="logo" src="../../../image/momsImage.png" width="200px" height="120px">
		<a href="/" style="color: inherit;">MOM'S CLEAN</a>
</div>


