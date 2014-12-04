<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><s:text name="waterSalt"></s:text></title>
<link href="css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="all">
<s:include value="head.jsp"></s:include>
  <div id="contener">
    <s:include value="index-4.jsp"/>
	<div id="content">
	<div id="co2"><br />
		<h2 align="center"><s:text name="waterSalt"></s:text></h2>
		<h4 align="center"><s:text name="teamMembers"></s:text>: <s:iterator id="stu" value="#request.students">&nbsp;&nbsp;
			<s:property value="#stu.name"/>  
		</s:iterator></h4>
		<h4 align="right"><a href="saltInput.action"><s:text name="inputPage"></s:text></a></h4>
	<table><tr>
		 <td colspan="2"><s:text name="trueWeight"></s:text>(g/50gH<sub>2</sub>O)</td>
        <td colspan="2"><s:text name="getWeight"></s:text>W(g)</td>
        <td width="127" rowspan="2"><s:text name="costLiquid"></s:text>(ml)</td>
        <td colspan="2"><s:text name="contribution"></s:text>(%)</td>
      </tr>
      <tr>
        <td width="106">NaCl</td>
        <td width="107">NH<sub>4</sub>Cl</td>
        <td width="114">AgNO<sub>3</sub></td>
        <td width="102">NaOH</td>
        <td width="106">NaCl</td>
        <td width="107">NH<sub>4</sub>Cl</td>
      </tr>
      <s:iterator id="salt" value="#request.saltResult">
      	<tr>
      	<td><s:property value="#salt.na"/></td>
      	<td><s:property value="#salt.nh"/></td>
      	<td><s:property value="#salt.w"/></td>
      	<td><s:property value="#salt.ag"/></td>
      	<td><s:property value="#salt.oh"/></td>
      	<td><s:property value="#salt.resNa"/></td>
      	<td><s:property value="#salt.resNh"/></td>
      	</tr>
      </s:iterator>
	  <tr>
	  
	  </tr>
	
	
	</table>
	<s:iterator id="salt" value="#request.saltResult">
	
	</s:iterator>
		
<br />
<img src="saltChart.action?tid=<s:property value='tid'/>" alt="" />

<br />
<br />
<s:action name="Com"  executeResult="true" >
			<s:param name="tid" value="tid"></s:param>
			<s:param name="enid" value="2"></s:param>
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