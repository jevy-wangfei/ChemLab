// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UploadStudentService.java

package org.jevy.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import jxl.*;
import org.jevy.model.*;

public class UploadStudentService
{

    public UploadStudentService(File file)
    {
        sh = null;
        rows = 0;
        cols = 0;
        exName = null;
        exNameLabel = 0;
        this.file = file;
        java.io.InputStream in = null;
        Workbook book = null;
        try
        {
            in = new FileInputStream(file);
            book = Workbook.getWorkbook(in);
            sh = book.getSheet(0);
            rows = sh.getRows();
            cols = sh.getColumns();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        Cell cell = sh.getCell(4, 1);
        exName = cell.getContents();
        Cell cell2 = sh.getCell(7, 1);
        System.out.println((new StringBuilder("UploadStudentService:")).append(cell2.getContents()).toString());
        exNameLabel = Integer.parseInt(cell2.getContents());
    }

    public void saveExname()
    {
        if(exName != null)
        {
            ExnameDAO exnameDAO = new ExnameDAO();
            Exname ex = new Exname();
            ex.setExname(exName);
            if(exnameDAO.findById(Integer.valueOf(exNameLabel)) == null)
                exnameDAO.save(ex);
        }
    }

    public Exname getExname()
    {
        ExnameDAO exnameDAO2 = new ExnameDAO();
        Exname ex = exnameDAO2.findById(Integer.valueOf(exNameLabel));
        return ex;
    }

    public void parseExcel()
    {
        saveExname();
        studentTeams();
    }

    public void studentTeams()
    {
        List stu = new ArrayList();
        Teams t = new Teams();
        t.setTname(sh.getCell(5, 1).getContents());
        t.setDate(((DateCell)sh.getCell(6, 1)).getDate());
        t.setExname(getExname());
        Teams temp = new Teams();
        temp.setTname(sh.getCell(5, 1).getContents());
        temp.setDate(((DateCell)sh.getCell(6, 1)).getDate());
        temp.setExname(getExname());
        for(int i = 1; i < rows; i++)
        {
            int k = 5;
            Cell cell = sh.getCell(k, i);
            t.setTname(sh.getCell(k, i).getContents());
            k++;
            t.setDate(((DateCell)sh.getCell(k, i)).getDate());
            t.setExname(getExname());
            Student student = new Student();
            int j = 0;
            cell = sh.getCell(j, i);
            String num = cell.getContents();
            student.setNum(num);
            j++;
            cell = sh.getCell(j, i);
            String password = cell.getContents();
            student.setPassword(password);
            j++;
            cell = sh.getCell(j, i);
            String name = cell.getContents();
            student.setName(name);
            j++;
            cell = sh.getCell(j, i);
            String duty = cell.getContents();
            student.setDuty(duty);
            org.jevy.model.School school = (new SchoolDAO()).findById(Integer.valueOf(1));
            student.setSchool(school);
            if(!t.getTname().equals(temp.getTname()))
            {
                groupSaveUpdateTeamStudent(stu, temp);
                stu.clear();
                temp.setTname(t.getTname());
                temp.setDate(t.getDate());
                temp.setExname(t.getExname());
            } else
            {
                temp.setTname(t.getTname());
                temp.setDate(t.getDate());
                temp.setExname(t.getExname());
            }
            stu.add(student);
            if(i == rows - 1)
                groupSaveUpdateTeamStudent(stu, temp);
        }

    }

    public List groupSaveUpdateStudent(List stu)
    {
        StudentDAO stuDAO = new StudentDAO();
        for(int k1 = 0; k1 < stu.size(); k1++)
        {
            List stuList = stuDAO.findByNum(((Student)stu.get(k1)).getNum());
            if(stuList.isEmpty())
            {
                stuDAO.save((Student)stu.get(k1));
                Student stu2 = (Student)stuDAO.findByNum(((Student)stu.get(k1)).getNum()).get(0);
                stu.set(k1, stu2);
            } else
            {
                Student stu2 = (Student)stuDAO.findByNum(((Student)stu.get(k1)).getNum()).get(0);
                stu.set(k1, stu2);
            }
        }

        return stu;
    }

    public void groupSaveUpdateTeamStudent(List stu, Teams temp)
    {
        TeamsDAO tDAO2 = new TeamsDAO();
        Teams temp2 = temp;
        if(tDAO2.findByTnameDate(temp2.getTname(), temp2.getDate()).isEmpty())
        {
            tDAO2.save(temp2);
            temp2 = (Teams)tDAO2.findByTnameDate(temp2.getTname(), temp2.getDate()).get(0);
            stu = groupSaveUpdateStudent(stu);
            (new TeamsDAO()).saveTeamsStudent(stu, temp2);
        } else
        {
            Teams temp0 = new Teams();
            temp0 = (Teams)tDAO2.findByTnameDate(temp.getTname(), temp.getDate()).get(0);
            System.out.println((new StringBuilder("=======")).append(temp0).append(temp0.getTname()).toString());
            stu = groupSaveUpdateStudent(stu);
            (new TeamsDAO()).saveTeamsStudent(stu, temp0);
        }
    }

    public int getRows()
    {
        return rows;
    }

    public int getCols()
    {
        return cols;
    }

    public String getEx()
    {
        return exName;
    }

    public int getExnameId()
    {
        return getExname().getEnid().intValue();
    }

    private Sheet sh;
    private File file;
    int rows;
    int cols;
    String exName;
    int exNameLabel;
}
