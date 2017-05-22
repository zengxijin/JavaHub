package org.jackzeng.autorule.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by XijinZeng on 2017/5/22.
 */
public class RestTest {

    @Test
    public void restTest() throws Exception {
        Map<String,String> headers = new HashMap<>();
        headers.put("Authorization","Basic a2llc2VydmVyOmtpZXNlcnZlcg==");
        headers.put("Accept","application/json");
        headers.put("Content-Type","application/json");

        String url = "http://172.29.150.140:10000/kie-server/services/rest/server/containers/instances/kie-server-performance1.0";

        String body =
                        "{                                                 " +      "\n" +
                        "	\"lookup\": \"autorule-stateless\",            " +      "\n" +
                        "	\"commands\": [                                " +      "\n" +
                        "	{                                              " +      "\n" +
                        "		\"insert\": {                              " +      "\n" +
                        "			\"return-object\": true,               " +      "\n" +
                        "			\"object\": {                          " +      "\n" +
                        "				\"org.jackzeng.autobean.Bean$index\": { " + "\n" +
                        "					\"field$x1\": \"String\",        " +    "\n" +
                        "					\"field$x2\":102.0,              " +    "\n" +
                        "					\"field$x3\":true,               " +    "\n" +
                        "					\"fild$x4\":100                  " +    "\n" +
                        "				}                                  " +      "\n" +
                        "			}                                      " +      "\n" +
                        "		}                                          " +      "\n" +
                        "	},                                             " +      "\n" +
                        "	                                               " +      "\n" +
                        "	{                                              " +      "\n" +
                        "		\"fire-all-rules\": \"\"                   " +      "\n" +
                        "	},                                             " +      "\n" +
                        "	{                                              " +      "\n" +
                        "			\"get-objects\":{                      " +      "\n" +
                        "                \"out-identifier\":\"myobject\"   " +      "\n" +
                        "            }                                     " +      "\n" +
                        "	}                                              " +      "\n" +
                        "	                                               " +      "\n" +
                        "	]                                              " +      "\n" +
                        "}                                                 ";


        for(int i=2; i < 1001; i++){
            String reqBody = body;
            reqBody = reqBody.replace("$index",String.valueOf(i));
            reqBody = reqBody.replace("$x1",String.valueOf(i+1));
            reqBody = reqBody.replace("$x2",String.valueOf(i+2));
            reqBody = reqBody.replace("$x3",String.valueOf(i+3));
            reqBody = reqBody.replace("$x4",String.valueOf(i+4));

            genRestBody("rule_" + String.valueOf(i) + ".json",reqBody);
            String ret = CloseableHttpHelper.postRequest(url,reqBody,headers);
            System.out.println(ret);
            Thread.currentThread().sleep(100);
        }
    }

    public void genRestBody(String fileName,String body){
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))) {
            writer.write(body);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static class CloseableHttpHelper {
        private static final Logger LOGGER = LoggerFactory.getLogger(CloseableHttpHelper.class);

        public static String postRequest(String url, String requestbody, Map<String, String> headers,
                                         int connTimeoutSeconds,int socketTimeoutSeconds)
                throws Exception{

            LOGGER.info(CloseableHttpHelper.class + " url=" + url + " requestbody=" + requestbody + " headers="
                    + headers + " connTimeoutSeconds=" + connTimeoutSeconds + " socketTimeoutSeconds=" + socketTimeoutSeconds );

            String result = null;

            /**DefaultHttpRequestRetryHandler 默认会重试3次*/
            CloseableHttpClient httpClient = HttpClientBuilder.create().setRetryHandler(new DefaultHttpRequestRetryHandler()).build();
            CloseableHttpResponse response = null;
            HttpPost httpPost = null;

            try {
                httpPost = new HttpPost(url);
                //请求头非空，进行组装
                if ((headers != null) && (headers.isEmpty() == false)) {
                    for (Map.Entry<String, String> entryLoc : headers.entrySet()) {
                        httpPost.addHeader(entryLoc.getKey(), entryLoc.getValue());
                    }
                }
                //连接和响应超时设置，必须大于0
                if(connTimeoutSeconds > 0 && socketTimeoutSeconds > 0){
                    RequestConfig.Builder customReqConf = RequestConfig.custom()
                            .setConnectTimeout(connTimeoutSeconds*1000)
                            .setSocketTimeout(socketTimeoutSeconds*1000);
                    httpPost.setConfig(customReqConf.build());
                }
                //请求body
                StringEntity stringEntity = new StringEntity(requestbody,"UTF-8");
                httpPost.setEntity(stringEntity);

                //post request
                response = httpClient.execute(httpPost);

                //get response
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity, "UTF-8");

                if(response.getStatusLine().getStatusCode() != 200) {
                    LOGGER.info("statusCode：" + response.getStatusLine().getStatusCode());
                }

                return result;

            } catch (Exception e) {
                LOGGER.error("error: " + e);
                throw e;
            } finally {
                if(response != null){
                    response.close();
                }
                if(httpClient != null){
                    httpClient.close();
                }
            }
        }

        public static String postRequest(String url, String requestbody, Map<String, String> headers) throws Exception{
            return postRequest(url,requestbody,headers,5,60);
        }
    }
}
