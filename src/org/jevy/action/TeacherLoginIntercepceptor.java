// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TeacherLoginIntercepceptor.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.Map;
import org.jevy.dispacher.*;
import org.jevy.model.Admin;

// Referenced classes of package org.jevy.action:
//            BenQResultAction, BenQualityAction, BenResultTAction, BenTResultAction, 
//            CO2DataAction, CommentAction, DateDataAction, DateTeamAction, 
//            DeleteDataAction, EditTeamAction, GasDataAction, LayExname, 
//            LayExNameAction, LayTeamAction, SaltResultAction, StyreneResultAction, 
//            TeamHaveData, TeamNoData, UpdateTeamAction

public class TeacherLoginIntercepceptor extends AbstractInterceptor
{

    public TeacherLoginIntercepceptor()
    {
    }

    public String intercept(ActionInvocation invocation)
        throws Exception
    {
        ActionContext ctx = invocation.getInvocationContext();
        Map session = ctx.getSession();
        Admin admin = (Admin)session.get("teacher");
        if(admin != null && admin.getAid().intValue() <= 2)
            return invocation.invoke();
        Object action = invocation.getAction();
        if((action instanceof BenQResultAction) || (action instanceof BenQualityAction) || (action instanceof BenResultTAction) || (action instanceof BenTResultAction) || (action instanceof CO2DataAction) || (action instanceof CommentAction) || (action instanceof DateDataAction) || (action instanceof DateTeamAction) || (action instanceof DeleteDataAction) || (action instanceof EditTeamAction) || (action instanceof GasDataAction) || (action instanceof LayExname) || (action instanceof LayExNameAction) || (action instanceof LayTeamAction) || (action instanceof SaltResultAction) || (action instanceof StyreneResultAction) || (action instanceof TeamHaveData) || (action instanceof TeamNoData) || (action instanceof UpdateTeamAction) || (action instanceof LayDataDispacher) || (action instanceof LayTeamDispacherAction) || (action instanceof DispacherURLData))
        {
            return invocation.invoke();
        } else
        {
            ctx.put("tip", "You Don't Have The Power to Perform this Action.");
            return "error";
        }
    }
}
