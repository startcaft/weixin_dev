<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${ pageContext.request.contextPath }"></c:set>
<!DOCTYPE>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
		<link rel="stylesheet" type="text/css" href="${ context }/static/weui/dist/style/weui.min.css" />
		<title>git具体命令的详细说明</title>
	</head>
	<body>
		<div class="page">
			<div class="page__bd">
				<article class="weui-article">
					<h1>git checkout命令使用场景</h1>
					<section>
						<h2 class="title">检出指定分支</h2>
						<section>
							<h3><span style="color: red">git checkout branchname</span></h3>
							<p>
								更新HEAD指针指向branchname，以及使用branchname分支的tree更新暂存区和工作区。
							</p>
							<p>
								<img src="http://images.cnblogs.com/cnblogs_com/startcaft/984400/o_timg.jpg" alt="">
							</p>
						</section>
					</section>
				</article>
			</div>
		</div>
	</body>
</html>