package com.muhammedtopgul.petclinic.web;

/*
 * created by Muhammed Topgul
 * on 06/04/2021
 * at 23:22
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/testServlet")
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        response.getWriter().write("before...");
        filterChain.doFilter(request, response);
        response.getWriter().write("after...");
    }

    @Override
    public void destroy() {

    }
}
