// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DatabaseResume.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;

public class DatabaseResume extends ActionSupport
{

    public DatabaseResume()
    {
    }

    public String execute()
    {
        ActionContext ctx;
        List mess;
        ctx = ActionContext.getContext();
        mess = new ArrayList();
        System.out.println((new StringBuilder("DatabaseResume:")).append(getDatabaseResumeFileName()).toString());
        if(getDatabaseResumeFileName() != null){
        	ctx.put("tip", "You Must Choose a File End with .sql");
        	return "input";
        }
        if(databaseResumeFileName.contains("sql")){
            ctx.put("tip", "The File Type Muse be *.sql ");
            return "input";
        }
        try
        {
            String str = ServletActionContext.getServletContext().getRealPath((new StringBuilder(String.valueOf(getSavePath()))).append("\\").append(getDatabaseResumeFileName()).toString());
            FileInputStream fis = new FileInputStream(getDatabaseResume());
            Runtime rt = Runtime.getRuntime();
            Process child = rt.exec("mysql -uroot -pcontinue chem");
            OutputStream out = child.getOutputStream();
            StringBuffer sb = new StringBuffer("");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "utf8"));
            String inStr;
            while((inStr = br.readLine()) != null) 
            {
                sb.append((new StringBuilder(String.valueOf(inStr))).append("\r\n").toString());
                mess.add((new StringBuilder(String.valueOf(inStr))).append("<br/>").toString());
            }
            String outStr = sb.toString();
            OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
            writer.write(outStr);
            writer.flush();
            out.close();
            br.close();
            writer.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        ctx.put("mess", mess);
        return "success";
    }

    public File getDatabaseResume()
    {
        return databaseResume;
    }

    public void setDatabaseResume(File databaseResume)
    {
        this.databaseResume = databaseResume;
    }

    public String getDatabaseResumeContentType()
    {
        return databaseResumeContentType;
    }

    public void setDatabaseResumeContentType(String databaseResumeContentType)
    {
        this.databaseResumeContentType = databaseResumeContentType;
    }

    public String getDatabaseResumeFileName()
    {
        return databaseResumeFileName;
    }

    public void setDatabaseResumeFileName(String databaseResumeFileName)
    {
        this.databaseResumeFileName = databaseResumeFileName;
    }

    public String getSavePath()
    {
        return savePath;
    }

    public void setSavePath(String savePath)
    {
        this.savePath = savePath;
    }

    private File databaseResume;
    private String databaseResumeContentType;
    private String databaseResumeFileName;
    private String savePath;
}
