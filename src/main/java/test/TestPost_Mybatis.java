package test;

import client.RestfulClient;
import com.alibaba.fastjson.JSONObject;
import model.PostCase;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.JSONParser;

import java.io.IOException;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TestPost_Mybatis extends TestAPI {
    RestfulClient client;
    JSONObject responseBody;
    int responseCode;
    HashMap<String, String> hashHead;
    SqlSessionFactory sessionFactory = null;

    @BeforeClass
    public void setup() throws ClientProtocolException, IOException {


        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }


        client = new RestfulClient();

        //设置好请求头部
        hashHead = new HashMap<String, String>();
        hashHead.put("Content-Type", "application/x-www-form-urlencoded");
        hashHead.put("token", "rrtv-f021ec952edaf4c615570a6957fa788105360aed");
        hashHead.put("clientType", "ios_rrsp_jzsp");
        hashHead.put("clientVersion", "4.1.5");
    }

    @Test
    public void testPostRequest()  throws  IOException {

        SqlSession openSession = sessionFactory.openSession();
        List<PostCase> data = openSession.selectList("mapper.PostCaseMapper.selectAll");

        for (int i=0; i<data.size(); i++){
            url = host + data.get(i).getAddress();

            //用NameValuePair存储所有请求参数
            List<NameValuePair> params = data.get(i).getKeyAndValue();


            //发出请求
            client.sendPost(url, params, hashHead);

            responseBody = client.getBodyInJSON();
            responseCode = client.getCodeInNumber();


            JSONParser jParser = new JSONParser();
            boolean result = jParser.isResponseCorrect(responseBody, data.get(i).getCheckpoint(), data.get(i).getPasscriteria());


            //断言判断结果
            Assert.assertTrue(result);
            Assert.assertEquals(responseCode, 200);
        }



    }
}
