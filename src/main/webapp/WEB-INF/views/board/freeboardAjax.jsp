<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <input type="hidden" name="board_no" value="${bulletinList.board_no }"> --%>
<c:forEach items="${bulletinList }" var="bulletin">
	<c:choose>
		<c:when test="${bulletin.bulletin_del_check  != 'del'}">
			<tr class='bulletinTr' data-bulletin_no='${bulletin.bulletin_no}'>
				<c:if test="${bulletin.group_no == '2' }">
					<td>&nbsp;&nbsp;답글</td>
				</c:if>
				<c:if test="${bulletin.group_no == '3' }">
					<td>&nbsp;&nbsp;&nbsp;&nbsp;답글</td>
				</c:if>
				<td>${bulletin.bulletin_no }</td>
				<td>${bulletin.bulletin_title}</td>
				<td>${bulletin.mem_id }</td>
				<td><fmt:formatDate value="${bulletin.reg_dt}"
						pattern="yyyy-MM-dd hh:MM:ss" /></td>
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
				<td>삭제된 글 입니다.</td>
			</tr>
		</c:otherwise>
	</c:choose>
</c:forEach>
==============seperator===================
<c:set var="lastPage" value="${Integer(bulletinCnt / pageSize + (bulletinCnt % pageSize > 0 ? 1 : 0))}"/>
  					<c:choose>
                        <c:when test="${page == 1 }">
                           <li class="disabled"><a aria-label="Previous"> <span
                                 aria-hidden="true">&laquo;</span>
                           </a></li>
                        </c:when>
                        <c:otherwise>
                           <li><a
                              href="javascript:bulletinPageListHtml(1)"
                              aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                           </a></li>
                        </c:otherwise>
                     </c:choose>

                     <c:forEach begin="1" end="${lastPage }" var="i">
                        <c:set var="active" value="" />
                        <c:if test="${i == page }">
                           <c:set var="active" value="active" />
                        </c:if>

                        <li class="${active }"><a
                           href="javascript:bulletinPageListHtml(${i})">${i}</a>
                        </li>
                     </c:forEach>

                     <c:choose>
                        <c:when test="${page ==lastPage}">
                           <li class="disabled">
                           		<a aria-label="Next"> 
                           <span aria-hidden="true">&raquo;</span>
                         		 </a>
                           </li>
                        </c:when>
                        <c:otherwise>
                           <li><a
                              href="javascript:bulletinPageListHtml(${lastPage});"
                              aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                           </a></li>
                        </c:otherwise>
                     </c:choose>



