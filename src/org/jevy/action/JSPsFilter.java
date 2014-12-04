// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JSPsFilter.java

package org.jevy.action;

import java.io.IOException;
import java.util.StringTokenizer;
import javax.servlet.*;
import javax.servlet.http.*;

public class JSPsFilter extends HttpServlet
    implements Filter
{

    public JSPsFilter()
    {
        toPage = null;
    }

    public void init(FilterConfig filterConfig)
        throws ServletException
    {
        int i = 0;
        String pages = null;
        StringTokenizer strTokenizer = null;
        this.filterConfig = filterConfig;
        toPage = filterConfig.getInitParameter("toPage");
        pages = filterConfig.getInitParameter("freePages");
        strTokenizer = new StringTokenizer(pages, ";");
        freePages = new String[strTokenizer.countTokens()];
        while(strTokenizer.hasMoreTokens()) 
            freePages[i++] = strTokenizer.nextToken();
        if(!isFreePage(toPage))
            throw new ServletException("web.xml\u4E2Dfilter\u521D\u59CB\u5316\u53C2\u6570\"toPage\"\u7684\u503C\u5FC5\u987B\u662F\"freePage\"\u4E2D\u7684\u67D0\u4E2A\u9875\u9762.");
        else
            return;
    }

    private boolean isFreePage(String requestURI)
    {
        boolean isFree = false;
        for(int i = 0; i < freePages.length; i++)
            if(requestURI.endsWith(freePages[i]))
                return true;

        return isFree;
    }

    private boolean isValidSession(ServletRequest request)
    {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        return httpRequest.getSession().getAttribute("student") != null && httpRequest.getSession().getAttribute("teacher") != null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
    {
        String requestURI = null;
        org.apache.struts2.components.ActionError errorSession = null;
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        requestURI = httpRequest.getRequestURI();
        if(!isFreePage(requestURI) && !isValidSession(request))
        {
            String toPageURL = null;
            try
            {
                toPageURL = (new StringBuilder(String.valueOf(httpRequest.getContextPath()))).append(toPage).toString();
                httpResponse.encodeRedirectURL(toPageURL);
                httpResponse.sendRedirect(toPageURL);
            }
            catch(IOException ioexception) { }
        }
        if(!httpResponse.isCommitted())
            try
            {
                filterChain.doFilter(request, response);
            }
            catch(ServletException sx)
            {
                filterConfig.getServletContext().log(sx.getMessage());
            }
            catch(IOException iox)
            {
                filterConfig.getServletContext().log(iox.getMessage());
            }
    }

    public void destroy()
    {
    }

    public FilterConfig getFilterConfig()
    {
        return filterConfig;
    }

    public void setFilterConfig(FilterConfig filterConfig)
    {
        this.filterConfig = filterConfig;
    }

    public boolean test(int node)
    {
        return false;
    }

    private FilterConfig filterConfig;
    private String freePages[];
    private String toPage;
}
