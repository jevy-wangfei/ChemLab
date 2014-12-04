<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Chocolate Brown  by Free CSS Templates</title>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo">
		<s:include value="logoWord.jsp"></s:include>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu">
		<s:include value="head.jsp"></s:include>
	</div>
	<!-- end #menu -->
    
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
		<div id="content">
        <!--repeat this part below-->
			<div class="post">
			<div class="post-bgtop">
			<div class="post-bgbtm">
				<h2 class="title"><s:property value="#request.team.exname.exname"/>&nbsp;&nbsp;
				<s:text name="edit"></s:text><s:text name="team"></s:text>
   				 </h2>
				<p class="meta"><s:property value="#request.team.tname"/>
   	 			<s:date name="#request.team.date" format="yyyy-MM-dd"/></p>
				
				<div class="entry">
					<p><table  align="center" width="950px" ><tr>		
   				 <s:iterator id="stu" value="#request.students">
   	 			<tr><s:form action="updateTeam" namespace="/teacher" theme="simple">
   	 			<td><s:property value="#stu.num"/> </td>
   	 			<td><s:property value="#stu.name"/> </td>
   	 			<td><s:property value="#stu.duty"/> </td>
   	 			<td><s:select name="reTeam" list="#request.teamMap" ></s:select> </td>
   	 			<td><input type="hidden" name="sid" value="<s:property value='#stu.sid'/>"/>
   	 			<input type="hidden" name="tid" value="<s:property value='#request.team.tid'/>"/>
   	 			<input type="submit" value="<s:text name='submit'></s:text>"/></td>
   	 		</s:form></tr>
   	 </s:iterator>
   	</table></p>
				</div>
			</div>
			</div>
			</div>
             <!--repeat this part above-->
            
		  <div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end #content -->
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	</div>
	<!-- end #page -->
    
</div>
<!-- end #wrapper -->
	<div id="footer">
		<p><s:include value="bottom.jsp"></s:include></p>
	</div>
	<!-- end #footer -->
</body>
</html>