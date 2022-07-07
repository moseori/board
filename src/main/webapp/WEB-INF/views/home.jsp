<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>
<div class="container">
	<h3>HOME</h3>
	<p><a href="${contextPath}/security/all">모든 방문자 허용</a></p>
	<p><a href="${contextPath}/security/member">회원등급 이상</a></p>
	<p><a href="${contextPath}/security/admin">관리자 전용</a></p>
</div>
<%@ include file="layout/footer.jsp"%>
