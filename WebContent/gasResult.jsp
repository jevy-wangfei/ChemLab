<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><s:text name="gasLiquid"></s:text></title>
<link href="css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="all">
<s:include value="head.jsp"></s:include>
  <div id="contener">
    <s:include value="index-4.jsp"/>
<div id="content">
<div id="co2"><br />
<h2 align="center"><s:text name="gasLiquid"></s:text></h2>
<h4 align="center"><s:text name="teamMembers"></s:text>: <s:iterator id="stu" value="#request.students">&nbsp;&nbsp;
			<s:property value="#stu.name"/>  
		</s:iterator></h4><h4 align="right"><a href="gasInput.action"><s:text name="inputPage"></s:text></a></h4>
<h3><s:text name="apeData"></s:text></h3>
<table width="800px" align="center">
  <tr>
    <td rowspan="2"><s:text name="sysPressure"></s:text> /MPa</td>
    <td rowspan="2"><s:text name="balanceTemper"></s:text> /℃</td>
    <td colspan="6"><s:text name="gasPhase"></s:text></td>
    <td colspan="2"><s:text name="liquidPhase"></s:text></td>
  </tr>
  <tr>
    <td><s:text name="G<sub>1</sub>"></s:text> /g</td>
    <td><s:text name="G<sub>2</sub>"></s:text> /g</td>
    <td><s:text name="G<sub>3</sub>"></s:text> /g</td>
    <td><s:text name="n<sub>D</sub><sup>30</sup>"></s:text></td>
    <td><s:text name="y<sub>1</sub><sup>'</sup>"></s:text> /%</td>
    <td><s:text name="y"></s:text> /%</td>
    <td><s:text name="n<sub>D</sub><sup>30</sup>"></s:text></td>
    <td><s:text name="x<sub>1</sub>"></s:text> /%</td>
  </tr>
  <s:iterator id="sta" value="#request.gasBase" status="statue">
  <tr>
    <td><s:property value="#sta.sysPress"/></td>
    <td><s:property value="#sta.balanceTemper"/></td>
    <td><s:property value="#sta.g1"/></td>
    <td><s:property value="#sta.g2"/></td>
    <td><s:property value="#sta.g3"/></td>
    <td><s:property value="#sta.ngas"/></td>
    <td><s:property value="#sta.yy"/></td>
    <td><s:property value="#sta.y"/></td>
    <td><s:property value="#sta.nliquid"/></td>
    <td><s:property value="#sta.x1"/></td>
  </tr>
  </s:iterator>
</table><br />
<h3><s:text name="calcuData"></s:text></h3>
<table align="center" width="800px">
	<tr>
		<td><s:text name="number"></s:text></td>
		<td><s:text name="balanceTemper"></s:text> /℃</td>
		<td>y1</td>
		<td>x1</td>
		<td>y<sub><s:text name="fact"></s:text></sub></td>
		<td>y<sub><s:text name="theory"></s:text></sub></td>
		<td>γ1<sub><s:text name="fact"></s:text></sub></td>
		<td>γ1<sub><s:text name="theory"></s:text></sub></td>
		<td>γ2<sub><s:text name="fact"></s:text></sub></td>
		<td>γ2<sub><s:text name="theory"></s:text></sub></td>
	</tr>
	
	<s:iterator id="sta" value="#request.gasRes" status="statue">
		<tr>
		<td><s:property value="#statue.index+1"/></td>
		<td><s:property value="#sta.balanceTemper"/></td>
		<td><s:property value="#sta.yy"/></td>
		<td><s:property value="#sta.x1"/></td>
		<td><s:property value="#sta.y1ex"/></td>
		<td><s:property value="#sta.y1cal"/></td>
		<td><s:property value="#sta.r1ex"/></td>
		<td><s:property value="#sta.r1cal"/></td>
		<td><s:property value="#sta.r2ex"/></td>
		<td><s:property value="#sta.r2cal"/></td>
		</tr>
	</s:iterator>
	
</table><br />
  <img src="gasChart.action?tid=<s:property value='tid'/>" alt="" /><br />
  <br />
	<img src="gasChart2.action?tid=<s:property value='tid'/>" alt="" /><br />
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
