package demo.intercepter;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author CBeann
 * @create 2020-02-06 23:32
 */

public class HelloIntercepter extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入 preHandle 方法..." + request.getRequestURL().toString() + "," + request.getRequestURI());
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("进入 postHandle 方法..." + request.getRequestURL().toString() + "," + request.getRequestURI());
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("进入 afterCompletion 方法..." + request.getRequestURL().toString() + "," + request.getRequestURI());
    }
}
