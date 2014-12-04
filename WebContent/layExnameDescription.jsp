<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<br />

 <s:iterator id="data" value="#request.exname">
    	<s:url id="url" action="layDescription">
    		<s:param name="enid" value="#data.enid"></s:param>
    	</s:url>
    	<h4 align="center" ><s:a href="%{url}"><s:property value="#data.exname"/></s:a></h4>
</s:iterator> 
<br />
