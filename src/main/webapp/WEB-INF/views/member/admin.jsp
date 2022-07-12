<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<h1>관리자 페이지</h1>
	<div>
		<p> principal : <sec:authentication property="principal" /> </p>
		<p> MemberVO : <sec:authentication property="principal.memberVO" var="member" /> </p>
		<p> 사용자이름 : <sec:authentication property="principal.memberVO.userName" /> </p>
		<p> 사용자아이디 : <sec:authentication property="principal.memberVO.username" /> </p>
		<p> 사용자 권한 리스트 : <sec:authentication property="principal.memberVO.authList" /> </p>
	</div>
	<a href="${contextPath}/customLogout">로그아웃하로 가자</a>
	<div>
		이거 되나?<br> ${member}
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>
