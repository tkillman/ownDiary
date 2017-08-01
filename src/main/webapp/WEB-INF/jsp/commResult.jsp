<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>

<c:if test="${not empty resultMsg}">
<script type="text/javascript">
alert('${resultMsg}')
</script>
</c:if>

<c:choose>
<c:when test="${moveType eq 'back'}">
<script type="text/javascript">
history.back();
</script>
</c:when>
<c:when test="${moveType eq 'replace'}">
<script type="text/javascript">
location.href='${returnUrl}';
</script>
</c:when>
</c:choose>

</body>
</html>