package com.example.controller;

/**
 * @author CBeann
 * @create 2020-06-06 20:53
 */

import com.example.entity.JsonResult;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class ControllerException implements ErrorController {


    private final String PATH = "/error";

    private final String MESSAGE = "message";


    @Resource
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(value = PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object handlerError(HttpServletRequest request) {
        Map<String, Object> attributesMap = getErrorAttributes(request, true);
        System.out.println(attributesMap.get(MESSAGE));
        String msg ;
        if (attributesMap.get(MESSAGE).toString().contains("JWT expired")) {
            msg = "JWT已过期";
        } else if (attributesMap.get(MESSAGE).toString().contains("JWT strings must contain exactly 2 period characters")) {
            msg = "JWT格式错误";
        } else if (attributesMap.get(MESSAGE).toString().contains("No message available")) {
            msg = "参数值缺失";
        } else {
            msg = attributesMap.get(MESSAGE).toString();
        }
        return JsonResult.toJSONObject(Integer.parseInt(attributesMap.get("status").toString()), msg, attributesMap.get("message"));
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        WebRequest webRequest = new ServletWebRequest(request);
        return this.errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
    }
}