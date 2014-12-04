// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BaseHibernateDAO.java

package org.jevy.model;

import java.io.PrintStream;
import org.hibernate.*;

// Referenced classes of package org.jevy.model:
//            IBaseHibernateDAO, HibernateSessionFactory

public class BaseHibernateDAO
    implements IBaseHibernateDAO
{

    public BaseHibernateDAO()
    {
    }

    public Session getSession()
    {
        return HibernateSessionFactory.getSession();
    }

    public void save(Object transientInstance)
    {
        if(transientInstance == null)
            System.out.println("not allowed inserted null into database");
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try
        {
            session.save(transientInstance);
            transaction.commit();
            session.close();
        }
        catch(RuntimeException re)
        {
            transaction.rollback();
            session.close();
            System.out.println("err in save instance to database");
            throw re;
        }
    }

    public void delete(Object persistentInstance)
    {
        if(persistentInstance == null)
            System.out.println("not allowed delete null from database");
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try
        {
            session.delete(persistentInstance);
            transaction.commit();
            session.close();
        }
        catch(RuntimeException re)
        {
            transaction.rollback();
            session.close();
            System.out.println("err in delete instance from database");
            throw re;
        }
    }

    public void update(Object persistentInstance)
    {
        if(persistentInstance == null)
            System.out.println("not allowed update null into database");
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try
        {
            session.update(persistentInstance);
            transaction.commit();
            session.close();
        }
        catch(RuntimeException re)
        {
            transaction.rollback();
            session.close();
            System.out.println("err in update instance into database");
            throw re;
        }
    }

    public Object merge(Object detachedInstance)
    {
        if(detachedInstance == null)
            System.out.println("not allowed merge ");
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try
        {
            Object result = getSession().merge(detachedInstance);
            transaction.commit();
            session.close();
            return result;
        }
        catch(RuntimeException re)
        {
            transaction.rollback();
            session.close();
            System.out.println("err in merge ");
            throw re;
        }
    }

    public void attachDirty(Object instance)
    {
        if(instance == null)
            System.out.println("not allowed attachDirty(saveOrUpdate)");
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try
        {
            getSession().saveOrUpdate(instance);
            transaction.commit();
            session.close();
        }
        catch(RuntimeException re)
        {
            transaction.rollback();
            session.close();
            System.out.println("Error in attachDirty(saveOrUpdate)");
            throw re;
        }
    }

    public void attachClean(Object instance)
    {
        if(instance == null)
            System.out.println("not allowed attachClean ");
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try
        {
            getSession().lock(instance, LockMode.NONE);
            transaction.commit();
            session.close();
        }
        catch(RuntimeException re)
        {
            transaction.rollback();
            session.close();
            System.out.println("err int attachClean");
            throw re;
        }
    }
}
