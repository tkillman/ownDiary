<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="toDay" class="java.util.Date" />
<fmt:formatDate value="${toDay}" pattern="yyyy-MM-dd" var="useToday"/>

<html>
<title></title>
<script type="text/javascript">


</script>
<body>
<h2>Hello World!</h2>



<form name="frm" action="diary/diaryForm.do" method="post">
<input type="submit" value="다이어리 이동 "/>
</form>

<a href="calendarForm.do"> 달력만들기</a>

</body>
</html>
