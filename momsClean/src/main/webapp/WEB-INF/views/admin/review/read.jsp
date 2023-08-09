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
	
	.no,.grade,.content{
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
	
	#no,#grade,#content{
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
<h2><spring:message code="review.header.read" /></h2>
<br>
<form:form modelAttribute="review">
	
	<input type="hidden" name="page" value="${pgrq.page}"> 
	<input type="hidden" name="sizePerPage" value="${pgrq.sizePerPage}">	

	<table border="1" id="read">
		<tr>
			<td id="no"><spring:message code="review.no" /></td>
			<td><form:input class="no" path="reviewNo" readonly="true" /></td>
		</tr>
		<tr>
			<td id="grade"><spring:message code="review.grade" /></td>
			<td><form:input class="grade" path="reviewGrade" readonly="true" /></td>
		</tr>
		<tr>
			<td id="content"><spring:message code="review.content" /></td>
			<td><form:textarea class="content" path="reviewContent" readonly="true" /></td>
		</tr>
	</table>

</form:form>
<br><br>
<div>
		<button type="submit" id="btnList"><spring:message code="review.list" /></button>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="submit" id="btnRemove"><spring:message code="review.remove" /></button>
</div>

<script>
	$(document).ready(function() {

		var formObj = $("#review");

		console.log(formObj);

		$("#btnList").on("click", function() {
			self.location = "list";
		});
		
		$("#btnRemove").on("click", function() {
			formObj.attr("action", "remove");
			formObj.submit();
		
		});

	});
</script>