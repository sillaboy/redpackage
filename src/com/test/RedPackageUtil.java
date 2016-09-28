package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yunlong.zhang on 2016/9/27.
 */
public class RedPackageUtil {

    private volatile static RedPackageUtil singletion;
    private static final boolean LOG_ENABLE = false;
    private static Logger log ;

    private RedPackageUtil(){};

    public static RedPackageUtil getInstace() {
        if (singletion == null) {
            synchronized (RedPackageUtil.class) {
                if(singletion == null) {
                    singletion = new RedPackageUtil();
                    log = LoggerFactory.getLogger(RedPackageUtil.class);
                }
            }
        }
        return singletion;
    }

    /**
     * 鍔犲叆璇佷功鐨勫垽鏂�
     * param requestUrl
     * @param requestMethod
     * @param outputStr
     * @return
     */
    public Map<String, Object> xmlToMapHttpRequestByCert(String requetsUrl,
                                                                String requestMethod, String outputStr) {
        StringBuffer buffer = httpsRequestByCert2(requetsUrl,requestMethod,outputStr);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer.toString().getBytes());
        return  StreamUtils.parseXml(byteArrayInputStream);
    }

    public StringBuffer httpsRequestByCert2(String requestUrl,
                                                   String requestMethod, String outputStr) {
        StringBuffer buffer = new StringBuffer();
        Map<String, Object> map = new HashMap<String, Object>();
        FileInputStream keyInputStream = null;
        try {
            // 鍒涘缓SSLContext瀵硅薄锛屽苟浣跨敤鎴戜滑鎸囧畾鐨勪俊浠荤鐞嗗櫒鍒濆鍖�
            TrustManager[] tm = { new MyX509TrustManager() };
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyInputStream = new FileInputStream(new File(
                    "/usr/local/id/apiclient_cert.p12"));///usr/local/id/apiclient_cert.p12
            if (LOG_ENABLE) {
                if (keyInputStream == null) {
                    log.debug("load input stream failed!");
                } else {
                    log.debug("load input stream success!");
                }
            }

            try {
                keyStore.load(keyInputStream, "key179102".toCharArray());
            } finally {
                keyInputStream.close();
            }

            if (LOG_ENABLE) {
                log.debug("load keystoe finished!");
            }

            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(keyStore, "key179102".toCharArray());
            sslContext.init(kmf.getKeyManagers(), null, null);

            if (LOG_ENABLE) {
                log.debug("sslContext finished!");
            }
            // 浠庝笂杩癝SLContext瀵硅薄涓緱鍒癝SLSocketFactory
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 璁剧疆璇锋眰鏂瑰紡锛圙ET/POST锛�
            conn.setRequestMethod(requestMethod);

            // 褰搊utputStr涓嶄负null鏃讹紝鎯宠緭鍑烘祦鍐欐暟鎹�
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 娉ㄦ剰缂栧啓鏍煎紡
                outputStream.write(outputStr.getBytes("utf-8"));
                outputStream.close();
            }

            // 浠庤緭鍏ユ祦涓鍙栬繑鍥炴暟鎹�
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(
                    inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(
                    inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            // 閲婃斁璧勬簮
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
