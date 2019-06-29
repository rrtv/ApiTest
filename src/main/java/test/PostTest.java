package test;

import javafx.geometry.Pos;
import mapper.PostCaseMapper;
import model.PostCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class PostTest extends TestAPI {
    private static SqlSessionFactory sessionFactory;

    @BeforeClass
    public static void init(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test(){
        SqlSession openSession = sessionFactory.openSession();
        try{
//            List<PostCase> postCaseList = openSession.selectList("SelectPostCase");
//            printPostCaseList(postCaseList);

            PostCase postCase = openSession.selectOne("mapper.PostCaseMapper.selectById");
            System.out.println(postCase);

//            PostCaseMapper mapper = openSession.getMapper(PostCaseMapper.class);
//            PostCase postCase2 = mapper.selectById(1);
//            System.out.println(postCase2);


        }finally {
            openSession.close();
        }
    }

    private void printPostCaseList(List<PostCase> PostCaseList){
        for (PostCase postCase:PostCaseList){
            System.out.println("postcase的address"+postCase.getAddress());
        }
    }
}
