create sequence emp_seq start with 1000000000 ;

--用户信息表
  CREATE TABLE EMP_USER_INFO
   ("ID" 			ARCHAR2(18) NOT NULL, 
	"NAME" 			VARCHAR2(10), 
	"PHONE" 		VARCHAR2(11), 
	"PASSWORD" 		VARCHAR2(24), 
	"LEVER" 		CHAR(1), 
	"SEX" 			CHAR(1 BYTE)
   );
   comment on table emp_user_info 			is '用户信息表';
   comment on column emp_user_info.id 		is '自增主键';
   comment on column emp_user_info.lever 	is '用户级别：0-管理员 1-员工';
   comment on column emp_user_info.sex 		is '性别：0-男 1-女';
   
   --客户信息表
    CREATE TABLE "SYSTEM"."EMP_CUSTOMER_INFO" 
   ("ID" 		VARCHAR2(18 BYTE) NOT NULL, 
	"NAME" 		VARCHAR2(10 BYTE), 
	"PHONE" 	VARCHAR2(11 BYTE), 
	"PASSWORD" 	VARCHAR2(24),
	"SEX" 		CHAR(1 BYTE), 
	"ENDDT" 	VARCHAR2(14 BYTE), 
	"BALANCE" 	NUMBER(7),
     "TIMES"  	NUMBER(5),
	"REGISTDT" 	VARCHAR2(14 BYTE)
   );
   COMMENT ON TABLE "SYSTEM"."EMP_CUSTOMER_INFO"  				IS '客户信息表';
   COMMENT ON COLUMN "SYSTEM"."EMP_CUSTOMER_INFO"."ID" 			IS '自增主键';
   COMMENT ON COLUMN "SYSTEM"."EMP_CUSTOMER_INFO"."SEX" 		IS '性别：0-男 1-女';
   COMMENT ON COLUMN "SYSTEM"."EMP_CUSTOMER_INFO"."ENDDT" 		IS '到期日期';
   COMMENT ON COLUMN "SYSTEM"."EMP_CUSTOMER_INFO"."BALANCE" 	IS '剩余金额';
   COMMENT ON COLUMN "SYSTEM"."EMP_CUSTOMER_INFO"."TIMES" 		IS '剩余使用次数';
   COMMENT ON COLUMN "SYSTEM"."EMP_CUSTOMER_INFO"."REGISTDT" 	IS '注册日期';
   
   --客户交易信息记录表
    create table emp_pay_info (
     customerId 		varchar2(18) not null,
     customer 			varchar2(18),
     dealAmount 		number(10), 
     dealTimes  		number(5),
     kind 				char(1),
     customerType 		char(1),
     dealType 			char(1),
     dealDt 			varchar2(14)
   );
   comment on table emp_pay_info 					is '客户交易信息记录表';
   comment on column emp_pay_info.customerId 		is '用户Id';
   comment on column emp_pay_info.customer 			is '本次交易的使用人';
   comment on column emp_pay_info.dealAmount 		is '交易金额(使用金额或充值金额)';
   comment on column emp_pay_info.dealTimes 		is '交易次数(使用次数或充值次数)';
   comment on column emp_pay_info.kind 				is '交易类型 0-充值 1-消费 2-免费（优惠）';
   comment on column emp_pay_info.customerType 		is '客户类型  0-年卡会员 1-月卡会员 2-次卡会员 3-散客';
   comment on column emp_pay_info.dealType 			is '交易方式 0-现金 1-会员卡 2-免费（优惠）';
   comment on column emp_pay_info.dealDt			is '交易日期';
   
   --数据字典
  CREATE TABLE DICTIONARY
   ("ID" 		VARCHAR2(3), 
	"NAME" 		VARCHAR2(10), 
	"FLAG" 		VARCHAR2(10)
   );
   comment on table dictionary 			is '数据字典';
   comment on column dictionary.id 		is '数据值';
   comment on column dictionary.name 	is '数据名称';
   comment on column dictionary.flag 	is '数据标识种类';
   
 --菜单表
 create table emp_menu (
  node_id varchar2(10) primary key,
  node_name varchar2(10),
  node_showName varchar2(10),
  node_isHasSon char(1),
  node_parentId varchar2(100),
  node_url varchar2(256),
  node_isNewBlank char(1),
  node_creatTime varchar2(14)
);
comment on column emp_menu.node_id is '主键ID';
comment on column emp_menu.node_name is '菜单节点的名称';
comment on column emp_menu.node_showName is '菜单节点在前端显示的名称';
comment on column emp_menu.node_isHasSon is '是否有子节点 Y-有 N-没有';
comment on column emp_menu.node_parentId is '父节点的ID';
comment on column emp_menu.node_url is '菜单节点对应的跳转URL';
comment on column emp_menu.node_isNewBlank is '是否在新窗口打开，内/外站点打开的方式不同';
comment on column emp_menu.node_creatTime is '菜单记录的创建时间';

