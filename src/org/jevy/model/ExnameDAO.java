// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExnameDAO.java

package org.jevy.model;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import org.hibernate.criterion.Example;

// Referenced classes of package org.jevy.model:
//            BaseHibernateDAO, Exname

public class ExnameDAO extends BaseHibernateDAO
{

    public ExnameDAO()
    {
    }

    public Exname findById(Integer id)
    {
        log.debug((new StringBuilder("getting Exname instance with id: ")).append(id).toString());
        try
        {
            Session session = getSession();
            Exname instance = (Exname)session.load("org.jevy.model.Exname", id);
            session.close();
            return instance;
        }
        catch(RuntimeException re)
        {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(Exname instance)
    {
        log.debug("finding Exname instance by example");
        try
        {
            Session session = getSession();
            List results = session.createCriteria("org.jevy.model.Exname").add(Example.create(instance)).list();
            log.debug((new StringBuilder("find by example successful, result size: ")).append(results.size()).toString());
            session.close();
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
        log.debug((new StringBuilder("finding Exname instance with property: ")).append(propertyName).append(", value: ").append(value).toString());
        try
        {
            String queryString = (new StringBuilder("from Exname as model where model.")).append(propertyName).append("= ?").toString();
            Session session = getSession();
            Query queryObject = session.createQuery(queryString);
            queryObject.setParameter(0, value);
            List list = queryObject.list();
            session.close();
            return list;
        }
        catch(RuntimeException re)
        {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List findByExname(Object exname)
    {
        return findByProperty("exname", exname);
    }

    public List findAll()
    {
        log.debug("finding all Exname instances");
        try
        {
            String queryString = "from Exname";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        }
        catch(RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Exname merge(Exname detachedInstance)
    {
        log.debug("merging Exname instance");
        try
        {
            Session session = getSession();
            Exname result = (Exname)session.merge(detachedInstance);
            log.debug("merge successful");
            session.close();
            return result;
        }
        catch(RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Exname instance)
    {
        log.debug("attaching dirty Exname instance");
        try
        {
            Session session = getSession();
            session.saveOrUpdate(instance);
            log.debug("attach successful");
            session.close();
        }
        catch(RuntimeException re)
        {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Exname instance)
    {
        log.debug("attaching clean Exname instance");
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

    private static final Log log = LogFactory.getLog("org.jevy.model.ExnameDAO");
    public static final String EXNAME = "exname";

}
