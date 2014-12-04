<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<div id="login"><a href="http://www.hfut.edu.cn"><s:text name="school"></s:text></a>
 | <a href="http://www1.hfut.edu.cn/department/huayuan/"><s:text name="college"></s:text></a> |
 <a href="exit.action"><s:text name="exit"></s:text></a> 
  &nbsp;&nbsp;&nbsp;&nbsp;<s:text name="explorer"></s:text>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:text name="logger"></s:text><%=request.getSession().getAttribute("studentName") %>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=request.getSession().getAttribute("setTime") %>
   
   </div>
<div id="photo"></div>
