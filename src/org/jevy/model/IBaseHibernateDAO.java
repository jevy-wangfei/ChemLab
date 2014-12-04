// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IBaseHibernateDAO.java

package org.jevy.model;

import org.hibernate.Session;

public interface IBaseHibernateDAO
{

    public abstract Session getSession();
}
