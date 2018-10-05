<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>登陆</title>
	<script type="text/javascript" src="jquery-3.3.1.js"></script>
	<script type="text/javascript" src="bootstrap/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="select2/select2.min.js"></script>
	
	<link rel="stylesheet" href="bootstrap/bootstrap-datetimepicker.min.css" type="text/css" />
	<link rel="stylesheet" href="bootstrap/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="select2/select2.min.css" type="text/css" />
	
	<style type="text/css">
		div {
/* 			text-align:center; */
		}
		form {
    		margin:150px auto;
    		width:300px;
    	}
	</style>
	
	<script type="text/javascript">
		 function regist() {
			 
		 }
	</script>
	
</head>
<body>
	<form action="login_main.do">
		<div class="form-group form-inline">
			<label class="control-label">用户名：</label>
			<input class="form-control" name="userName"/>
		</div>
		<div class="form-group form-inline">
			<label class=" control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
			<input class="form-control" type="password" name="pwd">
		</div>
		<div style="text-align:center;padding-top:10px">
			<input type="submit" class="btn btn-primary" value="提交 ">
			<a class="btn btn-default" href="regist.jsp">注册</a>
			<a class="btn btn-default" href="menu.jsp">菜单</a>
			<a class="btn btn-default" href="main_page_test.jsp">测试页 </a>
		</div>
	</form>
</body>
</html>