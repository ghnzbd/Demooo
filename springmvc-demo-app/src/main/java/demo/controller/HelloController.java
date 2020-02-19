package demo.controller;

import demo.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CBeann
 * @create 2020-01-30 20:10
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String helloJsp() {
        System.out.println("---------helloJsp---------");
        return "hello";
    }

    @RequestMapping("/hello.do")
    @ResponseBody
    public String hello(String name) {
        System.out.println("name:" + name);
        System.out.println("---------hello---------");
        return "hello world";
    }

    @RequestMapping("/hello2.do")
    @ResponseBody
    public String hello2(Student student) {
        System.out.println(student);
        return "hello world";
    }


}
