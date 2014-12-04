// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UploadService.java

package org.jevy.service;

import java.io.*;
import javax.servlet.http.HttpServletRequest;

public class UploadService
{

    public UploadService()
    {
    }

    public static String upload(File source, String fileName, String savePath, HttpServletRequest request)
        throws Exception
    {
        InputStream is = new FileInputStream(source);
        String root = request.getRealPath(savePath);
        File destFile = new File(root, fileName);
        OutputStream os = new FileOutputStream(destFile);
        byte buffer[] = new byte[400];
        for(int length = 0; (length = is.read(buffer)) > 0;)
            os.write(buffer, 0, length);

        is.close();
        os.close();
        SIZE = destFile.length() / 1024L;
        return (new StringBuilder("http://")).append(request.getServerName()).append(":").append(request.getServerPort()).append(savePath).append("/").append(destFile.getName()).toString();
    }

    public static double SIZE;
}
