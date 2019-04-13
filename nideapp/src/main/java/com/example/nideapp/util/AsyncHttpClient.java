package com.example.nideapp.util;

import android.os.AsyncTask;
import android.util.Log;

import com.google.common.io.ByteStreams;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Time:2019/4/13
 * Author:秦超蒙
 * Description:
 */
public class AsyncHttpClient {
    //单例模式
    private static final AsyncHttpClient ourInstance=new AsyncHttpClient();
    //恶汉式
    public static AsyncHttpClient getOurInstance(){
        return ourInstance;
    }

    //请求数据
    private String PostData(String DeUrl,String username,String pswd){
        HttpURLConnection httpURLConnection=null;
    try {
        URL url=new URL(DeUrl);
        HttpURLConnection connection =(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        //请求头信息

        String body = "phone=" + URLEncoder.encode(username) + "&pwd" + URLEncoder.encode(pswd);
      connection.getOutputStream().write(body.getBytes());
        int code = connection.getResponseCode();
        if (code==200){
            InputStream inputStream = connection.getInputStream();
            String s = new String(ByteStreams.toByteArray(inputStream));

        return s;

        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return null;
    }

    //设置接口
    public interface AsyncCallBack{
        void success(String result);
        void error(int errorcode, String message);
    }

    //接口回调
    public void postAsync(final String url, final String username, final String pswd,final AsyncCallBack asyncCallBack){
        new AsyncTask<String ,Void,String >(){
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                asyncCallBack.success(s);
            }

            @Override
            protected String doInBackground(String... strings) {

                return PostData(strings[0],strings[1],strings[2]);
            }
        }.execute(url,username,pswd);
    }


}
