package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        String apiEndpoint="https://api.chucknorris.io/jokes/random";
        URIBuilder url = new URIBuilder(apiEndpoint);
        HttpGet data = new HttpGet(url.build());
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(data);
        System.out.println(response);
        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity resEntity = response.getEntity();
            String result = EntityUtils.toString(resEntity);
            System.out.println(result);
            JSONObject json = new JSONObject(result);
            System.out.println("final answer:");
            System.out.println(json);
        }
        else System.out.println("Error occured");


    }
}