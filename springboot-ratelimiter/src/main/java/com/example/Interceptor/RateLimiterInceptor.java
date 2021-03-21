package com.example.Interceptor;

import com.example.annotation.ExtRateLimiter;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author CBeann
 * @create 2020-07-04 18:06
 */
@Component
public class RateLimiterInceptor extends HandlerInterceptorAdapter {

  private Map<String, RateLimiter> rateHashMap = new ConcurrentHashMap<>();

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    if (!(handler instanceof HandlerMethod)) {
      return true;
    }

    final HandlerMethod handlerMethod = (HandlerMethod) handler;

    final Method method = handlerMethod.getMethod();
    // 有这个注解
    boolean methodAnn = method.isAnnotationPresent(ExtRateLimiter.class);
    if (methodAnn) {
      // 获取注解
      ExtRateLimiter extRateLimiter = method.getDeclaredAnnotation(ExtRateLimiter.class);
      //获取注解属性
      double permitsPerSecond = extRateLimiter.permitsPerSecond();
      long timeout = extRateLimiter.timeout();

      String key = method.getDeclaringClass().getName() + method.getName();

      RateLimiter rateLimiter = null;
      if (rateHashMap.get(key) == null) {
        rateLimiter = RateLimiter.create(permitsPerSecond);
        rateHashMap.put(key, rateLimiter);
      } else {
        rateLimiter = rateHashMap.get(key);
      }

      boolean tryAcquire = rateLimiter.tryAcquire(timeout, TimeUnit.MILLISECONDS);

      if (!tryAcquire) {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("限流");
        writer.close();
        response.flushBuffer();
        return false;
      }

      return super.preHandle(request, response, handler);
    }

    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView)
      throws Exception {

    super.postHandle(request, response, handler, modelAndView);
  }
}
