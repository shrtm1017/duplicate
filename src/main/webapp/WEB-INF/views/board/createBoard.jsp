<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="createfrm" action="/board/makeMenu" method="post">
		<div align="center">
			게시판이름<input type="text" name="board_title" /> <select
				name="board_check">
				<option>사용</option>
				<option>미사용</option>
			</select>
			<button type="button" id="createboard">생성</button>
		</div>
	</form>
	<c:forEach items="${boardAllList}" var="list">
		<div align="center">
			<form id="updatefrm" action="updateMenu" method="post">
				게시판이름 :<input type="text" name="board_title" value="${list.board_title}"> 
				<select name="board_check">
					<option <c:if test="${list.board_check=='사용'}">selected</c:if>>사용</option>
					<option <c:if test="${list.board_check=='미사용'}">selected</c:if>>미사용</option>
				</select> <input type="hidden" name="board_no" value="${list.board_no}">
				<button type="button" class="updateBoard">수정</button>
			</form>
		</div>

		<br>
	</c:forEach>
</body>
<script>
	$("#createboard").click(function() {
		$("#createfrm").submit();
	})
	$(".updateBoard").click(function() {
		$(this).parent("#updatefrm").submit();
// 		$("#updatefrm").submit();
	})
</script>
</html>