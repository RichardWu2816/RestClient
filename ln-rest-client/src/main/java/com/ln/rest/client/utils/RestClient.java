package com.ln.rest.client.utils;

import com.ln.rest.client.constants.AppConstants;
import com.ln.rest.client.model.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;

public class RestClient {

    private static final Logger logger = LoggerFactory.getLogger(RestClient.class);

    public static void main(String[] args) {

        RestClient restClient = new RestClient();
        restClient.test_http();
        restClient.test_https();

    }

    public void test_http() {
        String url = "http://localhost:7081/v1/sftp?uuid=ce7c16b1-97db-4dbf-a7e4-1a681b8bb083";

        String username = "STX10010";
        String password = "TEST_PWD2";

        invokeRestGetService(url, username, password);
    }

    public void test_https() {
        String url = "https://dev-dkr-eng.sandata.com/interfaces/intake/uat/v1/sftp?uuid=762c4518-2e80-4c69-80e7-55d79f493a58";

        String username = "STX10010";
        String password = "TEST_PWD2";

        invokeRestGetService(url, username, password);
    }

    public Response invokeRestGetService(String url, String username, String password) {

        SSLContext sslContext = createSSLContext();

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);

        RestTemplate restTemplate = new RestTemplate(requestFactory);

        HttpHeaders requestHeaders = createHeaders(username, password);
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Response> responseData = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Response.class);

        Response response = responseData.getBody();
        logger.debug(response.toString());
        logger.debug(responseData.getStatusCode() + "");

        return response;
    }

    private HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }

    private SSLContext createSSLContext() {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
        SSLContext sslContext = null;
        try {
            sslContext = org.apache.http.ssl.SSLContexts.custom()
                    .loadTrustMaterial(null, acceptingTrustStrategy)
                    .build();
        } catch (KeyStoreException e) {
            logger.error(e.getMessage(), e);
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
        } catch (KeyManagementException e) {
            logger.error(e.getMessage(), e);
        }
        return sslContext;
    }

    public <T> Response invokeRestPostService(String url, String username, String password, List<T> entityList) {

        SSLContext sslContext = createSSLContext();

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);

        RestTemplate restTemplate = new RestTemplate(requestFactory);

        HttpHeaders requestHeaders = createHeaders(username, password);
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        // Note the body object as first parameter!
        String jsonString = AppConstants.GSON.toJson(entityList);
        HttpEntity<?> httpEntity = new HttpEntity<Object>(jsonString, requestHeaders);

        ResponseEntity<Response> responseData = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Response.class);

        Response response = responseData.getBody();
        logger.debug(response.toString());
        logger.debug(responseData.getStatusCode() + "");

        return response;
    }

 }