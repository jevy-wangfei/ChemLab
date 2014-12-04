<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><s:text name="grantPower"></s:text></title>
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
				<h2 class="title"><s:text name="grantPower"></s:text></h2>
				
				<div class="entry">
				<br />
				<table width=600px align="center">
				<tr>
					<form action="grantPower.action" method="post">
					<td>授权名:</td><td><input type="text" name="loginName"/> </td>
					<td>授权密码:</td><td><input type="password" name="password"/> </td>
					<td></td><td><input type="submit" value="授权"/> </td>
					</form>
				</tr>
				<tr></tr>
					<s:iterator id="ad" value="#request.ad">
					<tr>
					<td>授权名:</td><td><s:property value="#ad.loginname"/>  </td>
					<td>授权密码:</td><td>****** </td>
				<s:url id="url" value="deletePower.action" namespace="teacher">
    				<s:param name="aid" value="#ad.aid"></s:param>
    			</s:url>
					<td><s:a href="%{url}"> <s:text name="delete"></s:text></s:a> </td>
					</tr>
					
					</s:iterator>
				</table>
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