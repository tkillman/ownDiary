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
<style TYPE="text/css">
		body {
		scrollbar-face-color: #F6F6F6;
		scrollbar-highlight-color: #bbbbbb;
		scrollbar-3dlight-color: #FFFFFF;
		scrollbar-shadow-color: #bbbbbb;
		scrollbar-darkshadow-color: #FFFFFF;
		scrollbar-track-color: #FFFFFF;
		scrollbar-arrow-color: #bbbbbb;
		margin-left:"0px"; margin-right:"0px"; margin-top:"0px"; margin-bottom:"0px";
		}
		td {font-family: "돋움"; font-size: 9pt; color:#595959;}
		th {font-family: "돋움"; font-size: 9pt; color:#000000;}
		select {font-family: "돋움"; font-size: 9pt; color:#595959;}
		.divDotText {
		overflow:hidden;
		text-overflow:ellipsis;
		}
A:link { font-size:9pt; font-family:"돋움";color:#000000; text-decoration:none; }
A:visited { font-size:9pt; font-family:"돋움";color:#000000; text-decoration:none; }
A:active { font-size:9pt; font-family:"돋움";color:red; text-decoration:none; }
A:hover { font-size:9pt; font-family:"돋움";color:red;text-decoration:none;}
	</style>
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
<c:set var="newLine" value="${newLine+1}"/>
</c:forEach>

<c:forEach begin="1" end="${vo.endDay}" varStatus="i">
<TD valign='top' align='left' height='92px' nowrap="nowrap">${i.count}<br/>
<textarea rows="5" cols="25"></textarea>
</TD>  
<c:set var="newLine" value="${newLine+1}"/>




<c:if test="${newLine eq 7}">
<c:set var="newLine" value="0"/>
</TR>
<TR>
</c:if>

</c:forEach>

<c:forEach begin="${newLine}" end="6">
<TD>&nbsp;</TD>
</c:forEach>
</TR>








</TBODY>
</table>






</body>
</html>