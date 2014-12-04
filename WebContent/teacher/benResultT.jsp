<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><s:text name="ben"></s:text></title>
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
				<h2 class="title"><s:text name="ben" ></s:text>&nbsp;&nbsp;&nbsp;
				<s:url id="url" value="excellentCom.action" namespace="teacher">
    				<s:param name="tid" value="#team.tid"></s:param>
    				</s:url><s:a href="%{url}"><s:text name="favorite"></s:text></s:a>
    			</h2>
		<p class="meta"><s:text name="teamMembers"></s:text>: <s:iterator id="stu" value="#request.students">&nbsp;&nbsp;
					<s:property value="#stu.name"/>  
				
					</s:iterator></p>
				
				<div class="entry">
				<p><s:action name="benTResult" namespace="/teacher" executeResult="true" >
					<s:param name="tid" value="tid"></s:param>
					</s:action>
				<br />
		<img src="benTChart.action?tid=<s:property value='tid'/>" alt="" />
		<s:action name="benQResult" namespace="/teacher" executeResult="true" >
			<s:param name="tid" value="tid"></s:param>
		</s:action>
		
		<br />
		<img src="benQChart.action?tid=<s:property value='tid'/>" alt="" />
		<br />
		</p>
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