<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>菜单</title>
		<style type="text/css">
			body {
				background:#FCDFE2
			}
			#main_menu {
				list-style:none
			}
			.li {
				border-bottom:solid;
				border-bottom-width:0.5px;
				border-bottom-color:#fff;
				width:200px;
			}
			a:hover {
				color:orange;
			}
			.ul {
				list-style:none;
			}
			.a {
				height:30px;
				width:200px;
				padding-left:2px;
				display:block;
				background:#D02230;
				line-height:25px;
				border-left:solid;
				border-left-width:10px;
				border-left-color:#7C1B12;
				color:white;
				font-family:"微软雅黑"
			}
			.ul a {
				height:25px;
				width:190px;
				margin-left:2px;
				display:block;
				background:#F56071;
				border-left:solid;
				border-left-width:20px;
				border-left-color:#ac2918;
				border-bottom:solid;
				border-bottom-width:0.5px;
				border-bottom-color:#fff;
				color:white;
				font-family:"微软雅黑"
			}
			.ul a:hover {
				color:#FFCC00;
			}
		</style>
		<script type="text/javascript" src="jquery-3.3.1.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$(".ul").hide();
				$(".a").toggle(function() {
					$(this).siblings().show();
				},function() {
					$(this).siblings().hide();
				})
			})
		</script>
	</head>
	<body>
		<div>
			<ul id="main_menu">
				<li class="li">
					<a class="a">电影明星</a>
					<ul class="ul">
						<li><a>李连杰</a></li>
						<li><a>成龙</a></li>
						<li><a>周星驰</a></li>
						<li><a>金城武</a></li>
						<li><a>刘德华</a></li>
					</ul>
				</li>
				<li class="li">
					<a class="a">蓝球明星</a>
					<ul class="ul">
						<li><a>科比</a></li>
						<li><a>詹姆斯</a></li>
						<li><a>乔丹</a></li>
						<li><a>姚明</a></li>
						<li><a>易建联</a></li>
					</ul>
				</li>
				<li class="li">
					<a class="a">音乐明星</a>
					<ul class="ul">
						<li><a>李宇春</a></li>
						<li><a>毛不易</a></li>
						<li><a>李谷一</a></li>
						<li><a>张也</a></li>
						<li><a>谭晶</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</body>
</html>