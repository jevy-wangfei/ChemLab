// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LoginIntercepceptor.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.Map;
import org.jevy.model.Student;

public class LoginIntercepceptor extends AbstractInterceptor
{

    public LoginIntercepceptor()
    {
    }

    public String intercept(ActionInvocation invocation)
        throws Exception
    {
        ActionContext ctx = invocation.getInvocationContext();
        Map session = ctx.getSession();
        Student user = (Student)session.get("student");
        if(user != null)
        {
            return invocation.invoke();
        } else
        {
            ctx.put("tip", "You Havn't Login System.");
            return "login";
        }
    }

    private static final long serialVersionUID = 1L;
}
