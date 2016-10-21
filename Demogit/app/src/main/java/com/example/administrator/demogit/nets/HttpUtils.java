package com.example.administrator.demogit.nets;

import android.content.Context;
import android.text.TextUtils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.Map;
import java.util.Objects;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2016/10/21 0021.
 */
public abstract class HttpUtils {
    public static AsyncHttpClient client=new AsyncHttpClient();
   private RequestParams p;
    public synchronized static AsyncHttpClient getClient(){
        if(client==null){
            client=new AsyncHttpClient();
        }
        return client;
    }
    public abstract void OnNetSucess(int statusCode, Header[] headers, String Json);
    public abstract void OnNetFail(int statusCode, Header[] headers, String Json,String error);
  public void DoGet(Map<String,Object>map,String Url,String HeadName,String HeadValues,Context ctx){
      p=new RequestParams();

      for(Map.Entry<String,Object> m:map.entrySet()){
          String key = m.getKey();
          Object value = m.getValue();
          p.put(key,value);
      }
      if(!TextUtils.isEmpty(HeadName)&&!TextUtils.isEmpty(HeadValues))
      {
          getClient().addHeader(HeadName,HeadValues);
      }

      getClient().get(ctx,Url,p, new AsyncHttpResponseHandler() {
          @Override
          public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
           OnNetSucess(statusCode,headers,new String(responseBody));
          }

          @Override
          public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
              OnNetFail(statusCode,headers,new String(responseBody),error.getMessage());
          }
      });

  }
    public void DoPost(Map<String,String>map,String Url,String HeadName,String HeadValues){
           p=new RequestParams();


        for(Map.Entry<String,String> m:map.entrySet()){
            String key = m.getKey();
            String value = m.getValue();
            p.put(key,value);
        }
        if(!TextUtils.isEmpty(HeadName)&&!TextUtils.isEmpty(HeadValues))
        {
            getClient().addHeader(HeadName,HeadValues);
        }

        getClient().post(Url, p, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                OnNetSucess(statusCode,headers,new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                OnNetFail(statusCode,headers,new String(responseBody),error.getMessage());
            }
        });

    }

}
