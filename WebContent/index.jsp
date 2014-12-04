<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title><s:text name="description"></s:text></title>
<link href="css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="all">
  <s:include value="head.jsp" />
  <div id="contener">
   <s:include value="index-1.jsp" />
   
    <div id="content">


<s:action name="layExnameDescription" executeResult="true"></s:action>

<table width="700" border="1" align="center">
  <tr>
    <td align="center"><s:text name="descriptionDetail"></s:text></td>
  </tr>
</table>
    </div>
    <!--end of content-->
    
  </div>
  <!--end of cocntener-->

  <s:include value="bottom.jsp" />
</div>
<!--end of all-->
</body>
</html>