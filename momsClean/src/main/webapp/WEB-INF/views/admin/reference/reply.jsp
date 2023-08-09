<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>

	h2{
		font-size:30px;
		color:#6AAAFF;
		margin:0;
	}
	
	#reply{
		border-left:0px;
		border-right:0px;
		border-collapse : collapse;
		width:700px;
		padding: 0px 5px 0px 5px;

	}
	
	th,td{
	font-family:'Malgun Gothic';
	font-size:18px;
	height:30px;
	}
	
	.no,.name,.phone,.title{
	font-size:18px;
	padding-left: 11px;
	border:none;
	}
	
	.content{
	border:none;
	width: 500px;
	height: 500px;
	font-family:'Malgun Gothic';
	font-size:18px;
	}
	
	#no,#name,#phone,#title,#content,#date{
	background-color:#6AAAFF;
	color:white;
	text-align: center;
	font-weight: bold;
	}

	button{
	border-color:#6AAAFF;
	font-size:20px;
	background-color:white;
	}


</style>
<br>
<h2>
	<spring:message code="reference.reply" />
</h2>
<form:form modelAttribute="reference" action="reply"
	enctype="multipart/form-data">
	<form:hidden path="root" value="${referenceNo}"/>
	<form:hidden path="step"/>
	<form:hidden path="indent"/>
<br>
	<table id="reply" border="1"> 
		<tr>
			<td id="title"><spring:message code="reference.title" /></td>
			<td><form:input class="title" path="referenceTitle" value="RE:${reference.referenceTitle}" /></td>
		</tr>
		<tr>
			<td id="name"><spring:message code="reference.name" /></td>
			<td>관리자</td>
		</tr>
		<tr>
			<td id="content"><spring:message code="reference.conten" /></td>
			<td><form:textarea class="content" path="referenceContent" /></td>
		</tr>
		<tr>
			<td id="date"><spring:message code="reference.referenceDate" /></td>
			<td><fmt:formatDate value="${reference.referenceDate}"
					pattern="yyyy-MM-dd" /></td>
		</tr>
	</table>

</form:form>
<br>
<div>
	<button type="submit" id="btnRegister">
		<spring:message code="item.regist" />
	</button>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="submit" id="btnCancel">
		<spring:message code="item.cancel" />
	</button>
</div>
<script>
	$(document).ready(function() {
		var formObj = $("#reference");

		$("#btnRegister").on("click", function() {

			var titleValue = $("#referenceTitle").val().trim();
			var contentValue = $("#referenceContent").val().trim();


			if (titleValue === "" || contentValue === "") {
				alert("빈칸을 입력하셨습니다.");
			} else {
				formObj.submit();
			}
		});

		$("#btnCancel").on("click", function() {
			self.location = "list";
		});
	});
</script>