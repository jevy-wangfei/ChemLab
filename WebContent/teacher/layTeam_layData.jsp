<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><s:text name="layTeam"></s:text></title>
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
				<h2 class="title"><s:text name="layData"></s:text></h2>
				<p class="meta">Click <s:text name="layData"></s:text> below to View the Experiment Data and Picture</p>
				
				<div class="entry">
				<h3>
					<s:url id="url" value="teamHaveData.action" namespace="teacher">
	    				<s:param name="date" value="#request.date1"></s:param>
	    			</s:url>
	   				<s:a href="%{url}">已输入数据的组 </s:a>
				 | 
				 	<s:url id="url" value="teamNoData.action" namespace="teacher">
	    				<s:param name="date" value="#request.date2"></s:param>
	    			</s:url>
	   				<s:a href="%{url}">未输入数据的组</s:a>
				 </h3>
				<p><s:iterator id="data1" value="#request.teams" status="d1">
					<table align="left" width="950"> 
					<tr>
						<td colspan="3" class="tableTitle"><s:property value="#data1.tname"/>
							<s:property value="#data1.exname.exname"/>
							<s:date name="#data1.date" format="yyyy-MM-dd" />
							<s:url id="url" value="layDataDispacher.action" namespace="teacher">
    							<s:param name="tid" value="#data1.tid"></s:param>
    							<s:param name="enid" value="#data1.exname.enid"></s:param>
    						</s:url>
   						<s:a href="%{url}"><s:text name="layData"></s:text> </s:a>
   						</td></tr>
					<s:iterator id="students" value="#data1.students">
					<tr>
						<td><s:property value="#students.num"/></td>
						<td><s:property value="#students.name"/></td>
						<td><s:property value="#students.duty"/></td>
					</tr>
				</s:iterator>
			</table>
	</s:iterator>
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