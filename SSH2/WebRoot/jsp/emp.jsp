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
    
    <title>My JSP 'students.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 
  </head>
  
  <body> 
  
   
   
     <div align="center" style="height: 100px"> 
     <table cellspacing="0" border="1">
     <thead>
    <tr>
     <td>id</td>
      <td>编号</td>
       <td>年龄</td>
        <td>性别</td>
         <td>部门</td>
         <td>时间</td>
         <td>密码</td>
         <td>修改</td>
         <td>删除</td>
    </tr>
     </thead> 
     <tbody>
     <c:forEach items="${list}" var="list2">
        <tr>
      <td>${ list2.eid}</td>
      <td>${ list2.ename}</td>
        <td>${ list2.gende}</td>
       <td>${ list2.age}</td>
        <td>${ list2.tbDept.dname}</td>
         <td>${date   }</td>
         <td>${ list2.password}</td> 
         <td><a href="emp/EmpAction!findById.action?id=${ list2.eid }"  >修改</a></td>
         <td><a href="emp/EmpAction!delete.action?id=${ list2.eid }"   >删除</a></td> 
        </tr>
     </c:forEach>
     </tbody>
     </table>
  </div> 
  <hr/>
  <h1>新增。。。。</h1>
 <div align="center"  >   
     <form action="emp/EmpAction!sava.action" method="post">
	 编号:<input type="text" name="ename"/>      <br/>
             密码:<input type="text" name="password"/>  <br/>
             时间:<input type="text" name="workDate"/>  <br/>
              年龄:<input type="text" name="age"/>       <br/> 
              性别:<select name="gende">
          <option value="男">男</option>
          <option value="女">女</option>
          </select>      <br/>
              部门:<select name="did">
          <option value="1">A部门</option>
          <option value="2">B部门</option>
          </select>        <br/>
         <input type="submit" value="新增"/> 
		</form> 
  </div> 
  </body>
</html>
