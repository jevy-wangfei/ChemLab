// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DataDAO.java

package org.jevy.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import org.hibernate.criterion.Example;

// Referenced classes of package org.jevy.model:
//            BaseHibernateDAO, Data

public class DataDAO extends BaseHibernateDAO
{

    public DataDAO()
    {
    }

    public List getCO2Group(int tid)
    {
        try
        {
            String queryString = "from Data as model where model.label = 'co2' and teams_tid=? group by model.data2";
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(0, Integer.valueOf(tid));
            return queryObject.list();
        }
        catch(RuntimeException re)
        {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List getBenTemperData(int tid)
    {
        List list = new ArrayList();
        try
        {
            String querystring = "from Data as model where model.label like 'benT%' and teams_tid=?";
            Query queryObject = getSession().createQuery(querystring);
            queryObject.setParameter(0, Integer.valueOf(tid));
            list = queryObject.list();
        }
        catch(Exception e)
        {
            log.error("find by property name failed", e);
        }
        return list;
    }

    public List getBenQualityData(int tid)
    {
        List list = new ArrayList();
        try
        {
            String querystring = "from Data as model where model.label like 'benQ%' and teams_tid=?";
            Query queryObject = getSession().createQuery(querystring);
            queryObject.setParameter(0, Integer.valueOf(tid));
            list = queryObject.list();
        }
        catch(Exception e)
        {
            log.error("find by property name failed", e);
        }
        return list;
    }

    public Data findById(Integer id)
    {
        log.debug((new StringBuilder("getting Data instance with id: ")).append(id).toString());
        try
        {
            Data instance = (Data)getSession().get("org.jevy.model.Data", id);
            return instance;
        }
        catch(RuntimeException re)
        {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(Data instance)
    {
        log.debug("finding Data instance by example");
        try
        {
            List results = getSession().createCriteria("org.jevy.model.Data").add(Example.create(instance)).list();
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
        log.debug((new StringBuilder("finding Data instance with property: ")).append(propertyName).append(", value: ").append(value).append(" order by did").toString());
        try
        {
            String queryString = (new StringBuilder("from Data as model where model.")).append(propertyName).append("= ?").toString();
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

    public List findByData1(Object data1)
    {
        return findByProperty("data1", data1);
    }

    public List findByData2(Object data2)
    {
        return findByProperty("data2", data2);
    }

    public List findByData3(Object data3)
    {
        return findByProperty("data3", data3);
    }

    public List findByData4(Object data4)
    {
        return findByProperty("data4", data4);
    }

    public List findByData5(Object data5)
    {
        return findByProperty("data5", data5);
    }

    public List findByData6(Object data6)
    {
        return findByProperty("data6", data6);
    }

    public List findByData7(Object data7)
    {
        return findByProperty("data7", data7);
    }

    public List findByData8(Object data8)
    {
        return findByProperty("data8", data8);
    }

    public List findByData9(Object data9)
    {
        return findByProperty("data9", data9);
    }

    public List findByData10(Object data10)
    {
        return findByProperty("data10", data10);
    }

    public List findByData11(Object data11)
    {
        return findByProperty("data11", data11);
    }

    public List findByData12(Object data12)
    {
        return findByProperty("data12", data12);
    }

    public List findByData13(Object data13)
    {
        return findByProperty("data13", data13);
    }

    public List findByData14(Object data14)
    {
        return findByProperty("data14", data14);
    }

    public List findByData15(Object data15)
    {
        return findByProperty("data15", data15);
    }

    public List findByData16(Object data16)
    {
        return findByProperty("data16", data16);
    }

    public List findByData17(Object data17)
    {
        return findByProperty("data17", data17);
    }

    public List findByData18(Object data18)
    {
        return findByProperty("data18", data18);
    }

    public List findByData19(Object data19)
    {
        return findByProperty("data19", data19);
    }

    public List findByData20(Object data20)
    {
        return findByProperty("data20", data20);
    }

    public List findAll()
    {
        log.debug("finding all Data instances");
        try
        {
            String queryString = "from Data";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        }
        catch(RuntimeException re)
        {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Data merge(Data detachedInstance)
    {
        log.debug("merging Data instance");
        try
        {
            Data result = (Data)getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch(RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Data instance)
    {
        log.debug("attaching dirty Data instance");
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

    public void attachClean(Data instance)
    {
        log.debug("attaching clean Data instance");
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

    private static final Log log = LogFactory.getLog("org.jevy.model.DataDAO");
    public static final String LABEL = "label";
    public static final String DATA1 = "data1";
    public static final String DATA2 = "data2";
    public static final String DATA3 = "data3";
    public static final String DATA4 = "data4";
    public static final String DATA5 = "data5";
    public static final String DATA6 = "data6";
    public static final String DATA7 = "data7";
    public static final String DATA8 = "data8";
    public static final String DATA9 = "data9";
    public static final String DATA10 = "data10";
    public static final String DATA11 = "data11";
    public static final String DATA12 = "data12";
    public static final String DATA13 = "data13";
    public static final String DATA14 = "data14";
    public static final String DATA15 = "data15";
    public static final String DATA16 = "data16";
    public static final String DATA17 = "data17";
    public static final String DATA18 = "data18";
    public static final String DATA19 = "data19";
    public static final String DATA20 = "data20";

}
