import com.njj.bean.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    private SqlSession sqlSession;
    @Before

    public void before() throws Exception {
        //加载并读取xml
        String path = "SqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(path);
        //sql 链接的工厂 类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
        System.out.println("sqlSession = " + sqlSession);//.sqlsession. = . org. apache . ibatis. session. defaul ts . Defaul tSq lSession@71423665
        //sqlSession.close();
    }
    //全查  select *from person
    @Test
    public void test01()  {
        //mybatis
        List<Person> personList = sqlSession.selectList("com.njj.dao.PersonDao.selectAll");
        for (Person person : personList) {
            System.out.println("person = " + person);
        }
        sqlSession.close();
    }
}
