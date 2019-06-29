package test;

import client.RestfulClient;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ExcelProcess;
import utils.JSONParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestPost_DB extends TestAPI {
    RestfulClient client;
    JSONObject responseBody;
    JSONParser jParser;
    int responseCode;
    String code;
    String url;//= "http://uat-api.rr.tv/v3plus/season/detail";
    String postBody;
    Object[][] excelData;
    HashMap<String, String> hashHead;

    //测试类继承TestAPI类，setup方法读取excel表单，设置好请求头部，testPostRequest发送请求并分析结果。
    @BeforeClass
    public void setup() throws ClientProtocolException, IOException {
        //读取用例excel
        excelData = ExcelProcess.proessExcel(excelPath, 1);

        //实例化client
        client = new RestfulClient();

        //设置好请求头部
        hashHead = new HashMap<String, String>();
        hashHead.put("Content-Type", "application/x-www-form-urlencoded");
        hashHead.put("token", "rrtv-f021ec952edaf4c615570a6957fa788105360aed");
        hashHead.put("clientType", "ios_rrsp_jzsp");
        hashHead.put("clientVersion", "4.1.5");
    }

    @Test(dataProvider = "dbDataMethod")
    public void testPostRequest_DB(Map<String, String> data) throws ClientProtocolException, IOException {
        //从第二行开始遍历表单，跳过表头
        List<String> param = new ArrayList<String>(data.values());

        //从特定位置读取测试数据
        String address = param.get(3);
        url = host + address;
        String checkPoint = param.get(4);
        String checkValue = param.get(5);
        //用NameValuePair存储所有请求参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        for (int i = 7; i < param.size() - 2; i = i + 2) {
            //因为每种请求的参数个数不确定，在这里进行非空判断
            if (param.get(i) == null || param.get(i + 1) == null) {
                continue;
            }
            NameValuePair pair = new BasicNameValuePair(param.get(i).toString(), param.get(i + 1).toString());
            params.add(pair);
        }

        //发出请求
        client.sendPost(url, params, hashHead);

        responseBody = client.getBodyInJSON();
        responseCode = client.getCodeInNumber();


        JSONParser jParser = new JSONParser();
        boolean result = jParser.isResponseCorrect(responseBody, checkPoint, checkValue);


        //断言判断结果
        Assert.assertTrue(result);
        Assert.assertEquals(responseCode, 200);


    }


}
