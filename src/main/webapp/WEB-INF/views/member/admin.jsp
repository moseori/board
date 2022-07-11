<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
<h1> 관리자 페이지</h1>

<p>principal : <sec:authentication property="principal"/> </p>
<p>MemberVO : <sec:authentication property="principal.member"/> </p>
<p>사용자이름 : <sec:authentication property="principal.member.userName"/> </p>
<p>사용자아이디 : <sec:authentication property="principal.username"/> </p>
<p>사용자 권한 리스트 : <sec:authentication property="principal.member.authList"/> </p>

	<h2>관리자 로그아웃</h2>
	<form action="${contextPath}/customLogout" method="post">
		<button class="btn btn-primary">로그아웃</button>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>
