<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>errors</title>
<link href="css.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="all">
<s:include value="head.jsp"></s:include>
  <div id="contener">
    <s:include value="index-2.jsp"/>
<div id="content">
<div id="co2"><br />
<h3>error:</h3>
<s:property value="tip"/>
<s:property value="teamNull"/>
<s:debug></s:debug>
<s:property value="Exception"/>
</div>
</div>
  <!--end of contener -->
</div>
<s:include value="bottom.jsp"></s:include>
</div>
</body>
</html>