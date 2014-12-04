// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SchoolDAO.java

package org.jevy.model;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import org.hibernate.criterion.Example;

// Referenced classes of package org.jevy.model:
//            BaseHibernateDAO, School

public class SchoolDAO extends BaseHibernateDAO
{

    public SchoolDAO()
    {
    }

    public void save(School transientInstance)
    {
        log.debug("saving School instance");
        try
        {
            getSession().save(transientInstance);
            log.debug("save successful");
        }
        catch(RuntimeException re)
        {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(School persistentInstance)
    {
        log.debug("deleting School instance");
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

    public School findById(Integer id)
    {
        log.debug((new StringBuilder("getting School instance with id: ")).append(id).toString());
        try
        {
            School instance = (School)getSession().get("org.jevy.model.School", id);
            return instance;
        }
        catch(RuntimeException re)
        {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(School instance)
    {
        log.debug("finding School instance by example");
        try
        {
            List results = getSession().createCriteria("org.jevy.model.School").add(Example.create(instance)).list();
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
        log.debug((new StringBuilder("finding School instance with property: ")).append(propertyName).append(", value: ").append(value).toString());
        try
        {
            String queryString = (new StringBuilder("from School as model where model.")).append(propertyName).append("= ?").toString();
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

    public List findBySchool(Object school)
    {
        return findByProperty("school", school);
    }

    public List findByCollege(Object college)
    {
        return findByProperty("college", college);
    }

    public List findByDepartment(Object department)
    {
        return findByProperty("department", department);
    }

    public List findAll()
    {
        log.debug("finding all School instances");
        try
        {
            String queryString = "from School";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        }
        catch(RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public School merge(School detachedInstance)
    {
        log.debug("merging School instance");
        try
        {
            School result = (School)getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch(RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(School instance)
    {
        log.debug("attaching dirty School instance");
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

    public void attachClean(School instance)
    {
        log.debug("attaching clean School instance");
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

    private static final Log log = LogFactory.getLog("org.jevy.model.SchoolDAO");
    public static final String SCHOOL = "school";
    public static final String COLLEGE = "college";
    public static final String DEPARTMENT = "department";

}
