<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-3 col-md-2 sidebar">
<ul class="nav nav-sidebar">
	<li><a href="<%=request.getContextPath()%>/board/makeMenu">게시판생성</a></li>
</ul>

<c:forEach items="${boardAllList}" var="list">
	<c:if test="${list.board_check == '사용'}">
		<ul class="nav nav-sidebar">
			<li><a href="<%=request.getContextPath()%>/bulletin/freeboardView?board_no=${list.board_no} ">${list.board_title}
			</a></li>
		</ul>
	</c:if>
</c:forEach>
</div>
