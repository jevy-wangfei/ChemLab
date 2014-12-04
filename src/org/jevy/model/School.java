// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   School.java

package org.jevy.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class School
    implements Serializable
{

    public School()
    {
        students = new HashSet(0);
    }

    public School(String school, String college, String department, Set students)
    {
        this.students = new HashSet(0);
        this.school = school;
        this.college = college;
        this.department = department;
        this.students = students;
    }

    public Integer getCid()
    {
        return cid;
    }

    public void setCid(Integer cid)
    {
        this.cid = cid;
    }

    public String getSchool()
    {
        return school;
    }

    public void setSchool(String school)
    {
        this.school = school;
    }

    public String getCollege()
    {
        return college;
    }

    public void setCollege(String college)
    {
        this.college = college;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public Set getStudents()
    {
        return students;
    }

    public void setStudents(Set students)
    {
        this.students = students;
    }

    private Integer cid;
    private String school;
    private String college;
    private String department;
    private Set students;
}
