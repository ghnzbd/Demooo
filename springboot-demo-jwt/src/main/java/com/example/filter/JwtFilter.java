package com.example.filter;

/**
 * @author CBeann
 * @create 2020-06-06 20:44
 */

import com.example.untils.JwtHelper;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * JWT过滤器
 */
public class JwtFilter implements Filter {
    private JwtHelper jwtHelper;
    private List<String> urls ;
    private static final org.springframework.util.PathMatcher pathMatcher = new AntPathMatcher();
    public JwtFilter(JwtHelper jwtHelper, String[] authorisedUrls) {
        this.jwtHelper = jwtHelper;
        urls = Arrays.asList(authorisedUrls);
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        String spath = httpRequest.getServletPath();
        // 验证受保护的接口
        for (String url : urls) {
            if (pathMatcher.match(url, spath)) {
                Object token = jwtHelper.validateTokenAndGetClaims(httpRequest);

                if (token != null) {
                    chain.doFilter(request, response);
                    return;
                }else{
                    httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "未授权或者授权已经过期");
                    return;
                }
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}