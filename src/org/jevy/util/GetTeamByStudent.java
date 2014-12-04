// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetTeamByStudent.java

package org.jevy.util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jevy.model.*;
import org.jevy.service.GetStudentSession;

public class GetTeamByStudent extends ActionSupport
{

    public GetTeamByStudent()
    {
    }

    public Teams getTeams(int enid, Student stu)
    {
        Teams team = null;
        if(stu == null)
            stu = (new GetStudentSession()).getStudentSession();
        Set team0 = stu.getTeamses();
        Exname ex = (new ExnameDAO()).findById(Integer.valueOf(enid));
        Set team1 = ex.getTeamses();
        for(Iterator iterator = team0.iterator(); iterator.hasNext();)
        {
            Teams teamS = (Teams)iterator.next();
            for(Iterator iterator1 = team1.iterator(); iterator1.hasNext();)
            {
                Teams teamE = (Teams)iterator1.next();
                if(teamS.getTid().equals(teamE.getTid()))
                {
                    team = teamE;
                    break;
                }
            }

        }

        if(team == null)
        {
            ActionContext ctx = ActionContext.getContext();
            ctx.put("teamNull", "\u5BF9\u4E8E\u672C\u5B9E\u9A8C\u7684\u6240\u6709\u5206\u7EC4\uFF0C\u4F60\u4E0D\u5728\u7EC4\u4E2D\uFF0C\u6216\u8BB8\u662F\u56E0\u4E3A\u7BA1\u7406\u5458\u8FD8\u6CA1\u6709\u4E0A\u4F20\u5B9E\u9A8C\u5206\u7EC4\u4FE1\u606F\u8FDB\u884C\u7EC4\u7EC7\u5B9E\u9A8C\u3002");
            HttpServletResponse response = (HttpServletResponse)ctx.get("com.opensymphony.xwork2.dispatcher.HttpServletResponse");
            HttpServletRequest request = (HttpServletRequest)ctx.get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
            try
            {
                request.getRequestDispatcher("/errors.jsp").forward(request, response);
            }
            catch(ServletException e)
            {
                System.out.println((new StringBuilder(" team is null :")).append(team).toString());
                e.printStackTrace();
            }
            catch(IOException e)
            {
                System.out.println((new StringBuilder(" team is null :")).append(team).toString());
                e.printStackTrace();
            }
        }
        return team;
    }
}
