// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UploadStudentAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import org.jevy.service.UploadStudentService;

public class UploadStudentAction extends ActionSupport
{

    public UploadStudentAction()
    {
    }

    public String execute()
        throws Exception
    {
        ActionContext ctx = ActionContext.getContext();
        System.out.println((new StringBuilder("file Name")).append(uploadStudentFileName).toString());
        if(!uploadStudentFileName.contains("xls") || uploadStudentFileName == null)
        {
            ctx.put("tip", getText("fileTypeWrong"));
            return "input";
        }
        String str = ServletActionContext.getServletContext().getRealPath((new StringBuilder(String.valueOf(getSavePath()))).append("\\").append(getUploadStudentFileName()).toString());
        File file = new File(str);
        FileOutputStream fos = new FileOutputStream(file);
        FileInputStream fis = new FileInputStream(getUploadStudent());
        byte buffer[] = new byte[1024];
        for(int len = 0; (len = fis.read(buffer)) > 0;)
            fos.write(buffer, 0, len);

        UploadStudentService up = new UploadStudentService(file);
        up.parseExcel();
        setExname(up.getEx());
        setExNameId(up.getExnameId());
        file.delete();
        return "success";
    }

    public File getUploadStudent()
    {
        return uploadStudent;
    }

    public void setUploadStudent(File uploadStudent)
    {
        this.uploadStudent = uploadStudent;
    }

    public String getUploadStudentContentType()
    {
        return uploadStudentContentType;
    }

    public void setUploadStudentContentType(String uploadStudentContentType)
    {
        this.uploadStudentContentType = uploadStudentContentType;
    }

    public String getUploadStudentFileName()
    {
        return uploadStudentFileName;
    }

    public void setUploadStudentFileName(String uploadStudentFileName)
    {
        this.uploadStudentFileName = uploadStudentFileName;
    }

    public String getSavePath()
    {
        return savePath;
    }

    public void setSavePath(String savePath)
    {
        this.savePath = savePath;
    }

    public static long getSerialVersionUID()
    {
        return 1L;
    }

    public String getExname()
    {
        return exname;
    }

    public void setExname(String exname)
    {
        this.exname = exname;
    }

    public int getExNameId()
    {
        return exNameId;
    }

    public void setExNameId(int exNameId)
    {
        this.exNameId = exNameId;
    }

    private static final long serialVersionUID = 1L;
    private File uploadStudent;
    private String uploadStudentContentType;
    private String uploadStudentFileName;
    private String savePath;
    private String exname;
    private int exNameId;
}
