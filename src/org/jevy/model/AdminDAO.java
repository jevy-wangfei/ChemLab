// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AdminDAO.java

package org.jevy.model;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import org.hibernate.criterion.Example;

// Referenced classes of package org.jevy.model:
//            BaseHibernateDAO, Admin

public class AdminDAO extends BaseHibernateDAO
{

    public AdminDAO()
    {
    }

    public Admin findById(Integer id)
    {
        log.debug((new StringBuilder("getting Admin instance with id: ")).append(id).toString());
        try
        {
            Admin instance = (Admin)getSession().get("org.jevy.model.Admin", id);
            return instance;
        }
        catch(RuntimeException re)
        {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(Admin instance)
    {
        log.debug("finding Admin instance by example");
        try
        {
            List results = getSession().createCriteria("org.jevy.model.Admin").add(Example.create(instance)).list();
            log.debug((new StringBuilder("find by example successful, result size: ")).append(results.size()).toString());
            return results;
        }
        catch(RuntimeException re)
        {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List adminLogin(String loginName, String password)
    {
        try
        {
            Session session = getSession();
            String queryString = "from Admin as model where model.loginname=? and model.password=?";
            Query queryObject = session.createQuery(queryString);
            queryObject.setParameter(0, loginName);
            queryObject.setParameter(1, password);
            List list = queryObject.list();
            session.close();
            return list;
        }
        catch(RuntimeException e)
        {
            log.error("find by property name failed", e);
            throw e;
        }
    }

    public List findByProperty(String propertyName, Object value)
    {
        log.debug((new StringBuilder("finding Admin instance with property: ")).append(propertyName).append(", value: ").append(value).toString());
        try
        {
            String queryString = (new StringBuilder("from Admin as model where model.")).append(propertyName).append("= ?").toString();
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

    public List findByLoginname(Object loginname)
    {
        return findByProperty("loginname", loginname);
    }

    public List findByPassword(Object password)
    {
        return findByProperty("password", password);
    }

    public List findAll()
    {
        log.debug("finding all Admin instances");
        try
        {
            String queryString = "from Admin where aid>2";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        }
        catch(RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Admin merge(Admin detachedInstance)
    {
        log.debug("merging Admin instance");
        try
        {
            Admin result = (Admin)getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch(RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Admin instance)
    {
        log.debug("attaching dirty Admin instance");
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

    public void attachClean(Admin instance)
    {
        log.debug("attaching clean Admin instance");
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

    private static final Log log = LogFactory.getLog("org.jevy.model.AdminDAO");
    public static final String LOGINNAME = "loginname";
    public static final String PASSWORD = "password";

}
