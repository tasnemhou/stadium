<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
 	form {
 		width:300px; 
 		border:1px solid #ccc; 
 		margin:50px auto;
/*  		margin:150px auto; */
 	} 
 	form h2 {
 		text-align: center;
 		margin:0;
 		padding: 5px;
 		border: 1px solid #ccc;
 	}
 	form p {
 		text-align:center;
 		margin: 0;
 		padding: 20px;
 		border: 1px solid #ccc;
 	}
 	form div {
 		text-align: center;
 		margin: 0;
 		padding: 10px;
 		border: 1px solid #ccc;
 	}
 	.error_msg {
 		border: 1px solid red;
 		color: red;
 	}
</style>
</head>
<body>
<body>
	
		<form action="login.do" method="post" onsubmit="return check_name_pwd();" >
			<h2 id="welcome">登陆</h2>
				<p> 
					用户名：<input type="text" id="user_name" name="username"  placeholder="请输入">
				</p>
				<p>
					密&nbsp; &nbsp;码：<input type="password" id="pwd" name="pwd" placeholder="请输入">
				</p>
			<div>
					<input  type="submit" id="commit" value="提交" onclick="javascript:{this.disabled=true}">
			</div>
		</form>
		
	</body>
	
</body>
</html>