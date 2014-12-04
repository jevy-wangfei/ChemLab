<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><s:text name="co2"></s:text></title>
<link href="css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="all">
<s:include value="head.jsp"></s:include>
  <div id="contener">
    <s:include value="index-4.jsp"/>
	<div id="content">
	<br />
		<h2 align="center"><s:text name="ben"></s:text></h2>
		<h4 align="center"><s:text name="teamMembers"></s:text>: <s:iterator id="stu" value="#request.students">&nbsp;&nbsp;
			<s:property value="#stu.name"/>  
		</s:iterator></h4>
		<h4 align="right"><a href="benInput.action"><s:text name="inputPage"></s:text></a></h4>
		<s:action name="benTResult" executeResult="true" >
			<s:param name="tid" value="tid"></s:param>
		</s:action>
		<br />
		<img src="benTChart.action?tid=<s:property value='tid'/>" alt="" />
		<br />
		<s:action name="benQResult"  executeResult="true" >
			<s:param name="tid" value="tid"></s:param>
		</s:action>
		<br />
		
		<img src="benQChart.action?tid=<s:property value='tid'/>" alt="" />
<br />
	<s:action name="Com"  executeResult="true" >
			<s:param name="tid" value="tid"></s:param>
			<s:param name="enid" value="2"></s:param>
	</s:action>
	<br />
</div>
</div> 
 <!--end of contener -->
<s:include value="bottom.jsp"></s:include>
</div>
</body>
</html>