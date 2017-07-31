<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<c:set var="newLine" value="0"/>
<c:set var="vo" value="${diaryVo}"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="0" cellspacing="1" cellpadding="1" bgcolor="#FFFFFF">
<THEAD>
<TR bgcolor="#CECECE">
	<TD width='100px'>
	<DIV align="center"><font color="red">일</font></DIV>
	</TD>
	<TD width='100px'>
	<DIV align="center">월</DIV>
	</TD>
	<TD width='100px'>
	<DIV align="center">화</DIV>
	</TD>
	<TD width='100px'>
	<DIV align="center">수</DIV>
	</TD>
	<TD width='100px'>
	<DIV align="center">목</DIV>
	</TD>
	<TD width='100px'>
	<DIV align="center">금</DIV>
	</TD>
	<TD width='100px'>
	<DIV align="center"><font color="#529dbc">토</font></DIV>
	</TD>
</TR>
</THEAD>
<TBODY>
<!-- 칸 만드는 처음 tr -->
<TR>
<c:forEach begin="1" end="${vo.start - 1}">
<td>&nbsp;</td>
<c:set var="newLine" value="${newLine+1}"></c:set>
</c:forEach>

<c:forEach begin="1" end="${vo.endDay}">
<td></td>
<c:set var="newLine" value="${newLine+1}"></c:set>

<c:choose>
<c:when test="${newLine == 7}">
<c:set var="newLine" value="0"></c:set>

</TR>
<TR>
</c:when>
<c:otherwise>

</c:otherwise>
</c:choose>
</c:forEach>
</TR>








</TBODY>
</table>






</body>
</html>