package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@SpringBootTest
class ServiceTests {


    @Autowired
    private StudentService studentService;


    @Test
    void add() {

        Student student = new Student();
        student.setId(1);//无效
        student.setName("1");
        student.setAge(1);
        student.setSex(1);
        studentService.save(student);


    }

    @Test
    void del() {

        boolean b = studentService.removeById(5);
        System.out.println(b);


    }

    @Test
    void update() {

        //不设置的不改为空
        Student student = new Student();
        student.setId(1);
        student.setName("1");
        //student.setAge(1);
        //student.setSex(1);
        studentService.updateById(student);


    }

    @Test
    void select() {


        Student student = studentService.getById(1);
        System.out.println(student);


    }

    @Test
    void selectCondition() {


        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age", "1");

        List<Student> students = studentService.list(queryWrapper);
        System.out.println(students);


    }

        @Test
        void selectConditionPage() {

            QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("age", "1");


            IPage<Student> userPage = new Page<>(1, 3);//参数一是当前页，参数二是每页个数

            IPage<Student> studentIPage = studentService.page(userPage, queryWrapper);

            List<Student> records = studentIPage.getRecords();

            System.out.println("记录：" + records);
            System.out.println("当前页数：" + userPage.getCurrent());
            System.out.println("总页数：" + userPage.getPages());
            System.out.println("没夜多少：" + userPage.getSize());
            System.out.println("一共多少记录：" + userPage.getTotal());


        }


}
