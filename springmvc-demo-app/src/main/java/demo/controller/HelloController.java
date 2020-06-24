package demo.controller;

import demo.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author CBeann
 * @create 2020-01-30 20:10
 */
@Controller
public class HelloController {

    @RequestMapping("/hel")
    public String helloJsp() {
        System.out.println("---------helloJsp---------");
        return "hello";
    }

    @GetMapping("/hello.do")
    @ResponseBody
    public String hello(String name) {
        //request.getParameterValues(name)
        System.out.println("name:" + name);
        System.out.println("---------hello---------");
        return "hello world";
    }

    @RequestMapping("/hello2.do")
    @ResponseBody
    public String hello2(Student student) {
        //request.getParameterNames();,然后用反射到对象里
        System.out.println(student);
        return "hello world";
    }

    @RequestMapping(value = "/hello3.do",method = RequestMethod.POST)
    @ResponseBody
    public String hello3(@RequestBody Student student) {
        //首先获取inputStream变为jackjson,然后在遍历Student的属性，然后find json ，invoke
        System.out.println(student);
        return "hello world";
    }




}
