package com.example.service;

import com.example.dao.PersonDao;
import com.example.entity.Person;
import com.example.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author chaird
 * @create 2021-03-05 23:47
 */
@Service
public class StudentService {

  @Autowired private PersonDao personDao;

  public Object selectStudent() {
    List<Person> students = personDao.selectByExample(null);
    return students;
  }

  // 不生效1
  @Transactional
  public void transactionalNotEffect01() {
    try {
      Person p1 = new Person();
      p1.setName(LocalDateTime.now().toString());
      personDao.insertSelective(p1);
      int i = 1 / 0;
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("my error");
    }
  }

  // 不生效2
  @Transactional
  protected void transactionalNotEffect02() {
    Person p1 = new Person();
    p1.setName(LocalDateTime.now().toString());
    personDao.insertSelective(p1);
    int i = 1 / 0;
  }

  // 不生效3
  public void transactionalNotEffect03() {
    this.addPerson();
  }

  @Transactional
  public void addPerson() {
    Person p1 = new Person();
    p1.setName(LocalDateTime.now().toString());
    personDao.insertSelective(p1);
    int i = 1 / 0;
  }
  // 不生效4
  @Transactional(propagation = Propagation.NOT_SUPPORTED)
  public void transactionalNotEffect04() {
    Person p1 = new Person();
    p1.setName(LocalDateTime.now().toString());
    personDao.insertSelective(p1);
    int i = 1 / 0;
  }
  // 不生效5
  @Transactional(propagation = Propagation.REQUIRED,rollbackFor = MyException.class)
  public void transactionalNotEffect05() {
    Person p1 = new Person();
    p1.setName(LocalDateTime.now().toString());
    personDao.insertSelective(p1);
    int i = 1 / 0;
  }
}
