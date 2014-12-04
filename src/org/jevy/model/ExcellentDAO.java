// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExcellentDAO.java

package org.jevy.model;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import org.hibernate.criterion.Example;

// Referenced classes of package org.jevy.model:
//            BaseHibernateDAO, Excellent

public class ExcellentDAO extends BaseHibernateDAO
{

    public ExcellentDAO()
    {
    }

    public Excellent findById(Integer id)
    {
        log.debug((new StringBuilder("getting Excellent instance with id: ")).append(id).toString());
        try
        {
            Excellent instance = (Excellent)getSession().get("org.jevy.model.Excellent", id);
            return instance;
        }
        catch(RuntimeException re)
        {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(Excellent instance)
    {
        log.debug("finding Excellent instance by example");
        try
        {
            List results = getSession().createCriteria("org.jevy.model.Excellent").add(Example.create(instance)).list();
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
        log.debug((new StringBuilder("finding Excellent instance with property: ")).append(propertyName).append(", value: ").append(value).toString());
        try
        {
            String queryString = (new StringBuilder("from Excellent as model where model.")).append(propertyName).append("= ?").toString();
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

    public List findByComments(Object comments)
    {
        return findByProperty("comments", comments);
    }

    public List findAll()
    {
        log.debug("finding all Excellent instances");
        try
        {
            String queryString = "from Excellent order by eid desc";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        }
        catch(RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Excellent merge(Excellent detachedInstance)
    {
        log.debug("merging Excellent instance");
        try
        {
            Excellent result = (Excellent)getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch(RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Excellent instance)
    {
        log.debug("attaching dirty Excellent instance");
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

    public void attachClean(Excellent instance)
    {
        log.debug("attaching clean Excellent instance");
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

    private static final Log log = LogFactory.getLog("org.jevy.model.ExcellentDAO");
    public static final String COMMENTS = "comments";

}
