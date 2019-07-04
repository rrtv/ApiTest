package model;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *postcase表对应的实体类
 */
public class PostCase {

    //postcase表的所有字段
    private int id;
    private String testName;
    private String protocal;
    private String address;
    private String checkpoint;
    private String passcriteria;
    private String status;
    private String key1;
    private String key1Value;
    private String key2;
    private String key2Value;
    private String key3;
    private String key3Value;
    private String key4;
    private String key4Value;

    public int getId() {
        return id;
    }

    public String getTest_name() {
        return testName;
    }

    public String getProtocal() {
        return protocal;
    }

    public String getAddress() {
        return address;
    }

    public String getCheckpoint() {
        return checkpoint;
    }

    public String getPasscriteria() {
        return passcriteria;
    }

    public String getStatus() {
        return status;
    }

    public String getKey1() {
        return key1;
    }

    public String getKey1Value() {
        return key1Value;
    }

    public String getKey2() {
        return key2;
    }

    public String getKey2Value() {
        return key2Value;
    }

    public String getKey3() {
        return key3;
    }

    public String getKey3Value() {
        return key3Value;
    }

    public String getKey4() {
        return key4;
    }

    public String getKey4Value() {
        return key4Value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTest_name(String testName) {
        this.testName = testName;
    }

    public void setProtocal(String protocal) {
        this.protocal = protocal;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCheckpoint(String checkpoint) {
        this.checkpoint = checkpoint;
    }

    public void setPasscriteria(String passcriteria) {
        this.passcriteria = passcriteria;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public void setKey1Value(String key1Value) {
        this.key1Value = key1Value;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public void setKey2Value(String key2Value) {
        this.key2Value = key2Value;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public void setKey3Value(String key3Value) {
        this.key3Value = key3Value;
    }

    public void setKey4(String key4) {
        this.key4 = key4;
    }

    public void setKey4Value(String key4Value) {
        this.key4Value = key4Value;
    }

    public List<NameValuePair> getKeyAndValue(){
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        if (this.key1!=null && this.key1Value!=null){
            NameValuePair pair = new BasicNameValuePair(this.key1, this.key1Value);
            params.add(pair);
        }
        if (this.key2!=null && this.key2Value!=null){
            NameValuePair pair = new BasicNameValuePair(this.key2, this.key2Value);
            params.add(pair);
        }
        if (this.key3!=null && this.key3Value!=null){
            NameValuePair pair = new BasicNameValuePair(this.key3, this.key3Value);
            params.add(pair);
        }
        if (this.key4!=null && this.key4Value!=null){
            NameValuePair pair = new BasicNameValuePair(this.key4, this.key4Value);
            params.add(pair);
        }
        return  params;
    }

    @Override
    public String toString(){
        return "postcase toString() 打印内容";
    }
}
