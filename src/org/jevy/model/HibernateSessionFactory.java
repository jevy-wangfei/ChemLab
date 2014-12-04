// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HibernateSessionFactory.java

package org.jevy.model;

import java.io.PrintStream;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory
{

    private HibernateSessionFactory()
    {
    }

    public static Session getSession()
        throws HibernateException
    {
        Session session = (Session)threadLocal.get();
        if(session == null || !session.isOpen())
        {
            if(sessionFactory == null)
                rebuildSessionFactory();
            session = sessionFactory == null ? null : ((Session) (sessionFactory.openSession()));
            threadLocal.set(session);
        }
        return session;
    }

    public static void rebuildSessionFactory()
    {
        try
        {
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        }
        catch(Exception e)
        {
            System.err.println("%%%% Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }
    }

    public static void closeSession()
        throws HibernateException
    {
        Session session = (Session)threadLocal.get();
        threadLocal.set(null);
        if(session != null)
            session.close();
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static void setConfigFile(String configFile)
    {
        configFile = configFile;
        sessionFactory = null;
    }

    public static Configuration getConfiguration()
    {
        return configuration;
    }

    private static String CONFIG_FILE_LOCATION;
    private static final ThreadLocal threadLocal = new ThreadLocal();
    private static Configuration configuration;
    private static SessionFactory sessionFactory;
    private static String configFile;

    static 
    {
        CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
        configuration = new Configuration();
        configFile = CONFIG_FILE_LOCATION;
        try
        {
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        }
        catch(Exception e)
        {
            System.err.println("%%%% Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }
    }
}
