<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>  
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert image</title>  
</head>  
<body>  
<script language="javascript" type="text/javascript">

parent.KE.plugin["image"].insert("<s:property value='%{#request.id}'/>","<s:property value='%{#request.saveUrl}'/>","<s:property value='%{#request.imgTitle}'/>","<s:property value='%{#request.imgWidth}'/>","<s:property value='%{#request.imgHeight}'/>","<s:property value='%{#request.imgBorder}'/>");    
</script>  
</body>  
</html>