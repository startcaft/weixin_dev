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
		<title>git常用命令的使用场景列表</title>
		<style type="text/css">
			.command{
				font-size: 11pt;
			}
		</style>
	</head>
	<body ontouchstart>
		<div class="page">
			<div class="page__bd">
				<div class="weui-cells__title">命令git checkout使用场景</div>
				<div class="weui-cells">
					<a class="weui-cell weui-cell_access" href="${ context }/git/detail/1">
						<div class="weui-cell-hd">
							<img src="${ context }/static/images/icon/git.png" alt="icon" style="width:20px;margin-right:5px;display:block">
						</div>
						<div class="weui-cell__bd">
							<p class="command">git checkout branch</p>
							<p class="command">检出分支</p>
						</div>
						<div class="weui-cell__ft">
							详情
						</div>
					</a>
					<a class="weui-cell weui-cell_access" href="${ context }/git/detail/2">
						<div class="weui-cell-hd">
							<img src="${ context }/static/images/icon/git.png" alt="icon" style="width:20px;margin-right:5px;display:block">
						</div>
						<div class="weui-cell__bd">
							<p class="command">git checkout HEAD</p>
							<p class="command">汇总显示差异</p>
						</div>
						<div class="weui-cell__ft">
							详情
						</div>
					</a>
					<a class="weui-cell weui-cell_access" href="${ context }/git/detail/3">
						<div class="weui-cell-hd">
							<img src="${ context }/static/images/icon/git.png" alt="icon" style="width:20px;margin-right:5px;display:block">
						</div>
						<div class="weui-cell__bd">
							<p class="command">git checkout -- file</p>
							<p class="command">获取暂存区文件并覆盖工作区的</p>
						</div>
						<div class="weui-cell__ft">
							详情
						</div>
					</a>
					<a class="weui-cell weui-cell_access" href="${ context }/git/detail/4">
						<div class="weui-cell-hd">
							<img src="${ context }/static/images/icon/git.png" alt="icon" style="width:20px;margin-right:5px;display:block">
						</div>
						<div class="weui-cell__bd">
							<p class="command">git checkout branch -- file</p>
							<p class="command">获取分支文件并覆盖工作区的</p>
						</div>
						<div class="weui-cell__ft">
							详情
						</div>
					</a>
					<a class="weui-cell weui-cell_access" href="${ context }/git/detail/5">
						<div class="weui-cell-hd">
							<img src="${ context }/static/images/icon/git.png" alt="icon" style="width:20px;margin-right:5px;display:block">
						</div>
						<div class="weui-cell__bd">
							<p class="command">git checkout -b branch</p>
							<p class="command">创建分支并切换到该分支</p>
						</div>
						<div class="weui-cell__ft">
							详情
						</div>
					</a>
					<a class="weui-cell weui-cell_access" href="${ context }/git/detail/6">
						<div class="weui-cell-hd">
							<img src="${ context }/static/images/icon/git.png" alt="icon" style="width:20px;margin-right:5px;display:block">
						</div>
						<div class="weui-cell__bd">
							<p class="command">git chekcout -b branch rbeanch</p>
							<p class="command">在fetch基础上创建分支并切换到该分支</p>
						</div>
						<div class="weui-cell__ft">
							详情
						</div>
					</a>
					<a class="weui-cell weui-cell_access" href="${ context }/git/detail/6">
						<div class="weui-cell-hd">
							<img src="${ context }/static/images/icon/git.png" alt="icon" style="width:20px;margin-right:5px;display:block">
						</div>
						<div class="weui-cell__bd">
							<p class="command">git checkout .||git checkout -- .</p>
							<p class="command">危险命令</p>
						</div>
						<div class="weui-cell__ft">
							详情
						</div>
					</a>
				</div>
			</div>
		</div>
	</body>
</html>