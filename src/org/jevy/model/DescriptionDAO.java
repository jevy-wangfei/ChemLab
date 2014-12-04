// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DescriptionDAO.java

package org.jevy.model;

import java.io.PrintStream;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import org.hibernate.criterion.Example;

// Referenced classes of package org.jevy.model:
//            BaseHibernateDAO, Description

public class DescriptionDAO extends BaseHibernateDAO
{

    public DescriptionDAO()
    {
    }

    public void delete(Description persistentInstance)
    {
        log.debug("deleting Description instance");
        try
        {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch(RuntimeException re)
        {
            log.error("delete failed", re);
            throw re;
        }
    }

    public void update(Description des)
    {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try
        {
            Description des3 = new Description();
            session.load(des3, des.getDid());
            des3.setContents(des.getContents());
            des3.setExname(des.getExname());
            session.update(des3);
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

    public Description findById(Integer id)
    {
        log.debug((new StringBuilder("getting Description instance with id: ")).append(id).toString());
        try
        {
            Description instance = (Description)getSession().get("org.jevy.model.Description", id);
            return instance;
        }
        catch(RuntimeException re)
        {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(Description instance)
    {
        log.debug("finding Description instance by example");
        try
        {
            List results = getSession().createCriteria("org.jevy.model.Description").add(Example.create(instance)).list();
            log.debug((new StringBuilder("find by example successful, result size: ")).append(results.size()).toString());
            return results;
        }
        catch(RuntimeException re)
        {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value)
    {
        log.debug((new StringBuilder("finding Description instance with property: ")).append(propertyName).append(", value: ").append(value).toString());
        try
        {
            String queryString = (new StringBuilder("from Description as model where model.")).append(propertyName).append("= ?").toString();
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(0, value);
            return queryObject.list();
        }
        catch(RuntimeException re)
        {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List findByContents(Object contents)
    {
        return findByProperty("contents", contents);
    }

    public List findAll()
    {
        log.debug("finding all Description instances");
        try
        {
            String queryString = "from Description";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        }
        catch(RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Description merge(Description detachedInstance)
    {
        log.debug("merging Description instance");
        try
        {
            Description result = (Description)getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch(RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Description instance)
    {
        log.debug("attaching dirty Description instance");
        try
        {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch(RuntimeException re)
        {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Description instance)
    {
        log.debug("attaching clean Description instance");
        try
        {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch(RuntimeException re)
        {
            log.error("attach failed", re);
            throw re;
        }
    }

    private static final Log log = LogFactory.getLog("org.jevy.model.DescriptionDAO");
    public static final String CONTENTS = "contents";

}
