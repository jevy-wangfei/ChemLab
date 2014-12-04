// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BasicdataDAO.java

package org.jevy.model;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import org.hibernate.criterion.Example;

// Referenced classes of package org.jevy.model:
//            BaseHibernateDAO, Basicdata

public class BasicdataDAO extends BaseHibernateDAO
{

    public BasicdataDAO()
    {
    }

    public List findByLabelAndTeam(String label, int teamId)
    {
        try
        {
            String queryString = "from Basicdata as model where model.label= ? and model.teams_tid= ?";
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(0, label);
            queryObject.setParameter(1, Integer.valueOf(teamId));
            return queryObject.list();
        }
        catch(RuntimeException re)
        {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public Basicdata findById(Integer id)
    {
        log.debug((new StringBuilder("getting Basicdata instance with id: ")).append(id).toString());
        try
        {
            Basicdata instance = (Basicdata)getSession().get("org.jevy.model.Basicdata", id);
            return instance;
        }
        catch(RuntimeException re)
        {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(Basicdata instance)
    {
        log.debug("finding Basicdata instance by example");
        try
        {
            List results = getSession().createCriteria("org.jevy.model.Basicdata").add(Example.create(instance)).list();
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
        log.debug((new StringBuilder("finding Basicdata instance with property: ")).append(propertyName).append(", value: ").append(value).toString());
        try
        {
            String queryString = (new StringBuilder("from Basicdata as model where model.")).append(propertyName).append("= ?").toString();
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

    public List findByLabel(Object label)
    {
        return findByProperty("label", label);
    }

    public List findByBdata1(Object bdata1)
    {
        return findByProperty("bdata1", bdata1);
    }

    public List findByBdata2(Object bdata2)
    {
        return findByProperty("bdata2", bdata2);
    }

    public List findByBdata3(Object bdata3)
    {
        return findByProperty("bdata3", bdata3);
    }

    public List findByBdata4(Object bdata4)
    {
        return findByProperty("bdata4", bdata4);
    }

    public List findByBdata5(Object bdata5)
    {
        return findByProperty("bdata5", bdata5);
    }

    public List findByBdata6(Object bdata6)
    {
        return findByProperty("bdata6", bdata6);
    }

    public List findByBdata7(Object bdata7)
    {
        return findByProperty("bdata7", bdata7);
    }

    public List findByBdata8(Object bdata8)
    {
        return findByProperty("bdata8", bdata8);
    }

    public List findAll()
    {
        log.debug("finding all Basicdata instances");
        try
        {
            String queryString = "from Basicdata";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        }
        catch(RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Basicdata merge(Basicdata detachedInstance)
    {
        log.debug("merging Basicdata instance");
        try
        {
            Basicdata result = (Basicdata)getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch(RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Basicdata instance)
    {
        log.debug("attaching dirty Basicdata instance");
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

    public void attachClean(Basicdata instance)
    {
        log.debug("attaching clean Basicdata instance");
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

    private static final Log log = LogFactory.getLog("org.jevy.model.BasicdataDAO");
    public static final String LABEL = "label";
    public static final String BDATA1 = "bdata1";
    public static final String BDATA2 = "bdata2";
    public static final String BDATA3 = "bdata3";
    public static final String BDATA4 = "bdata4";
    public static final String BDATA5 = "bdata5";
    public static final String BDATA6 = "bdata6";
    public static final String BDATA7 = "bdata7";
    public static final String BDATA8 = "bdata8";

}
