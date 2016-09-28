package com.test;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by yunlong.zhang on 2016/9/26.
 */
public class RedPackageTest {
    public final static void main(String[] args) {
    	 Map<String, Object> responseMap = new HashMap<String, Object>();
         SortedMap<String,Object> reqMap = new TreeMap<>();
         reqMap.put("nonce_str","C380BEC2BFD727A4B6845133519F3AD6");
         reqMap.put("mch_billno","1369179102201619260422184052");
         reqMap.put("mch_id", "12222222102");
         reqMap.put("wxappid","wxasdas51f178");
         reqMap.put("send_name","dd");
         reqMap.put("re_openid","ola88v2Ivz383z7xGM_1dadqVmWw");
         reqMap.put("total_amount",100);
         reqMap.put("total_num",1);
         reqMap.put("wishing","恭喜发财!");
         reqMap.put("client_ip", "192.168.0.1");///
         reqMap.put("act_name","2.0抢红包活动");
         reqMap.put("remark","点的越多。。");
         String reqstrTemp = "act_name=" + reqMap.get("act_name") +
                 "&client_ip=" + reqMap.get("client_ip") +
                 "&mch_billno=" + reqMap.get("mch_billno")+
                 "&mch_id=" + reqMap.get("mch_id") +
                 "&nonce_str=" + reqMap.get("nonce_str") +
                 "&re_openid=" + reqMap.get("re_openid") +
                 "&remark=" + reqMap.get("remark") +
                 "&send_name=" + reqMap.get("send_name") +
                 "&total_amount=" + reqMap.get("total_amount") +
                 "&total_num=" + reqMap.get("total_num") +
                 "&wishing=" + reqMap.get("wishing") +
                 "&wxappid=" + reqMap.get("wxappid") +
                 "&key=7sDhjrX2oM9SXbZS48gxaUTdh2n1PDy4";
         String sign = Md5Encode.MD5Encode(reqstrTemp).toUpperCase();
         String xml = "<xml>" +
                 "<act_name>"+reqMap.get("act_name")+"</act_name>" +
                 "<client_ip>"+reqMap.get("client_ip")+"</client_ip>" +
                 "<mch_billno>"+reqMap.get("mch_billno") + "</mch_billno>" +
                 "<mch_id>"+reqMap.get("mch_id") + "</mch_id>" +
                 "<nonce_str>"+reqMap.get("nonce_str") + "</nonce_str>" +
                 "<re_openid>"+reqMap.get("re_openid")+"</re_openid>" +
                 "<remark>"+reqMap.get("remark")+"</remark>" +
                 "<send_name>"+reqMap.get("send_name") + "</send_name>" +
                 "<total_amount>"+reqMap.get("total_amount")+"</total_amount>" +
                 "<total_num>"+reqMap.get("total_num")+"</total_num>" +
                 "<wishing>"+reqMap.get("wishing")+"</wishing>" +
                 "<wxappid>"+reqMap.get("wxappid") + "</wxappid>" +
                 "<sign>"+sign+"</sign>" +
                 "</xml>";
         httpsRequestByCert2("https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack", "POST", xml);
    }  
    
    public void sendRedPackage() throws Exception{
    	 Map<String, Object> responseMap = new HashMap<String, Object>();
         SortedMap<String,Object> reqMap = new TreeMap<>();
         reqMap.put("nonce_str","C380BEC2BFD727A4B6845133519F3AD6");
         reqMap.put("mch_billno","1369179102201619260422184052");
         reqMap.put("mch_id", "1sdsdsf02");
         reqMap.put("wxappid","wx3ab237a7fd751f17f8");
         reqMap.put("send_name","name");
         reqMap.put("re_openid","openid");
         reqMap.put("total_amount",100);
         reqMap.put("total_num",1);
         reqMap.put("wishing","恭喜发财!");
         reqMap.put("client_ip", "192.168.2.1");///
         reqMap.put("act_name","抢红包活动");
         reqMap.put("remark","点的越多。。");
         String reqstrTemp = "act_name=" + reqMap.get("act_name") +
                 "&client_ip=" + reqMap.get("client_ip") +
                 "&mch_billno=" + reqMap.get("mch_billno")+
                 "&mch_id=" + reqMap.get("mch_id") +
                 "&nonce_str=" + reqMap.get("nonce_str") +
                 "&re_openid=" + reqMap.get("re_openid") +
                 "&remark=" + reqMap.get("remark") +
                 "&send_name=" + reqMap.get("send_name") +
                 "&total_amount=" + reqMap.get("total_amount") +
                 "&total_num=" + reqMap.get("total_num") +
                 "&wishing=" + reqMap.get("wishing") +
                 "&wxappid=" + reqMap.get("wxappid") +
                 "&key=7sDhjrX2oM9SXbZS48gxaUTdh2n1PDy4";
         String sign = Md5Encode.MD5Encode(reqstrTemp).toUpperCase();
         String xml = "<xml>" +
                 "<act_name>"+reqMap.get("act_name")+"</act_name>" +
                 "<client_ip>"+reqMap.get("client_ip")+"</client_ip>" +
                 "<mch_billno>"+reqMap.get("mch_billno") + "</mch_billno>" +
                 "<mch_id>"+reqMap.get("mch_id") + "</mch_id>" +
                 "<nonce_str>"+reqMap.get("nonce_str") + "</nonce_str>" +
                 "<re_openid>"+reqMap.get("re_openid")+"</re_openid>" +
                 "<remark>"+reqMap.get("remark")+"</remark>" +
                 "<send_name>"+reqMap.get("send_name") + "</send_name>" +
                 "<total_amount>"+reqMap.get("total_amount")+"</total_amount>" +
                 "<total_num>"+reqMap.get("total_num")+"</total_num>" +
                 "<wishing>"+reqMap.get("wishing")+"</wishing>" +
                 "<wxappid>"+reqMap.get("wxappid") + "</wxappid>" +
                 "<sign>"+sign+"</sign>" +
                 "</xml>";
         KeyStore keyStore  = KeyStore.getInstance("PKCS12");
         FileInputStream instream = new FileInputStream(new File("D:/cert/apiclient_cert.p12"));
         try {
             System.out.println("load cert");
             keyStore.load(instream, "1369179102".toCharArray());
         } finally {
             instream.close();
         }
         // Trust own CA and all self-signed certs
         SSLContext sslcontext = SSLContexts.custom()
                 .loadKeyMaterial(keyStore, "1369179102".toCharArray())
                 .build();
         // Allow TLSv1 protocol only
         SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                 sslcontext,
                 new String[] { "TLSv1" },
                 null,
                 SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
         CloseableHttpClient httpclient = HttpClients.custom()
                 .setSSLSocketFactory(sslsf)
                 .build();
         System.out.println("ssl connected !");
         StringBuffer result = new StringBuffer();
         try {
             HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack");
             /*
             StringEntity reqEntity  = new StringEntity(xml,"UTF-8");
             reqEntity.setContentType("application/x-www-form-urlencoded");
             httpPost.setEntity(reqEntity);
             */

             httpPost.addHeader("Connection", "keep-alive");
             httpPost.addHeader("Accept", "*/*");
             httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
             httpPost.addHeader("Host", "api.mch.weixin.qq.com");
             httpPost.addHeader("X-Requested-With", "XMLHttpRequest");
             httpPost.addHeader("Cache-Control", "max-age=0");
             httpPost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
             httpPost.setEntity(new StringEntity(xml, "UTF-8"));
             System.out.println("executing request" + httpPost.getRequestLine());
             
             CloseableHttpResponse response = httpclient.execute(httpPost);
             try {
                 System.out.println("get response !!");
                 HttpEntity entity = response.getEntity();
                 if (entity != null) {
                     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(),"UTF-8"));
                     String text;
                     while ((text = bufferedReader.readLine()) != null) {
                     	result.append(text);
                     }
                 }
                 EntityUtils.consume(entity);
             } finally {
                 response.close();
             }
         } finally {
             httpclient.close();
         }
         System.out.println(result.toString());
         ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(result.toString().getBytes());
         Map<String, Object> resultMap = StreamUtils.parseXml(byteArrayInputStream);
         System.out.println(resultMap.toString());
    }

	public static StringBuffer httpsRequestByCert2(String requestUrl,
			String requestMethod, String outputStr) {
		StringBuffer buffer = new StringBuffer();
		Map<String, Object> map = new HashMap<String, Object>();
		FileInputStream keyInputStream = null;
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			keyInputStream = new FileInputStream(new File(
					"D:/cert/apiclient_cert.p12"));///usr/local/id/apiclient_cert.p12
			keyStore.load(keyInputStream, "1369179102".toCharArray());
			SSLContext sslContext = SSLContexts.custom()
					.loadKeyMaterial(keyStore, "1369179102".toCharArray())
					.build();

			// 从上述SSLContext对象中得到SSLSocketFactory
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);

			// 当outputStr不为null时，想输出流写数据
			if (null != outputStr) {
				OutputStream outputStream = conn.getOutputStream();
				// 注意编写格式
				outputStream.write(outputStr.getBytes("utf-8"));
				outputStream.close();
			}

			// 从输入流中读取返回数据
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);				
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(buffer);
		return buffer;
	}
}
