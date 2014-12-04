// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetStudentSession.java

package org.jevy.service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintStream;
import java.util.Map;
import org.jevy.model.Student;

public class GetStudentSession extends ActionSupport
{

    public GetStudentSession()
    {
    }

    public Student getStudentSession()
    {
        student = (Student)ActionContext.getContext().getSession().get("student");
        if(student == null)
            System.out.println((new StringBuilder("GetStudentSession().getStudentSession().student:")).append(student).toString());
        return student;
    }

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    private static final long serialVersionUID = 0x9cbe7cf904302c46L;
    Student student;
}
