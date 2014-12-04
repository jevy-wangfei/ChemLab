// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StudentDAO.java

package org.jevy.model;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import org.hibernate.criterion.Example;

// Referenced classes of package org.jevy.model:
//            BaseHibernateDAO, Student

public class StudentDAO extends BaseHibernateDAO
{

    public StudentDAO()
    {
    }

    public Student findById(Integer id)
    {
        log.debug((new StringBuilder("getting Student instance with id: ")).append(id).toString());
        try
        {
            Session session = getSession();
            Student instance = (Student)session.get("org.jevy.model.Student", id);
            session.close();
            return instance;
        }
        catch(RuntimeException re)
        {
            log.error("get failed", re);
            throw re;
        }
    }

    public List login(String name, String password)
    {
        Student stu = new Student();
        try
        {
            String queryString = "from Student as model where model.num= ? and model.password= ?";
            Session session = getSession();
            Query queryObject = session.createQuery(queryString);
            queryObject.setParameter(0, name);
            queryObject.setParameter(1, password);
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

    public List findByExample(Student instance)
    {
        log.debug("finding Student instance by example");
        try
        {
            Session session = getSession();
            List results = session.createCriteria("org.jevy.model.Student").add(Example.create(instance)).list();
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
        log.debug((new StringBuilder("finding Student instance with property: ")).append(propertyName).append(", value: ").append(value).toString());
        try
        {
            String queryString = (new StringBuilder("from Student as model where model.")).append(propertyName).append("= ?").toString();
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

    public List findByNum(Object num)
    {
        return findByProperty("num", num);
    }

    public List findByPassword(Object password)
    {
        return findByProperty("password", password);
    }

    public List findByName(Object name)
    {
        return findByProperty("name", name);
    }

    public List findByDuty(Object duty)
    {
        return findByProperty("duty", duty);
    }

    public List findAll()
    {
        log.debug("finding all Student instances");
        try
        {
            String queryString = "from Student";
            Session session = getSession();
            Query queryObject = session.createQuery(queryString);
            List list = queryObject.list();
            session.close();
            return list;
        }
        catch(RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Student merge(Student detachedInstance)
    {
        log.debug("merging Student instance");
        try
        {
            Session session = getSession();
            Student result = (Student)session.merge(detachedInstance);
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

    public void attachDirty(Student instance)
    {
        log.debug("attaching dirty Student instance");
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

    public void attachClean(Student instance)
    {
        log.debug("attaching clean Student instance");
        try
        {
            Session session = getSession();
            session.lock(instance, LockMode.NONE);
            log.debug("attach successful");
            session.close();
        }
        catch(RuntimeException re)
        {
            log.error("attach failed", re);
            throw re;
        }
    }

    private static final Log log = LogFactory.getLog("org.jevy.model.StudentDAO");
    public static final String NUM = "num";
    public static final String PASSWORD = "password";
    public static final String NAME = "name";
    public static final String DUTY = "duty";

}
