package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;

@SpringBootTest
class SpringbootMybatisplusDemoApplicationTests {


    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentService studentService;

    @Test
    void contextLoads() {

        QueryWrapper<Student> objectQueryWrapper = new QueryWrapper<Student>();
        objectQueryWrapper.eq("sex", 1);


        IPage<Student> userPage = new Page<>(2, 2);//参数一是当前页，参数二是每页个数

        IPage<Student> studentIPage = studentMapper.selectPage(userPage, null);

        List<Student> records = studentIPage.getRecords();

        System.out.println(records);


    }


    @Test
    void add() {

        Student student = new Student();
        student.setId(1);//无效
        student.setName("1");
        student.setAge(1);
        student.setSex(1);
        studentMapper.insert(student);


    }

    @Test
    void del() {

        int i = studentMapper.deleteById(4);
        System.out.println(i);


    }

    @Test
    void update() {

        //不设置的不改为空
        Student student = new Student();
        student.setId(1);
        student.setName("1");
        student.setAge(1);
        student.setSex(1);
        studentMapper.updateById(student);


    }

    @Test
    void select() {


        Student student = studentMapper.selectById(1);
        System.out.println(student);


    }

    @Test
    void selectCondition() {

        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age", "1");

        List<Student> students = studentMapper.selectList(queryWrapper);
        System.out.println(students);



     /*   IPage<Student> userPage = new Page<>(2, 2);//参数一是当前页，参数二是每页个数

        IPage<Student> studentIPage = studentMapper.selectPage(userPage, null);

        List<Student> records = studentIPage.getRecords();

        System.out.println(records);*/


    }

    @Test
    void selectConditionPage() {

        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age", "1");


        IPage<Student> userPage = new Page<>(2, 3);//参数一是当前页，参数二是每页个数

        IPage<Student> studentIPage = studentMapper.selectPage(userPage, null);

        List<Student> records = studentIPage.getRecords();

        System.out.println("记录：" + records);
        System.out.println("当前页数：" + userPage.getCurrent());
        System.out.println("总页数：" + userPage.getPages());
        System.out.println("没夜多少：" + userPage.getSize());
        System.out.println("一共多少记录：" + userPage.getTotal());


    }


}
