package com.example.administrator.demogit.nets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.demogit.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2016/10/21 0021.
 */
public class TestNet extends Activity {
    private Map<String,Object> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);

    }
public void get(View view){
  DoNet();
    //DO();
}

    private void DO() {
        AsyncHttpClient a=new AsyncHttpClient();
        a.addHeader("apikey","392aaf68a9e2a91f79eb11bf9860f7ed");
        RequestParams p=new RequestParams();
        p.put("cityname","郑州");
        a.get(this, Contast.URL, p, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    System.out.println("----天气-"+new String(responseBody,"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void DoNet() {
     HttpUtils httpUtils=new HttpUtils() {
         @Override
         public void OnNetSucess(int statusCode, Header[] headers, String Json) {
             System.out.println("----天气-"+Json);
         }

         @Override
         public void OnNetFail(int statusCode, Header[] headers, String Json, String error) {

         }
     };map=new HashMap<String, Object>();
        map.put("yue",1);//392aaf68a9e2a91f79eb11bf9860f7ed
        map.put("ri",2);

        httpUtils.DoGet(map,Contast.HisURL, "apikey", "392aaf68a9e2a91f79eb11bf9860f7ed", TestNet.this);
    }
}
