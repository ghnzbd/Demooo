package demo;

import demo.dao.UserDao;
import demo.entity.User;
import demo.untils.MyBatisUntils;
import org.apache.ibatis.session.SqlSession;

/**
 * @author CBeann
 * @create 2020-02-23 16:15
 */
public class Start {
    public static void main(String[] args) {

        SqlSession sqlSession = MyBatisUntils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.queryById(1);
        System.out.println(user);


         user = mapper.queryById(2);
        System.out.println(user);

        user.setUsername("temp1");
        mapper.update(user);


         user = mapper.queryById(2);
        System.out.println(user);
        sqlSession.close();

        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");


    }
}
