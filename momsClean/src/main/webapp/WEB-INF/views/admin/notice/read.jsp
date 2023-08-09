<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

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
	
	.no,.title,.content{
	font-size:18px;
	padding-left: 11px;
	}
	
	.content{
	border:none;
	width: 500px;
	height: 500px;
	font-family:'Malgun Gothic';
	font-size:18px;
	}
	
	#no,#title,#content{
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
<h2><spring:message code="notice.header.read" /></h2>
<br>
<form:form modelAttribute="notice">
<form:hidden path="noticeNo"/>
	
	<input type="hidden" name="page" value="${pgrq.page}"> 
	<input type="hidden" name="sizePerPage" value="${pgrq.sizePerPage}">	

	<table border="1" id="read">
		<tr>
			<td id="no"><spring:message code="notice.no" /></td>
			<td class="no">${notice.noticeNo}</td>
		</tr>
		<tr>
			<td id="title"><spring:message code="notice.title" /></td>
			<td class="title">${notice.noticeTitle}</td>
		</tr>
		<tr>
			<td id="content"><spring:message code="notice.content" /></td>
			<td><form:textarea class="content" path="noticeContent" readonly="true" /></td>
			<%-- <td>${notice.noticeContent}</td> --%>
		</tr>
	</table>

</form:form>
<br><br>
<div>

		<button type="submit" id="btnModify"><spring:message code="notice.modify" /></button>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="submit" id="btnList"><spring:message code="notice.list" /></button>
</div>

<script>
	$(document).ready(function() {

		var formObj = $("#notice");

		console.log(formObj);

		$("#btnModify").on("click", function() {
			var noticeNo = $("#noticeNo");
			var noticeNoVal = noticeNo.val();
			
			self.location = "modify?noticeNo=" + noticeNoVal;
		});

		$("#btnList").on("click", function() {
			self.location = "list";
		});

	});
</script>