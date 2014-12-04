// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   KindEditorImageUploadAction.java

package org.jevy.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.PrintStream;
import org.apache.struts2.ServletActionContext;
import org.jevy.service.UploadService;

public class KindEditorImageUploadAction extends ActionSupport
{

    public KindEditorImageUploadAction()
    {
        savePath = "/upload/upload";
    }

    public String execute()
        throws Exception
    {
        saveUrl = UploadService.upload(imgFile, imgFileFileName, savePath, ServletActionContext.getRequest());
        String s[] = saveUrl.split("/");
        saveUrl = (new StringBuilder(String.valueOf(s[0]))).append("/").append(s[1]).append("/").append(s[2]).append("/chem/").append(s[3]).append("/").append(s[4]).append("/").append(s[5]).toString();
        System.out.println((new StringBuilder("KindEditorImageUploadImg:execute")).append(saveUrl).toString());
        return "success";
    }

    public String getSavePath()
    {
        return savePath;
    }

    public void setSavePath(String savePath)
    {
        this.savePath = savePath;
    }

    public File getImgFile()
    {
        return imgFile;
    }

    public void setImgFile(File imgFile)
    {
        this.imgFile = imgFile;
    }

    public String getImgFileContentType()
    {
        return imgFileContentType;
    }

    public void setImgFileContentType(String imgFileContentType)
    {
        this.imgFileContentType = imgFileContentType;
    }

    public String getImgFileFileName()
    {
        return imgFileFileName;
    }

    public void setImgFileFileName(String imgFileFileName)
    {
        this.imgFileFileName = imgFileFileName;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getImgTitle()
    {
        return imgTitle;
    }

    public void setImgTitle(String imgTitle)
    {
        this.imgTitle = imgTitle;
    }

    public String getImgWidth()
    {
        return imgWidth;
    }

    public void setImgWidth(String imgWidth)
    {
        this.imgWidth = imgWidth;
    }

    public String getImgHeight()
    {
        return imgHeight;
    }

    public void setImgHeight(String imgHeight)
    {
        this.imgHeight = imgHeight;
    }

    public String getImgBorder()
    {
        return imgBorder;
    }

    public void setImgBorder(String imgBorder)
    {
        this.imgBorder = imgBorder;
    }

    public String getSaveUrl()
    {
        return saveUrl;
    }

    public void setSaveUrl(String saveUrl)
    {
        this.saveUrl = saveUrl;
    }

    private static final long serialVersionUID = 0xcc6f90dd97879e5L;
    private String savePath;
    private File imgFile;
    private String imgFileContentType;
    private String imgFileFileName;
    private String id;
    private String imgTitle;
    private String imgWidth;
    private String imgHeight;
    private String imgBorder;
    private String saveUrl;
}
