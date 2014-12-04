// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetByExnameService.java

package org.jevy.service;

import java.io.PrintStream;
import java.util.*;
import org.jevy.model.*;

public class GetByExnameService
{

    public GetByExnameService()
    {
    }

    public String[][] getAllByExname(int exNameId)
    {
        exname = exname;
        this.exNameId = exNameId;
        String students[][] = (String[][])null;
        Exname ex = null;
        List list2 = new ArrayList();
        ExnameDAO exnameDAO = new ExnameDAO();
        ex = exnameDAO.findById(Integer.valueOf(this.exNameId));
        System.out.println((new StringBuilder("========")).append(ex.getExname()).toString());
        if(!"".equals(ex) || !ex.equals(null))
        {
            Set teamsList = ex.getTeamses();
            for(Iterator iterator1 = teamsList.iterator(); iterator1.hasNext();)
            {
                Teams iterator = (Teams)iterator1.next();
                Set stuSet = iterator.getStudents();
                Object ostu[] = stuSet.toArray();
                Student student[] = new Student[ostu.length];
                for(int k = 0; k < student.length; k++)
                    student[k] = (Student)ostu[k];

                for(int j = 0; j < student.length; j++)
                {
                    Student stu = student[j];
                    List list1 = new ArrayList();
                    list1.add(ex.getExname());
                    list1.add(iterator.getTname());
                    list1.add(iterator.getDate().toString());
                    list1.add(stu.getNum());
                    list1.add(stu.getPassword());
                    list1.add(stu.getName());
                    list1.add(stu.getDuty());
                    list2.add(list1);
                }

            }

        } else
        {
            System.out.println("GetByExnameService:ex is null");
        }
        students = new String[list2.size()][7];
        for(int i = 0; i < list2.size(); i++)
        {
            students[i][0] = ((List)list2.get(i)).get(0).toString();
            students[i][1] = ((List)list2.get(i)).get(1).toString();
            students[i][2] = ((List)list2.get(i)).get(2).toString();
            students[i][3] = ((List)list2.get(i)).get(3).toString();
            students[i][4] = ((List)list2.get(i)).get(4).toString();
            students[i][5] = ((List)list2.get(i)).get(5).toString();
            students[i][6] = ((List)list2.get(i)).get(6).toString();
        }

        return students;
    }

    String exname;
    int exNameId;
    int id;
}
