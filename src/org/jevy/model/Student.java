// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Student.java

package org.jevy.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package org.jevy.model:
//            School

public class Student
    implements Serializable
{

    public Student()
    {
        teamses = new HashSet(0);
    }

    public Student(School school, String num, String password, String name, String duty, Set teamses)
    {
        this.teamses = new HashSet(0);
        this.school = school;
        this.num = num;
        this.password = password;
        this.name = name;
        this.duty = duty;
        this.teamses = teamses;
    }

    public Integer getSid()
    {
        return sid;
    }

    public void setSid(Integer sid)
    {
        this.sid = sid;
    }

    public School getSchool()
    {
        return school;
    }

    public void setSchool(School school)
    {
        this.school = school;
    }

    public String getNum()
    {
        return num;
    }

    public void setNum(String num)
    {
        this.num = num;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDuty()
    {
        return duty;
    }

    public void setDuty(String duty)
    {
        this.duty = duty;
    }

    public Set getTeamses()
    {
        return teamses;
    }

    public void setTeamses(Set teamses)
    {
        this.teamses = teamses;
    }

    private Integer sid;
    private School school;
    private String num;
    private String password;
    private String name;
    private String duty;
    private Set teamses;
}
