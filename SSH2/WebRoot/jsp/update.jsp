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
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <h1>修改。。。。</h1>
   <div align="center">
   <form action="emp/EmpAction!update.action" method="post">
   <input type="hidden" name="eid" value="${tb.eid }"/>
            编号:<input type="text" name="ename" value="${tb.ename }"/><br/>
             密码:<input type="text" name="password" value="${tb.password }"/><br/>
             时间:<input type="text" name="workDate" value="${date }"/><br/>
             年龄:<input type="text" name="age"  value="${tb.age }"/><br/>
             性别:<c:if  test="${tb.gende=='男' }">
              <select name="gende">
                <option value="男">男</option>
                <option value="女">女</option>
                </select> 
         </c:if>
         <c:if test="${tb.gende=='女' }">
              <select name="gende">
                <option value="女">女</option>
                <option value="男">男</option> 
                </select> 
         </c:if> <br/>
              部门:<c:if test="${tb.did==1 }">
               <select name="did" >
                      <option value="1">A部门</option>
                      <option value="2">B部门</option>
                </select> 
         </c:if>
         <c:if test="${tb.did==2 }">
              <select name="did" > 
                      <option value="2">B部门</option>
                      <option value="1">A部门</option>
                </select> 
         </c:if>        <br/>
         <input type="submit" value="修改"/> 
		</form>  
 </div>
  </body>
</html>
