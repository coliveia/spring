<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="titulo" required="true" %>
<%@ attribute name="bodyClass" required="false" %>

<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>${titulo} - Indra Store</title>
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
		<meta name="viewport" content="width=device-width" />
		<style type="text/css">
			.navbar-header button{
				color: #fff
			}
			.fullscreen {
				width:100%;
			}
			main {
				padding-top:50px;
				padding-bottom: 90px;
			}
			footer {
				background:#333;
				color:#fff;
				padding:20px 0;
				text-align:center;
				height: 80px;
			}
		</style>
	</head>
	<body class="${bodyClass}">
		<%@ include file="/WEB-INF/jsp/cabecalho.jsp" %>

		<main>
			<jsp:doBody />
		</main>

		<%@include file="/WEB-INF/jsp/rodape.jsp" %>

		<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.0.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
