<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>

	h2{
		font-size:30px;
		color:#6AAAFF;
		margin:0;
	}
	
	#register{
		border-left:0px;
		border-right:0px;
		 border-collapse : collapse;
		 width:700px;

	}
	
	th,td{
	font-family:'Malgun Gothic';
	font-size:18px;
	height:30px;
	}
	
	.title,.content{
	border:none;
	font-size:18px;
	padding-left: 11px;
	width: 500px
	}
	
	.content{
	height: 500px;
	font-family:'Malgun Gothic';
	font-size:18px;
	}
	
	#no,#title,#content{
	background-color:#6AAAFF;
	color:white;
	text-align: center;
	}

	button{
	border-color:#6AAAFF;
	font-size:20px;
	background-color:white;
	}


</style>

<br>
<h2><spring:message code="notice.header.register" /></h2>
<br><br>
<form:form modelAttribute="notice" action="register">
	<table border="1" id="register">
		<tr>
			<td id="title"><spring:message code="notice.title" /></td>
			<td><form:input class="title" path="noticeTitle" /></td>
		</tr>
		
		<tr>
			<td id="content"><spring:message code="notice.content" /></td>
			<td><form:textarea class="content" path="noticeContent" /></td>
		</tr>
	
	</table>
</form:form>
<br><br>
<div>

		<button type="submit" id="btnRegister"><spring:message code="notice.new" /></button>

	&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="submit" id="btnList"><spring:message code="notice.list" /></button>
</div>

<script>
	$(document).ready(function() {

		var formObj = $("#notice");

		$("#btnRegister").on("click", function() {
			// 폼 전송 전에 숫자 입력 여부와 빈 칸 여부를 확인합니다.
			if (!validateInput()) {
				return false; // 제출 취소
			}
			
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "/admin/notice/list";
		});

	});
	
	function validateInput() {
		var noticeTitleInput = $("input[name='noticeTitle']");
		var inputValue = noticeTitleInput.val();

		var noticeContentInput = $("textarea[name='noticeContent']");
		var inputValue2 = noticeContentInput.val();

		// 빈 칸인지 확인합니다.
		if (!inputValue.trim()) {
			alert("공지사항의 제목을 입력해주세요.");
			return false;
		}

		if (!inputValue2.trim()) {
			alert("공지사항의 내용을 입력해주세요.");
			return false;
		}
		

		return true;
	}
</script>
