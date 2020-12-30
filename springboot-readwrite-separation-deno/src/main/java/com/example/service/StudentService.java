package com.example.service;

import com.example.annotation.Master;
import com.example.dao.StudentDao;
import com.example.entity.Student;
import com.example.entity.StudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chaird
 * @create 2020-12-30 21:38
 */
@Service
public class StudentService {

  @Autowired private StudentDao studentDao;

  public List<Student> getAllSlave() {
    return studentDao.selectByExample(new StudentExample());
  }

  @Master
  public List<Student> getAllMaster() {
    return studentDao.selectByExample(new StudentExample());
  }

  public void add(Student student) {
    studentDao.insert(student);
  }
}
