package com.kebodev.filters;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kebodev.managed.FragmentHandlerMB;

/**
 *
 * @author Kuli Gábor
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    private static final Logger LOG = Logger.getLogger(LoginFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         //To change body of generated methods, choose Tools | Templates.

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        FragmentHandlerMB session = (FragmentHandlerMB) req.getSession().getAttribute("fragmentHandlerMB");
        String url = req.getRequestURI();

        if (session == null) {

            if (url.contains("login.xhtml")) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect("login.xhtml");
            }

        } else {

            if (url.contains("logout.xhtml")) {
                req.getSession().removeAttribute("fragmentHandlerMB");
               

                Cookie[] cookies = req.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        cookie.setMaxAge(0);
                        cookie.setValue(null);
                        cookie.setPath("/");
                        resp.addCookie(cookie);
                        //response
                    }
                }
                 chain.doFilter(req, resp);

            } else {
                chain.doFilter(request, response);
            }

        }

    }

    @Override
    public void destroy() {
        //To change body of generated methods, choose Tools | Templates.
    }

}

