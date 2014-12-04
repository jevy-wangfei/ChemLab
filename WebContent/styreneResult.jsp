<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><s:text name="styreneProducts"></s:text></title>
<link href="css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="all">
<s:include value="head.jsp"></s:include>
  <div id="contener">
   <s:include value="index-2.jsp"/>
<div id="content">
<div id="co2"><br />
		<h2 align="center"><s:text name="styreneProducts"></s:text></h2>
		<h4 align="center"><s:text name="teamMembers"></s:text>: <s:iterator id="stu" value="#request.students">&nbsp;&nbsp;
			<s:property value="#stu.name"/>  
		</s:iterator></h4>
		<h4 align="right"><a href="styreneInput.action"><s:text name="inputPage"></s:text></a></h4>
	<h4 align="center">
		<s:iterator id="stu" value="#request.students">
			<s:property value="#stu.name"/>
		</s:iterator>
	</h4>
	<table width="800" border="0" align="center">
		  <tr>
		    <td rowspan="3"><s:text name="temper"></s:text>℃</td>
		    <td><s:text name="time"></s:text></td>
		    <td colspan="2"><s:text name="addMeterialVolume"></s:text>/(mL/min)</td>
		    <td colspan="6">
		      <s:text name="inpureProducts"></s:text>/g</td>
		    <td rowspan="3"><s:text name="a"></s:text></td>
		    <td rowspan="3"><s:text name="S"></s:text></td>
		    <td rowspan="3"><s:text name="Y"></s:text></td>
		  </tr>
		  <tr>
		    <td rowspan="2"><s:text name="reactor"></s:text></td>
		    <td><s:text name="styrene"></s:text></td>
		    <td><s:text name="water"></s:text></td>
		    <td rowspan="2"><s:text name="hyLayer"></s:text></td>
		    <td rowspan="2"><s:text name="waterLayer"></s:text></td>
		    <td colspan="2"><s:text name="styrene"></s:text></td>
		    <td colspan="2"><s:text name="hyStyrene"></s:text></td>
		    </tr>
		  <tr>
		    <td ><s:text name="quality"></s:text>/g</td>
		    <td ><s:text name="quality"></s:text>/g</td>
		    <td><s:text name="qualityP"></s:text>/%</td>
		    <td><s:text name="quality"></s:text>/g</td>
		    <td><s:text name="qualityP"></s:text>/%</td>
		    <td><s:text name="quality"></s:text>/g</td>
	      </tr>
	      <s:iterator id="da" value="#request.res">
	      	<tr>
		 	<td>1</td>
		    <td><s:property value="#da.reactorTemper"/></td>
		    <td><s:property value="#da.benQuality"/></td>
		    <td><s:property value="#da.waterQuality"/></td>
		    <td><s:property value="#da.hyLayer"/></td>
		    <td><s:property value="#da.waterLayer"/></td>
		    <td><s:property value="#da.benResP"/></td>
		    <td><s:property value="#da.benRes"/></td>
		    <td><s:property value="#da.styreneResP"/></td>
		    <td><s:property value="#da.styreneRes"/></td>
		    <td><s:property value="#da.a"/></td>
		    <td><s:property value="#da.s"/></td>
		    <td><s:property value="#da.y"/></td>
		    </tr>
	      </s:iterator>
	      </table>
	      <br />
	      <img src="styreneChart.action?tid=<s:property value='tid'/>" alt="" /><br />
	      <s:action name="Com"  executeResult="true" >
			<s:param name="tid" value="tid"></s:param>
	</s:action>
	<br />
</div>
</div>
  <!--end of contener -->
</div>
<s:include value="bottom.jsp"></s:include>
</div>
</body>
</html>