package com.yangqingmang.utils;

import com.alibaba.fastjson.JSON;
import com.yangqingmang.config.HttpConfig;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * $DESCRIPTION$
 *
 * @author yangqingmang
 * @version 1.0
 * @date Create in 2018/10/3 下午6:16
 */
public class HttpUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * 发送post 请求
     * @param requestUrl
     * @param requestBody
     * @return
     */
    public static String sendPostRequest(String requestUrl, String requestBody) {

        String url = HttpConfig.getUrl(requestUrl);
        HttpPost post = null;
        try {
            post = new HttpPost(url);
            // 设置超时时间
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(15000).setSocketTimeout(15000)
                    .setConnectionRequestTimeout(15000).build();
            // 构造消消息参数
            post.setConfig(requestConfig);

            LOGGER.info("request body {}", requestBody);
            // 构建消息实体
            StringEntity entity = new StringEntity(requestBody, Charset.forName("UTF-8"));
            // 发送Json格式的数据请求
            entity.setContentType("application/json");
            post.setEntity(entity);

            HttpClient httpClient = HttpClientBuilder.create().build();


            HttpResponse response = httpClient.execute(post);

            // 检验返回码
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == HttpStatus.SC_OK){
                HttpEntity responseEntity = response.getEntity();
                if (null != responseEntity) {
                    String result = EntityUtils.toString(responseEntity);
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage(), e);
        }finally{
            if(post != null){
                try {
                    post.releaseConnection();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 发送post 请求
     * @param requestUrl
     * @return
     */
    public static String sendPostRequest(String requestUrl) {

        String url = HttpConfig.getUrl(requestUrl);
        HttpPost post = null;
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            post = new HttpPost(url);
            // 设置超时时间
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(15000).setSocketTimeout(15000)
                    .setConnectionRequestTimeout(15000).build();
            // 构造消消息参数
            post.setConfig(requestConfig);
            HttpResponse response = httpClient.execute(post);

            // 检验返回码
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == HttpStatus.SC_OK){
                HttpEntity responseEntity = response.getEntity();
                if (null != responseEntity) {
                    String result = EntityUtils.toString(responseEntity);
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage(), e);
        }finally{
            if(post != null){
                try {
                    post.releaseConnection();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 发送get请求
     * @param requestUrl
     * @param param
     * @return
     */
    public static String sendGetRequest(String requestUrl, Map<String, String> param) {

        String url = HttpConfig.getUrl(requestUrl);
        HttpGet httpGet = null;
        try {
            LOGGER.info("request param {}", JSON.toJSONString(param));

            StringBuffer paramBuffer = new StringBuffer();
            for (Map.Entry<String, String> entry : param.entrySet()) {
                paramBuffer.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            if (paramBuffer.length() > 0) {
                String paramStr = paramBuffer.substring(0, paramBuffer.length() - 1);
                url = url + "?" + paramStr;
            }

            HttpClient httpClient = HttpClientBuilder.create().build();
            httpGet = new HttpGet(url);
            // 设置超时时间
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(15000).setSocketTimeout(15000)
                    .setConnectionRequestTimeout(15000).build();
            // 构造消消息参数
            httpGet.setConfig(requestConfig);

            HttpResponse response = httpClient.execute(httpGet);

            // 检验返回码
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == HttpStatus.SC_OK){
                HttpEntity responseEntity = response.getEntity();
                if (null != responseEntity) {
                    String result = EntityUtils.toString(responseEntity);
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage(), e);
        }finally{
            if(httpGet != null){
                try {
                    httpGet.releaseConnection();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 发送get请求
     * @param requestUrl
     * @return
     */
    public static String sendGetRequest(String requestUrl) {
        return sendGetRequest(requestUrl, new HashMap<>());
    }
}
