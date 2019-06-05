<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>登陆</title>
	<script type="text/javascript" src="../framework/jquery/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="../framework/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="../framework/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../framework/select2/select2.min.js"></script>
	
	<link rel="stylesheet" href="../framework/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css" type="text/css" />
	<link rel="stylesheet" href="../framework/bootstrap-3.3.7/dist/css/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="../framework/select2/select2.min.css" type="text/css" />
	
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
		 function subBtn() {
			 var userNm = $("#userNm").val();
 			 var pwd = $("#pwd").val();
 			 $.ajax({
	 				url:"login_main.do",
	 				type:"post",
	 				data:{"userName":userNm,"pwd":pwd},
	 				dataType:"json",
	 				success:function(data){
						if(data.user=="0") {
		 					window.location.href="../jsp/customer.jsp";							
						}else if(data.user=="1") {
							alert("输入错误，请重新输入！");
						}
	 				},
	 				error:function(){
	 					alert("error!!!")
	 				}
 			})
		 }
	</script>
	
</head>
<body>
	<form action="login_main.do" method="post">
		<div class="form-group form-inline">
			<label class="control-label">用户名：</label>
			<input id="userNm" class="form-control" name="userName"/>
		</div>
		<div class="form-group form-inline">
			<label class=" control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
			<input id="pwd" class="form-control" type="password" name="pwd">
		</div>
		<div style="text-align:center;padding-top:10px">
			<a class="btn btn-primary" onclick="subBtn();">提交</a>
			<a class="btn btn-default" href="./regist.jsp">注册</a>
			<a class="btn btn-default" href="./menu.jsp">菜单</a>
			<a class="btn btn-default" href="../test/main_page_test.jsp">测试页 </a>
		</div>
	</form>
</body>
</html>