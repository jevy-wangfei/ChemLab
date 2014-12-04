// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LoginAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintStream;
import java.util.*;
import org.jevy.model.Student;
import org.jevy.model.StudentDAO;

public class LoginAction extends ActionSupport
{

    public LoginAction()
    {
    }

    public String execute()
    {
        Student stu = new Student();
        stu.setNum(loginName);
        stu.setPassword(password);
        StudentDAO stuDAO = new StudentDAO();
        ActionContext ctx = ActionContext.getContext();
        if(!stuDAO.login(loginName, password).isEmpty())
        {
            Student student = (Student)stuDAO.findByNum(stu.getNum()).get(0);
            System.out.println((new StringBuilder(String.valueOf(student.getName()))).append("\u767B\u5F55").toString());
            ctx.getSession().put("student", student);
            ctx.getSession().put("studentName", student.getName());
            if(ctx.getSession().get("logins") == null)
            {
                List list = new ArrayList();
                list.add(student);
                ctx.getSession().put("logins", list);
            } else
            {
                List list = (List)ctx.getSession().get("logins");
                list.add(student);
                ctx.getSession().put("logins", list);
            }
            return "success";
        } else
        {
            ctx.put("tip", getText("loginWrong"));
            return "input";
        }
    }

    public String getLoginName()
    {
        return loginName;
    }

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    private String loginName;
    private String password;
}
