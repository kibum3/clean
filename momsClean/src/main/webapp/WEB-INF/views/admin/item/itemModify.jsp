<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>

	h2{
		font-size:30px;
		color:#6AAAFF;
		margin:0;
	}
	
	#modify{
		border-left:0px;
		border-right:0px;
		border-collapse : collapse;
	}

	td{
	background-color:#FAFFFF;
	font-size:16px;
	font-family:'Malgun Gothic';
	}

	button{
	width:100px;
	font-size:18px;
	border-color:#6AAAFF;
	box-shadow: none;
	background-color:white;
	}
	
	.no,.name,.price,.img,.thumb,.imgFile,.thumbFile{
	 border:none;
	 font-size:18px;
	
	}
	
	#no,#name,#price,#img,#thumb,#imgFile,#thumbFile{
	background-color:#6AAAFF;
	color:white;
	text-align: center;
	}

	input[type="file"]::-webkit-file-upload-button {
  border-color: #6AAAFF; 
  background-color:white;
}
	

</style>
<br>
<h2>
	<spring:message code="item.itemModify" />
</h2>
<br>
<form:form modelAttribute="item" action="itemModify"
	enctype="multipart/form-data">

	<form:hidden path="iNo" />

	<table id="modify" border="1">
		<tr>
			<td id="no"><spring:message code="item.itemNo" /></td>
			<td><form:input class="no" path="itemNo" /></td>
		</tr>
		<tr>
			<td id="name"><spring:message code="item.itemName" /></td>
			<td><form:input class="name" path="itemName" /></td>
		</tr>
		<tr>
			<td id="price"><spring:message code="item.itemPrice" /></td>
			<td><form:input class="price" path="itemPrice" /></td>
		</tr>
		<tr>
			<td id="img"><spring:message code="item.img" /></td>
			<td><img class="img" src="picture?itemNo=${item.itemNo}" width="210"></td>
		</tr>
		<tr>
			<td id="thumb"><spring:message code="item.img.thumb" /></td>
			<td><img class="thumb" src="thumb?itemNo=${item.itemNo}" width="210"></td>
		</tr>
		<tr>
			<td id="imgFile"><spring:message code="item.imgFile" /></td>
			<td><input class="imgFile" type="file" name="picture" /></td>
		</tr>
		<tr>
			<td id="thumbFile"><spring:message code="item.img.thumbFile" /></td>
			<td><input class="thumbFile" type="file" name="thumb" /></td>
		</tr>
	</table>
</form:form>
<br><br>
<div>
	<button type="submit" id="btnModify">
		<spring:message code="item.edit" />
	</button>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="submit" id="btnCancel">
		<spring:message code="item.cancel" />
	</button>
</div>
<script>
	$(document).ready(function() {
		var formObj = $("#item");

		$("#btnModify").on("click", function() {
			// 폼 전송 전에 숫자 입력 여부와 빈 칸 여부를 확인합니다.
			if (!validateInput()) {
				return false; // 제출 취소
			}

			formObj.submit();
		});

		$("#btnCancel").on("click", function() {
			self.location = "list";
		});
	});

	function validateInput() {
		var itemNoInput = $("input[name='itemNo']");
		var inputValue = itemNoInput.val();

		var itemNameInput = $("input[name='itemName']");
		var inputValue2 = itemNameInput.val();

		var itemPriceInput = $("input[name='itemPrice']");
		var inputValue3 = itemPriceInput.val();

		// 빈 칸인지 확인합니다.
		if (!inputValue.trim()) {
			alert("상품번호를 입력하지 않았습니다.");
			return false;
		}
		if (!/^\d*$/.test(inputValue)) {
			alert("상품번호는 숫자만 입력 가능합니다.");
			return false;
		}

		if (!inputValue2.trim()) {
			alert("상품명을 입력하지 않았습니다.");
			return false;
		}
		if (!inputValue3.trim()) {
			alert("가격을 입력하지 않았습니다.");
			return false;
		}
		if (!/^\d*$/.test(inputValue3)) {
			alert("가격은 숫자만 입력 가능합니다.");
			return false;
		}

		return true;
	}
</script>