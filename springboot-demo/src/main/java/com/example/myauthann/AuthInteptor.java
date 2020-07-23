package com.example.myauthann;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @author CBeann
 * @create 2020-07-02 9:59
 */
@Component
public class AuthInteptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle.....................");


        if (! (handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(Auth.class)) {
            //System.out.println("auth...........");

        }
        //System.out.println("preHandle.....................");
        HttpSession session = request.getSession();

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle.....................");
        HttpSession session = request.getSession();
       // System.out.println(session);
        super.postHandle(request, response, handler, modelAndView);
    }
}
