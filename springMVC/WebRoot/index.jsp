<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>

<title>乐拼网后台管理</title>
</head>
<body>
	<script type="text/javascript">
		window.location.href = "${ctx}/default/manager/index";
	</script>
</body>
</html>
