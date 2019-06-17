package api;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ExcelProcess;
import utils.JSONParser;
import client.RestfulClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestGet extends TestAPI{
    RestfulClient client;
    JSONObject responseBody;
    JSONParser jParser;
    int responseCode;
    String code;
    String url;
    String postBody;
    Object[][] excelData;
    HashMap<String, String> hashHead;

    //测试类继承TestAPI类，setup方法读取excel表单，设置好请求头部，testPostRequest发送请求并分析结果。
    @BeforeClass
    public void setup() throws ClientProtocolException, IOException {
        //读取用例excel
        excelData = ExcelProcess.proessExcel(excelPath, 0);

        //实例化client
        client = new RestfulClient();

        //设置好请求头部
        hashHead = new HashMap<String, String>();
        hashHead.put("Content-Type", "application/x-www-form-urlencoded");
        hashHead.put("token","rrtv-3b6c27f7a2ec08bdae6c95b631968891f897a95e");
        hashHead.put("clientType","ios_rrsp_jzsp");
        hashHead.put("clientVersion","4.2.1");
    }

    @Test
    public void testGetRequest() throws ClientProtocolException, IOException {
        //从第二行开始遍历表单，跳过表头
        for(int i=1;i<excelData.length;i++){
            //从特定位置读取测试数据
            String address = excelData[i][3].toString();
            url = host+address;
            String checkPoint = excelData[i][4].toString();
            String checkValue = excelData[i][5].toString();


            //发出请求
            client.getResponse(url,hashHead);

            responseBody = client.getBodyInJSON();
            responseCode = client.getCodeInNumber();


            JSONParser jParser = new JSONParser();
            boolean result = jParser.isResponseCorrect(responseBody, checkPoint, checkValue);

            //断言判断结果
            Assert.assertTrue(result);
            Assert.assertEquals(responseCode, 200);

        }
    }


}
