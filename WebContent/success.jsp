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
success

<s:form action="update.action">
<s:iterator value="personList" status="stat">
<s:textfield name="personList[%{#stat.index}].id" value="%{personList[#stat.index].id}" />
<s:textfield name="personList[%{#stat.index}].name" value="%{personList[#stat.index].name}" />
<s:textfield name="personList[%{#stat.index}].age" value="%{personList[#stat.index].age}" />
</s:iterator>

<s:submit />
</s:form>





</body>
</html>