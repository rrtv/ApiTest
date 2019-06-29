package test;

public class TestPost extends TestAPI{




//    public static void main(String[] args) {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = TestPost.class.getClassLoader().getResourceAsStream(resource);
//        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//
//        SqlSession session = sessionFactory.openSession();
//
//        String statement = "mapper.postCase.getPostCase";
//        PostCase postCase= session.selectOne(statement, 1);
//        System.out.println(postCase);
//
//    }

//    public void test() throws IOException {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        PostCase postCase = sqlSession.selectOne("sqlmap.postCase.test.getPostCase", 1);
//        System.out.println(postCase);
//        sqlSession.close();
//    }

//    public static void main(String[] args) throws IOException {
//        new TestPost().test();
//    }

}
