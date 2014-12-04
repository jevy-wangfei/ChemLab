<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<s:fielderror/>
<table>

<s:iterator id="data1" value="#request.student" status="d1">
<tr>
	<s:iterator id="data2" value="#request.data1" status="d2">
	<td>
	<s:property value="data2"/>		
	</td>
	</s:iterator>
</tr>
</s:iterator>

</table>
</body>
</html>