<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><s:text name="login"></s:text></title>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312"><style type="text/css">
<!--
body,td,th {
	color: #FFF;
}
body {
	
}
-->
</style></head>
  
  <body>
  <font color="#000"><s:text name="explorer"></s:text></font>	
 
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <table width="402" border="0" align="center" >
    <tr>
      <td><table width="402" border="0">
        <tr>
          <th height="190" align="center" valign="middle"  background="logo/loginBack.jpg"><h1><s:text name="login"></s:text> </h1>
            <s:form action="login">
              
              <s:textfield name="loginName" key="loginName" value="%{loginName}"></s:textfield>
               <s:password name="password" key="password"></s:password>
              <s:submit key="submit"></s:submit>
            </s:form>
          </th>
        </tr>
      </table>
      
      </td>
    </tr>
  </table> 
  </body>
</html>
