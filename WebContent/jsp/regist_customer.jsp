<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>客户注册</title>
	<script type="text/javascript" src="../framework/jquery/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="../framework/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="../framework/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../framework/select2/select2.min.js"></script>
	<script type="text/javascript" src="../framework/bootstrap-table/dist/bootstrap-table.js"></script>
	<script type="text/javascript" src="../framework/bootstrap-table/dist/locale/bootstrap-table-zh-CN.js"></script>
		
	<link rel="stylesheet" href="../framework/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css" type="text/css" />
	<link rel="stylesheet" href="../framework/bootstrap-3.3.7/dist/css/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="../framework/select2/select2.min.css" type="text/css" />
	<link rel="stylesheet" href="../framework/bootstrap-table/dist/bootstrap-table.min.css">
	<link rel="stylesheet" href="../framework/bootstrap-table/dist/bootstrap-table.css">
	
	
	<script type="text/javascript">
		 var customerType = "";
	 	var customerType_html = "<option></option>";
		$(function() {
			//初始化日期组件
		  init_date();
		    //初始化选择框选项
		    $(".customerType").each(function() {
		    	$(this).select({tags:true})
		    });
		    //向后台发请求 查询相关数据
// 		    getDic();
		});
		
		//初始化日期组件
		function init_date() {
			  //注册日期
			  $("#registDt").datetimepicker({
			        format: "yyyy-mm-dd",
			        autoclose: true,
			        todayBtn: true,
			        minView:'month',
			        pickerPosition: "bottom-left",
			        language:'zh-CN'
			    });
				//截止日期
			    $("#endDt").datetimepicker({
			        format: "yyyy-mm-dd",
			        autoclose: true,
			        todayBtn: true,
			        minView:'month',
			        pickerPosition: "bottom-left",
			        language:'zh-CN'
			    });
		}
		//查询数据字典
		function getDic() {
			 $.ajax({
		            type:"post",
		            dataType:'json',
		            url:"getDic.do",
//	 	            data: "",
		            success:function(data){
		            	alert("sssssssssssss");
//	 	            	alert(data);
//	 	                alert(data.dictionary);
		           /*      if(data!=null) {
		                	for(var i=0;i<data.length;i++) {
		                		if("customerType"==data[i]["flag"]) {
		                			customerType.push({"id":data[i]["id"],"name":data[i]["name"]});
		                			customerType_html = '<option value="'+data[i]["id"]+'">'+data[i]["name"]+'</option>';
		                		}
		                	}
		                } */
		            },
		            error:function(msg){
		            	
		            }
		        })
			} 
		
		function submitBtn() {
			var param = {"name":$("#name").val(),
						 "sex":$("input[name='sex']:checked").val(),
						 "phone": $("#phone").val(),
						 "registDt":$("#registDt").val(),
			 			 "customerType":$("#customerType").val(),
			 			 "pwd":$("#pwd").val(),
			 			 "amount":$("#amount").val(),
			 			 "dealTimes":$("#dealTimes").val()
						};
			$.ajax({
				url:"cus_reg.re",
 				type:"post",
 				data:param,
 				dataType:"json",
 				success:function(data){
 					alert(data.isDone);
					if(data.isDone=="0") {
						alert("注册完成！");;	
					}else if(data.isDone=="1") {
						alert("注册失败！");
					}
 				},
 				error:function(){
 					alert("wwwwwwwwwww");
 					window.location.href="../jsp/error.jsp";
 				}
			}) 
		}
	</script>
</head>
<body>
	<div class="container">
		<!-- 基础信息开始 -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">
		   			<a class="collapsed" role="button" data-toggle="collapse" href="#collapseOne" data-parent="#accordion" aria-expanded="false" aria-controls="collapseOne"><span class="glyphicon glyphicon-th-list"></span>基础信息</a>
				</div>
	  		</div>
	  		<div id="collapseOne" class="panel-collapse collapse in">
	 			<div class="panel-body">
					<form action="cus_login.do" method="post">
						<div class="col-md-6 form-group">
							<div class="col-md-3 title">姓名:</div>
							<div class="col-md-9">
								<input id="name" class="form-control" type="text" >
							</div>
						</div>
					    <div class="col-md-6 form-group">
							<div class="col-md-3 title">性别：</div>
							<div class="col-md-9">
								<input type="radio" name="sex" value="0"> 男
								<input type="radio" name="sex" value="1"> 女
							</div>
						</div>
						<div style="clear:both;"></div>
					    <div class="col-md-6 form-group">
							<div class="col-md-3 title">电话：</div>
							<div class="col-md-9">
								<input id="phone" class="form-control" type="text" maxlength="11">
							</div>
						</div>
					    <div class="col-md-6 form-group">
							<div class="col-md-3 title">注册日期：</div>
							<div class="col-md-9">
								<div class="input-group date form-date">
									 <input id="registDt" class="form-control" type="text" /><span class="input-group-addon"><span class=" glyphicon glyphicon-calendar" ></span></span>
								</div>
							</div>
						</div>
						<div style="clear:both;"></div>
						<div class="col-md-6 form-group">
							<div class="col-md-3 title">会员类型：</div>
							<div class="col-md-9">
								<select id="customerType" class="form-control customerType">
									<option></option>
									<option value="0">年卡</option>
									<option value="1">月卡</option>
									<option value="2">次卡</option>
								</select>
							</div>
						</div>
						<div class="col-md-6 form-group">
							<div class="col-md-3 title">密码：</div>
							<div class="col-md-9">
								<input id="pwd" class="form-control" type="password">
							</div>
						</div>
					</form>
				</div>
	  		</div>
		</div>
		<!-- 基础信息结束 -->
		<!-- 充值信息开始-->
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">
		   			<a class="collapsed" role="button" data-toggle="collapse" href="#collapseTwo"><span class="glyphicon glyphicon-th-list"></span>交易信息</a>
				</div>
	  		</div>
	  		<div id="collapseTwo" class="panel-collapse collapse in">
	 			<div class="panel-body">
	 				<div class="col-md-6 form-group">
						<div class="col-md-3 title">充值金额：</div>
						<div class="col-md-9">
							<input id="amount" class="form-control" type="text">
						</div>
					</div>
	 				<!-- <div class="col-md-6 form-group">
						<div class="col-md-3 title">截止日期：</div>
						<div class="col-md-9 ">
							<div id="endDt" class="col-md-12 input-group date form-date">
								<input id="" class="form-control" type="text">
								<span class="input-group-addon">
									<span class=" glyphicon glyphicon-calendar" ></span>
								</span>
							</div>
						</div>
					</div> -->
	 				<div class="col-md-6 form-group">
						<div class="col-md-3 title">充值次数：</div>
						<div class="col-md-9">
							<div class="col-md-12 input-group">
								<input id="dealTimes" class="form-control" type="text">
								<span class="input-group-addon">次</span>
							</div>
						</div>
					</div>
	 			</div>
	 		</div>
		</div>
		<!-- 基础信息结束 -->
		
		<div style="text-align:center;padding-top:10px">
			<input class="btn btn-primary" onclick="submitBtn();" value="提交" />			
<!-- 			<a href="./customer.jsp" class="btn btn-default">返回</a>	 -->
			<a href="./customer.jsp" class="btn btn-default">返回</a>	
		</div>
	</div>
</body>
</html>