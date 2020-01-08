<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'save.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 

  </head>
  
  <body>
  <h1>新增。。。。</h1>
   <div align="center">
   <form  action="emp/EmpAction!sava.action"  method="post">
            编号:<input type="text" name="ename"/>      <br/>
             密码:<input type="text" name="password"/>  <br/>
             时间:<input type="text" name="workDate"/>  <br/>
             年龄:<input type="text" name="age"/>       <br/>
              性别:<input type="text" name="gende"/>     <br/>
            部门:<input type="text" name="did"/>        <br/>
         <input type="submit" value="新增"/> 
  </form> 
 </div>
  </body>
</html>
