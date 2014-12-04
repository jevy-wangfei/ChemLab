// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TeamsDAO.java

package org.jevy.model;

import java.io.PrintStream;
import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import org.hibernate.criterion.Example;

// Referenced classes of package org.jevy.model:
//            BaseHibernateDAO, Student, Teams

public class TeamsDAO extends BaseHibernateDAO
{

    public TeamsDAO()
    {
    }

    public List findByTnameDate(String tname, Date date)
    {
        List list = new ArrayList();
        Session session = getSession();
        Query query = session.createQuery("from Teams t where t.tname=:tname and date=:date");
        query.setString("tname", tname);
        query.setDate("date", date);
        list = query.list();
        session.close();
        return list;
    }

    public void saveTeamsStudent(List students, Teams team)
    {
        Session session2 = getSession();
        Transaction tx = session2.beginTransaction();
        session2.refresh(team);
        Set students2 = new HashSet();
        Set team2 = new HashSet();
        team2.add(team);
        for(int i = 0; i < students.size(); i++)
        {
            session2.refresh((Student)students.get(i));
            ((Student)students.get(i)).getTeamses().add(team);
            team.getStudents().add(students.get(i));
        }

        session2.saveOrUpdate(team);
        tx.commit();
        session2.close();
    }

    public void updateTeamStudent(int tid, int sid, int reTeam)
    {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Student stu = (Student)session.get("org.jevy.model.Student", Integer.valueOf(sid));
        Teams team = (Teams)session.get("org.jevy.model.Teams", Integer.valueOf(tid));
        try
        {
            team.getStudents().remove(stu);
            stu.getTeamses().remove(team);
            session.saveOrUpdate(team);
            tx.commit();
            session.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            tx.rollback();
        }
        System.out.println((new StringBuilder("TeamsDAO().updateTeamStudent() reTeam: ")).append(reTeam).toString());
        Session session2 = getSession();
        Transaction tx2 = session2.beginTransaction();
        try
        {
            Teams team2 = (Teams)session2.get("org.jevy.model.Teams", Integer.valueOf(reTeam));
            Student stu2 = (Student)session2.get("org.jevy.model.Student", Integer.valueOf(sid));
            team2.getStudents().add(stu2);
            stu.getTeamses().add(team2);
            session2.saveOrUpdate(team2);
            tx2.commit();
            session2.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            tx2.rollback();
        }
    }

    public Teams findById(Integer id)
    {
        log.debug((new StringBuilder("getting Teams instance with id: ")).append(id).toString());
        try
        {
            Session session = getSession();
            Teams instance = (Teams)session.get("org.jevy.model.Teams", id);
            session.close();
            return instance;
        }
        catch(RuntimeException re)
        {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByEnid(int enid)
    {
        log.debug("finding all Teams instances");
        try
        {
            String queryString = (new StringBuilder("from Teams where exName_enid = ")).append(enid).append(" order by tid desc ").toString();
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        }
        catch(RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List findByExample(Teams instance)
    {
        log.debug("finding Teams instance by example");
        try
        {
            List results = getSession().createCriteria("org.jevy.model.Teams").add(Example.create(instance)).list();
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
        log.debug((new StringBuilder("finding Teams instance with property: ")).append(propertyName).append(", value: ").append(value).toString());
        try
        {
            Session session = getSession();
            String queryString = (new StringBuilder("from Teams as model where model.")).append(propertyName).append("= ?").toString();
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

    public List findByTname(Object tname)
    {
        return findByProperty("tname", tname);
    }

    public List findAll()
    {
        log.debug("finding all Teams instances");
        try
        {
            String queryString = "from Teams";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        }
        catch(RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Teams merge(Teams detachedInstance)
    {
        log.debug("merging Teams instance");
        try
        {
            Teams result = (Teams)getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch(RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Teams instance)
    {
        log.debug("attaching dirty Teams instance");
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

    public void attachClean(Teams instance)
    {
        log.debug("attaching clean Teams instance");
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

    private static final Log log = LogFactory.getLog("org.jevy.model.TeamsDAO");
    public static final String TNAME = "tname";

}
