package demo.untils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author CBeann
 * @create 2020-02-23 16:14
 */
public class MyBatisUntils {

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {
        Reader reader;
        try {
            reader = Resources.getResourceAsReader("mybatis.xml");
            if (sqlSessionFactory == null) {

                sqlSessionFactory = new SqlSessionFactoryBuilder()
                        .build(reader);
            }
            SqlSession sqlSession = sqlSessionFactory.openSession();

            return sqlSession;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
