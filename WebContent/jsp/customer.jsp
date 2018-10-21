<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>客户信息登陆</title>

 	<script type="text/javascript" src="../framework/jquery/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="../framework/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="../framework/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../framework/select2/select2.min.js"></script>
	
	<link rel="stylesheet" href="../framework/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css" type="text/css" />
	<link rel="stylesheet" href="../framework/bootstrap-3.3.7/dist/css/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="../framework/select2/select2.min.css" type="text/css" />
 
 	<style type="text/css">
 		form {
    		margin:150px auto;
    		width:300px;
    	}
 	</style>
 	<script type="text/javascript">
 		function submit_btn() {
 			var phone = $("#phone").val();
 			var pwd = $("#pwd").val();
 			alert(phone);
 			$.ajax({
 				url:"cus_login.do",
 				type:"post",
 				data:{"phone":phone,"pwd":pwd},
 				dataType:"json",
 				success:function(data){
 					alert(data.phone);
 					window.location.href="../jsp/main_page.jsp";
 				},
 				error:function(){
 					alert("error!!!")
 				}
 			})
 		}
 	</script>
</head>
<body>
	<form action="cus_login.do">
		<div style="text-align:center">
			<div class="form-group form-inline">
				<label class="control-label">手机号:</label>
				<input id="phone" class="form-control" type="text" >
			</div>
			<div class="form-group form-inline">
				<label class="control-label">密&nbsp;&nbsp;码：</label>
				<input id="pwd" class="form-control" type="password">
			</div>
		</div>
		<div style="text-align:center;padding-top:10px">
<!-- 			<input type="submit" class="btn btn-primary"  value="提交"> -->
			<input type="button" class="btn btn-primary" onclick="submit_btn()" value="提交">
			<input type="button" class="btn btn-default" value="返回">
			<a href="./regist_customer.jsp" class="btn btn-default">客户注册</a>
		</div>
	</form>
</body>
</html>