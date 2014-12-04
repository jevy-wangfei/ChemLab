// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TeamsOrder.java

package org.jevy.util;

import java.io.PrintStream;
import java.util.Date;
import java.util.Set;
import org.jevy.model.Teams;

public class TeamsOrder
{

    public TeamsOrder()
    {
    }

    public Set order(Set set)
    {
        Teams teams[] = new Teams[set.size()];
        set.toArray(teams);
        for(int j = 0; j < teams.length; j++)
        {
            for(int i = 0; i < teams.length - 1; i++)
            {
                System.out.println((new StringBuilder("TeamsOrder:")).append(teams[i].getDate()).toString());
                if(teams[i].getDate().getTime() > teams[i + 1].getDate().getTime())
                {
                    Teams temp = teams[i];
                    teams[i] = teams[i + 1];
                    teams[i + 1] = temp;
                }
            }

        }

        set.clear();
        for(int k = 0; k < teams.length; k++)
        {
            set.add(teams[k]);
            System.out.println((new StringBuilder("TeamsOrder:")).append(teams[k].getDate()).toString());
        }

        return set;
    }
}
