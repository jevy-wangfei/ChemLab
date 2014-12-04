<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<title><s:text name="layData"></s:text></title>
</head>

<body>
<s:include value="head.jsp"></s:include><br />

<div id="content">
  	<s:action name="layExname_layData" executeResult="true"></s:action>
    </div>

<s:include value="bottom.jsp"></s:include>
</body>
</html>