<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>

	h2{
		font-size:30px;
		color:#6AAAFF;
		margin:0;
	}
	
	#read{
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<br>
<h2>
	<spring:message code="reference.read" />
</h2>
<br>
<form:form modelAttribute="reference">
	

	<input type = "hidden" name="page" value="${pgrq.page}">
	<input type = "hidden" name="sizePerPage" value="${pgrq.sizePerPage}">
	<table id="read" border="1">
		<tr>
			<td id="no"><spring:message code="reference.no" /></td>
			<td><form:input class="no" path="referenceNo" readonly="true" /></td>
			
		</tr>
		<tr>
			<td id="name"><spring:message code="reference.name" /></td>
			<td><form:input class="name" path="userName" readonly="true" /></td>
			
		</tr>
		<tr>
			<td id="phone"><spring:message code="reference.phone" /></td>
			<td><form:input class="phone" path="userPhone" readonly="true" /></td>
			
		</tr>
		<tr>
			<td id="title"><spring:message code="reference.title" /></td>
			<td><form:input class="title" path="referenceTitle" readonly="true" /></td>
			
		</tr>
		<tr>
			<td id="content"><spring:message code="reference.conten" /></td>
			<td><form:textarea class="content" path="referenceContent" readonly="true" /></td>
		</tr>
		<tr>
			<td id="date"><spring:message code="reference.referenceDate" /></td>
			<td><fmt:formatDate  value="${reference.referenceDate}"
					pattern="yyyy-MM-dd" /></td>
		</tr>
	</table>

	<br>
</form:form>
<div>
	<button type="submit" id="btnList">
		<spring:message code="action.list" />
	</button>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="submit" id="btnReply" data-referenceNo="${reference.referenceNo}">
		<spring:message code="action.reply" />
	</button>
</div>

<script>
	$(document).ready(function() {
		var referenceNo = $("#referenceNo");
		var referenceNoVal = referenceNo.val();
		
		var pageObj = $("#page");
		var sizePerPageObj = $("#sizePerPage");
		var pageVal = pageObj.val();
		var sizePerPageVal = sizePerPageObj.val();

		$("#btnList").on("click", function() {
			self.location = "/admin/reference/list";
		});
		
		$("#btnReply").on("click", function() {
            var referenceNo = $(this).data("referenceNo");
            self.location = "/admin/reference/reply?referenceNo=" + referenceNoVal;
		});
	});
</script>