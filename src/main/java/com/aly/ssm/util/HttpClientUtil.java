package com.aly.ssm.util;

import com.aly.ssm.model.HttpResult;
import com.aly.ssm.util.model.commonLog;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author lizhen
 * @Date 2017/8/21 16:04
 */
@Service
public class HttpClientUtil extends commonLog {
    @Autowired
    private CloseableHttpClient httpClient;
    @Autowired
    private RequestConfig requestConfig;
    @Autowired
    private PoolingHttpClientConnectionManager manager;

    /**
     * 执行GET请求
     *
     * @param url
     * @return
     * @throws IOException
     * @throws ClientProtocolException
     */
    public String doGet(String url) throws ClientProtocolException,
            IOException {
        // 创建http GET请求  
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(this.requestConfig);

        CloseableHttpResponse response = null;
        try {
            // 执行请求  
            response = httpClient.execute(httpGet);
            // 判断返回状态是否为200  
            if (response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(response.getEntity(), "UTF‐8");
            }
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return null;
    }

    /**
     * 带有参数的GET请求
     *
     * @param url
     * @param params
     * @return
     * @throws URISyntaxException
     * @throws IOException
     * @throws ClientProtocolException
     */
    public String doGet(String url, Map<String, String> params)
            throws ClientProtocolException, IOException,
            URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(url);
        for (String key : params.keySet()) {
            uriBuilder.addParameter(key, params.get(key));
        }
        return this.doGet(uriBuilder.build().toString());
    }

    /**
     * 执行POST请求
     *
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public HttpResult doPost(String url, Map<String, String> params)
            throws IOException {
        // 创建http POST请求  
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(this.requestConfig);
        if (params != null) {
            // 设置2个post参数，一个是scope、一个是q  
            List<NameValuePair> parameters = new ArrayList<NameValuePair>
                    ();
            for (String key : params.keySet()) {
                parameters.add(new BasicNameValuePair(key, params.get(key)));
            }
            // 构造一个form表单式的实体  
            UrlEncodedFormEntity formEntity = new
                    UrlEncodedFormEntity(parameters, "UTF‐8");
            // 将请求实体设置到httpPost对象中  
            httpPost.setEntity(formEntity);
        }

        CloseableHttpResponse response = null;
        try {
            // 执行请求  
            response = httpClient.execute(httpPost);
            return new
                    HttpResult(response.getStatusLine().getStatusCode(),
                    EntityUtils.toString(response.getEntity(), "UTF‐8"));
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    /**
     * 执行POST请求
     *
     * @param url
     * @return
     * @throws IOException
     */
    public HttpResult doPost(String url) throws IOException {
        return this.doPost(url, null);
    }

    /**
     * 提交json数据
     *
     * @param url
     * @param json
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public String postSendHttp(String url, String json, String str) {
        //  创建http  POST请求
        long start = System.currentTimeMillis();
        String rst = null;
        if (url == null || "".equals(url)) {
            logger.info("request  url  is  empty.");
            return rst;
        }
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(this.requestConfig);

        if (json != null) {
            //  构造一个form表单式的实体
            StringEntity stringEntity = new StringEntity(json,
                    ContentType.APPLICATION_JSON);
            //  将请求实体设置到httpPost对象中
            httpPost.setEntity(stringEntity);
        }

        CloseableHttpResponse response = null;
        BufferedReader br = null;
        InputStreamReader isr = null;
        try {
            //  执行请求
            response = this.httpClient.execute(httpPost);
            //  响应分析
            HttpEntity entity = response.getEntity();
            isr = new InputStreamReader(entity.getContent(), "UTF-8");
            br = new BufferedReader(isr);
            StringBuffer responseString = new StringBuffer();
            String result = br.readLine();
            while (result != null) {
                responseString.append(result);
                result = br.readLine();
            }
            long end = System.currentTimeMillis();
            logger.info("请求[" + url + "]消耗时间  " + (end - start)
                    + "毫秒");
            rst = responseString.toString();
        } catch (Exception e) {
            logger.error("post  req  error:", e);
//            JSONObject backJson = new JSONObject();
//            backJson.put("code", BackEnum.REQUESTERROR.getCode());
//            backJson.put("errorMsg", BackEnum.REQUESTERROR.getMsg());
//              rst = backJson.toJSONString();
            rst = ResultUtil.error("500", "post请求网络异常").toString();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.error("连接关闭异常：", e);
                }
            }
        }
        logger.info("rst:" + rst);
        logger.info("PoolStats：== = " + manager.getTotalStats());
        return rst;
    }
}
