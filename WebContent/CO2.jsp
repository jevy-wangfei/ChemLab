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
   <s:include value="index-2.jsp"/>
<div id="content">
<br />
		<h2 align="center"><s:text name="co2"></s:text></h2>
		<br />
<s:form action="CO2" method="post" >
  <table width="674" border="1" align="center">
    <tr>
      <td width="482" align="center" valign="top">
      <table width="460" height="117" border="1" align="center">
        <tr>
          <td width="30" rowspan="5">&nbsp;</td>
          <td width="196" align="right"><s:text name="atm"></s:text></td>
          <td width="212" align="left"><input name="baseP" type="text" value="<s:property value='baseP'/>" size="8"/>
  &nbsp;MPa </td>
          </tr>
        <tr>
          <td align="right"><s:text name="environmentTemper"></s:text></td>
          <td align="left"><input name="baseT" type="text" value="<s:property value='baseT'/>" size="8"/>
            ℃</td>
          </tr>
        <tr>
         
          </tr>
        <tr>
          <td align="right"> 25℃、7.8MPa
            <s:text name="Hghigh"></s:text></td>
          <td align="left"><input name="h" />
            cm </td>
          </tr>
        <tr>
          <td align="right"> <s:text name="experimentTemper"></s:text> T </td>
          <td align="left"><label>
            <input name="t" type="text" id="t" size="10" maxlength="10" value="<s:property value='t'/>"/>
          </label>
            ℃</td>
          </tr>
      </table><br/>
        <table width="460"  border="1" align="center">
        <tr>
          <td></td>
          <td width="205" align="center" valign="middle">P<code>(Mpa)</code></td>
          <td width="213" align="center" valign="middle"><p>△h<code>(cm)</code></p></td>
        </tr>
        <%
	int rows = 16;
	for(int i=0; i<rows; i++){
%>
        <tr>
          <td><%=(i+1) %></td>
          <td align="center" valign="middle"><input name="p1" type="text" id="p1" size="10" maxlength="10" value="<s:property value='p1[<%=i %>]'/>"/></td>
          <td align="center" valign="middle"><input name="dh1" type="text" id="dh1" size="10" maxlength="10" value="<s:property value='dh1[<%=i %>]'/>"/></td>
        </tr>
        <%} %>
        <tr>
          <td  align="right" colspan="3"><s:hidden name="enid" value="3"></s:hidden>
            <input type="submit" value="<s:text name='submit'></s:text>"/></td>
        </tr>
      </table></td>
      <td width="176" align="left" valign="top">
      <br />
      <s:text name="notice"></s:text><s:text name="co2DataInput"></s:text>
      </td>
      </tr>
</table>
</s:form>

</div>
</div>
 <!--end of contener -->
 <s:include value="bottom.jsp"></s:include>
</div>
</body>
</html>