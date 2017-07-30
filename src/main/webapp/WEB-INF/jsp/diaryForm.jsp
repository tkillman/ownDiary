<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css" type="text/css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.8.8/i18n/jquery.ui.datepicker-ko.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="controlName" value="diary"/>




<script type="text/javascript">

$(function(){
	
	//1. 데이트 피커 띄우기
	$('#date1').datepicker();
	
	
	
	
})


function diarySave(){
	
	var myForm = document.diaryForm;
	console.log($('#date1').val());
	$('#daystr').val($('#date1').val());
	myForm.action="/diary/${controlName}Save.do";
	
	
	myForm.submit();
}


function serachReqDay(){
	var reqDay = $('#date1').val();
	
	$('input[name=reqDay]').val(reqDay);
	console.log(reqDay)
	var myForm = document.diaryForm2;
	myForm.action="/diary/diaryForm.do";
	
	myForm.submit();
	
}

function diaryUpdate(){
	var myForm = document.diaryForm2;
	myForm.action="/diary/diaryUpdate.do";
	
	myForm.submit();
}

</script>

</head>
<body>

${reqDiaryVo.daystr}

<div style="float: left; margin: 50px;">  
<span id="date1"></span><br>
<input type="button" value="다이어리 조회" onclick="serachReqDay();"/>
</div>


<form name="goalForm" action="/diary/goalUpdate.do" method="post">
<input type="hidden" name="seq_no" value="1">
<div >
장기 목표 :<textarea rows="10" cols="50" name="longGoal">${goalVo.longGoal}</textarea>
</div>

<div>
단기 목표 :<textarea rows="15" cols="50" name="shortGoal">${goalVo.shortGoal}</textarea>
</div>
<input type="submit" value="목표 저장"/>
</form>



<form name="diaryForm" action="" method="post">
<input type="hidden" name="daystr" id="daystr" value="${todayDiaryVo.daystr}"/>
<div style="clear: left;float: left;">
오늘의 한 일 : <textarea rows="15" cols="50" name="diaryetc">${todayDiaryVo.diaryetc}</textarea><br/><br/>
<input type="button" value="다이어리 저장" onclick="diarySave();"/><br/><br/>
</div>


</form>


<form name="diaryForm2" action="" method="post">
<input type="hidden" name="reqDay" id="reqDay" value="${reqDiaryVo.daystr}"/>
<div style="float: left;">
조회 날짜에 한 일 : <textarea rows="15" cols="50" name="reqDiaryetc">${reqDiaryVo.diaryetc eq null ? '조회내용 없음': reqDiaryVo.diaryetc}</textarea><br/><br/>
<input type="button" value="다이어리 수정" onclick="diaryUpdate();"/>
</div>
</form>


</body>
</html>