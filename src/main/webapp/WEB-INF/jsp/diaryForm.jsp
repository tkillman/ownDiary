<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<c:set var="newLine" value="0"/>
<c:set var="vo" value="${diaryVo}"/>
<jsp:useBean id="toDay" class="java.util.Date" />
<fmt:formatDate value="${toDay}" pattern="yyyy" var="todayYear"/>
<fmt:formatDate value="${toDay}" pattern="MM" var="todayMonth"/>

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

<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
function preMonth(){
	
	$('input[name=month]').val(${vo.month-1});
	document.calendarFrm.action="/ownDiary/diaryForm.do";
	document.calendarFrm.submit();
}

function nextMonth(){
	
	$('input[name=month]').val(${vo.month+1});
	document.calendarFrm.action="/ownDiary/diaryForm.do";
	document.calendarFrm.submit();
}

function frmSave(){

	document.calendarFrm.action="/ownDiary/diaryInsert.do";
	document.calendarFrm.submit();
}

</script>		
</head>
<body>
<form name="calendarFrm" id="calendarFrm" method="post">
<input type="hidden" name="year" value="${vo.year}"/>
<input type="hidden" name="month" value="${vo.month}"/>


<DIV id="content" style="width:712px;">

<table width="1408px;" border="0" cellspacing="1" cellpadding="1">
<tr>
	<td align ="right"> 
	
		<input type="button" id="todayBtn" href="/ownDiary/diaryForm.do?year=${todayYear}&month=${todayMonth - 1}" value="오늘" style="height: 50px; width: 90px;"/>
		<script type="text/javascript">
		$(function(){
			$('#todayBtn').on('click',function(){
				location.href=$(this).attr('href');
			}) 
		})
		</script>
		<input type="button" value="다이어리저장" onclick="frmSave();" style="height: 50px; width: 90px;"/>
	</td>

</tr>
</table> 
<!--날짜 네비게이션  -->
<table width="1408px;" border="0" cellspacing="1" cellpadding="1" id="KOO" bgcolor="#F3F9D7" style="border:1px solid #CED99C">

<tr>
<td height="60">

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="10">
		</td>
	</tr>
	
	<tr>
		<td align="center" >
			
			<a href="/ownDiary/diaryForm.do?year=${vo.year-1}&month=${vo.month}" target="_self">
				<b>&lt;&lt;</b><!-- 이전해 -->
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#;" onclick="${vo.month eq 0 ? 'alert(\'마지막달입니다.\')':'preMonth()'}">
				<b>&lt;</b><!-- 이전달 -->
				
			</a>
			
			&nbsp;&nbsp;
			${vo.year}년
			
			${vo.month+1}월
			&nbsp;&nbsp;
			
			<a href="#;" onclick="${vo.month eq 11 ? 'alert(\'마지막달입니다.\')':'nextMonth()'}" target="_self">
				<!-- 다음달 --><b>&gt;</b>
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/ownDiary/diaryForm.do?year=${vo.year+1}&month=${vo.month}" target="_self">
				<!-- 다음해 --><b>&gt;&gt;</b>
			</a>
			
			
		</td>
	</tr>
	</table>

</td>
</tr>
</table>
<br>
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
<!--첫주의 시작 요일이 나올때까지 공백 td를 만들어준다.-->
<TR>
<c:forEach begin="1" end="${vo.start - 1}">
<td>&nbsp;</td>
<c:set var="newLine" value="${newLine+1}"/>
</c:forEach>

<!--시작 요일부터 1일의 내용을 만들어준다.-->
<c:forEach begin="1" end="${vo.endDay}" varStatus="i"> 
<TD valign='top' align='left' height='92px' nowrap="nowrap">${i.count}<br/>
<input type="hidden" name="dbVoList[${i.count-1}].idx" value="${i.count}"/>
<textarea rows="5" cols="25" name="dbVoList[${i.count-1}].etc" maxlength="1000">${vo.dbVoList.get(i.count-1).etc}</textarea>
</TD>  
<c:set var="newLine" value="${newLine+1}"/>



<!-- newLine은 열의 숫자이다. 0이 첫번째 줄,1이 두번째 줄, 마지막줄이 6이다. newLine이 7이면 마지막줄을 넘었기 때문에 tr을 닫고 새로운  tr을 열어준다. -->
<c:if test="${newLine eq 7}">
<c:set var="newLine" value="0"/>
</TR>
<TR>
</c:if>

</c:forEach> <!-- 1일부터 마지막일까지의 내용을 모두 만들었다. -->

<!-- 마지막주의 빈 공간을 채워준다. -->
<c:forEach begin="${newLine}" end="6">
<TD>&nbsp;</TD>
</c:forEach>
</TR>




</TBODY>
</table>
</DIV>

</form>
</body>
</html>