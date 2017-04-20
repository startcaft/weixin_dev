<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${ pageContext.request.contextPath }"></c:set>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<link rel="stylesheet" type="text/css"
	href="${ context }/static/weui/dist/style/weui.min.css" />
<title>git具体命令的详细说明</title>
</head>
<body>
	<div class="page">
		<c:choose>
			<c:when test="${ !empty requestScope.detail }">
				<article class="weui_article">
					<section>
						<h3 class="title">${ requestScope.detail.commandName }命令介绍</h3>
						<section>
							<p>
								${ requestScope.detail.commandDesc }
							</p>
						</section>
						<section>
							<h4>${ requestScope.detail.content }</h4>
							<p>
								${ requestScope.detail.desc }
							</p>
						</section>
					</section>
				</article>
			</c:when>
			<c:otherwise>
				<p>没有任何数据</p>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>