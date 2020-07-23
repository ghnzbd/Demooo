package com.example.myauthann;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author CBeann
 * @create 2020-07-05 16:19
 */
@WebFilter(urlPatterns = "/*",filterName = "channelFilter")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("before---------doFilter---------");
        chain.doFilter(request, response);
        System.out.println("after---------doFilter---------");

    }


}
