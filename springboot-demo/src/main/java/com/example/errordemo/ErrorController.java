package com.example.errordemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author CBeann
 * @create 2020-06-06 23:53
 */
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    private final String PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return PATH;
    }


    @RequestMapping(value = PATH)
    @ResponseBody
    public String errorApiHandler(HttpServletRequest request){
        WebRequest webRequest = new ServletWebRequest(request);
        Map<String, Object> attr =  this.errorAttributes.getErrorAttributes(webRequest, false);
        int status = getStatus(request);
        Object orDefault = attr.getOrDefault("message", "error");

        return orDefault.toString()+"-"+status;
    }

    private int getStatus(HttpServletRequest request) {
        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");//固定写法
        if (status != null) {
            return status;
        }
        return 500;
    }



}
