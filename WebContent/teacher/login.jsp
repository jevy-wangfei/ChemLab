<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
<!--
table.login{
	background-image:url(loginBack.jpg);
	color:#FFF;
	}
-->
</style></head>

<body>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p><br />
  <br />
</p>
<table width="400" border="0" class="login" align="center">
      <tr>
        <td  align="center" height="262px">
        <h2><s:text name="login"></s:text></h2>
        <s:form action="teacher" method="post"  theme="simple">
        	<s:text name="loginName"></s:text>: <s:textfield  name="loginName"></s:textfield><br/><br/>
        	<s:text name="password"></s:text> : <s:password  name="password"></s:password><br/><br/>
        	<s:submit key="submit"></s:submit><br/><br/>
        </s:form>
</td>
      </tr>
    </table>
</body>
</html>