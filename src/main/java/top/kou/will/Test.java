package top.kou.will;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;

/**
 * Created by Administrator on 2017/3/10.
 */
public class Test {

    public static void main(String[] args) {

        HttpClient httpClient = new HttpClient();
        GetMethod get = new GetMethod("http://www.baidu.com/");
        try {
            int num = httpClient.executeMethod(get);
            System.out.println(num);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(get.getResponseBodyAsString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
