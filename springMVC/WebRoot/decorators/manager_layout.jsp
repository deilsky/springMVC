<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<!-- <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
<link rel="shortcut icon" href="favicon.ico"> -->
<link href="${ctx}/plugins/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/plugins/css/animate.min.css" rel="stylesheet">
<link href="${ctx}/plugins/css/style.min.css" rel="stylesheet">
<!-- <link href="https://cdn.staticfile.org/font-awesome/4.4.0/css/font-awesome.css?v=4.7.0" rel="stylesheet"> -->
<link rel="stylesheet" href="https://use.fontawesome.com/2ae036ae3e.css">
<script src="${ctx}/plugins/js/jquery.min.js"></script>
<script src="${ctx}/plugins/js/bootstrap.min.js"></script>
<title><decorator:title default="H+拼 后台主题UI框架" /></title>
<decorator:head />
</head>
<body>
	<decorator:body />
</body>
</html>