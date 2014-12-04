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
	<div id="co2"><br />
			<h2 align="center"><s:text name="co2"></s:text></h2>
		
		<h4 align="center"><s:text name="teamMembers"></s:text>: <s:iterator id="stu" value="#request.students">&nbsp;&nbsp;
			<s:property value="#stu.name"/>  
		</s:iterator></h4>
   <h4 align="right"> <s:a href="co2Input.action"><s:text name="inputPage"></s:text></s:a></h4>
		
<table width="717" border="0" align="center">
<tr><td align="center" valign="top">
		<table width="229">
	<tr><td width="40">
	T(℃)
    </td>
    <td width="51">
	P(Mpa)
    </td>
    <td width="49">
	△h(cm)
    </td>
    <td width="69">
	v=(m<sup>3</sup>/kg)
    </td>
    </tr>
    
	<s:iterator id="da" value="#request.data1">
    <tr>
        <td><s:property value="#da.temper"/></td>
        <td><s:property value="#da.p"/></td>
        <td><s:property value="#da.dh"/></td>
        <td><s:property value="#da.v"/></td>
    </tr>
	</s:iterator>
	</table>

</td>
  <td align="center" valign="top"><table width="237">
    <tr>
      <td width="43"> T(℃) </td>
      <td width="54"> P(Mpa) </td>
      <td width="49"> △h(cm) </td>
      <td width="71"> v=(m<sup>3</sup>/kg) </td>
    </tr>
    <s:iterator id="da" value="#request.data2">
    <tr>
        <td><s:property value="#da.temper"/></td>
        <td><s:property value="#da.p"/></td>
        <td><s:property value="#da.dh"/></td>
        <td><s:property value="#da.v"/></td>
    </tr>
	</s:iterator>
  </table></td>
  <td align="center" valign="top"><table width="234">
    <tr>
      <td width="41"> T(℃) </td>
      <td width="51"> P(Mpa) </td>
      <td width="51"> △h(cm) </td>
      <td width="71"> v=(m<sup>3</sup>/kg) </td>
    </tr>
   <s:iterator id="da" value="#request.data3">
    <tr>
        <td><s:property value="#da.temper"/></td>
        <td><s:property value="#da.p"/></td>
        <td><s:property value="#da.dh"/></td>
        <td><s:property value="#da.v"/></td>
    </tr>
	</s:iterator>
  </table></td></tr>
</table>


<br />
<img src="co2Chart.action?tid=<s:property value='tid'/>" alt="" />

<br />
<s:action name="Com"  executeResult="true" >
			<s:param name="tid" value="tid"></s:param>
	</s:action>
	<br />
<br />
</div>
</div>
  <!--end of contener -->
</div>
<s:include value="bottom.jsp"></s:include>
</div>
</body>
</html>