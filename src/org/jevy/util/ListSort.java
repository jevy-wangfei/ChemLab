// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ListSort.java

package org.jevy.util;

import java.io.PrintStream;
import java.util.*;

public class ListSort
{

    public ListSort()
    {
    }

    public List sort(List list, int num)
    {
        for(int i = 0; i < list.size(); i++)
        {
            for(int j = 0; j < list.size() - 1; j++)
                if(((Double)((List)list.get(j)).get(num)).doubleValue() > ((Double)((List)list.get(j + 1)).get(num)).doubleValue())
                {
                    List temp = new ArrayList();
                    temp = (List)list.get(j + 1);
                    list.set(j + 1, (List)list.get(j));
                    list.set(j, temp);
                }

        }

        return list;
    }

    public static void main(String args[])
    {
        List list1 = new ArrayList();
        list1.add(Double.valueOf(1.1000000000000001D));
        list1.add(Double.valueOf(1.2D));
        List list2 = new ArrayList();
        list2.add(Double.valueOf(4.0999999999999996D));
        list2.add(Double.valueOf(4.2000000000000002D));
        List list3 = new ArrayList();
        list3.add(Double.valueOf(3.1000000000000001D));
        list3.add(Double.valueOf(3.2000000000000002D));
        List list4 = new ArrayList();
        list4.add(Double.valueOf(2.1000000000000001D));
        list4.add(Double.valueOf(2.2000000000000002D));
        List dd = new ArrayList();
        dd.add(list1);
        dd.add(list2);
        dd.add(list3);
        dd.add(list4);
        dd = (new ListSort()).sort(dd, 0);
        List da;
        for(Iterator iterator = dd.iterator(); iterator.hasNext(); System.out.print((new StringBuilder()).append(da.get(0)).append(" ").toString()))
            da = (List)iterator.next();

    }
}
