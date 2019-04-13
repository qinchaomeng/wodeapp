package com.example.wodeapp.net;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import com.google.common.io.ByteStreams;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Time:2019/4/13
 * Author:秦超蒙
 * Description:
 */
public class AsyncHttpClient {
//单例模式
    private static final AsyncHttpClient ourInstance = new AsyncHttpClient();


    /*
     * 饿汉式
     * */
    public static AsyncHttpClient getInstance() {
        return ourInstance;
    }
    public void GetAsync(String server_url, final AsyncCallback callback) {
        //异步处理
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... strings) {

                return GetDataHttp(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                if (!TextUtils.isEmpty(s)) {
                    callback.Succorce(s);
                } else {
                    callback.Error(503, "未请求到数据");
                }
            }
        }.execute(server_url);

    }



    public void PostAsync(final String url, final String username, final String pswd, final AsyncCallback callback) {
        //异步处理
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... strings) {

                return PostDataHttp(strings[0],strings[1],strings[2]);
            }

            @Override
            protected void onPostExecute(String s) {
                if (!TextUtils.isEmpty(s)) {
                    callback.Succorce(s);
                } else {
                    callback.Error(503, "未请求到数据");
                }
            }
        }.execute(url,username,pswd);

    }


    //获取网络数据
    private String GetDataHttp(String server_url) {
        HttpURLConnection httpURLConnection = null;
        try {

            URL url = new URL(server_url);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                //输入流
                InputStream inputStream = httpURLConnection.getInputStream();
                String s = new String(ByteStreams.toByteArray(inputStream));

                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private String PostDataHttp(String server_url,String name,String pswd) {

        HttpURLConnection httpURLConnection = null;
        try {

            URL url = new URL(server_url);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);

            //请求头的信息
            String body = "phone=" + URLEncoder.encode(name) + "&pwd=" + URLEncoder.encode(pswd);

            httpURLConnection.getOutputStream().write(body.getBytes());
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();
                String s = new String(ByteStreams.toByteArray(inputStream));

                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    //设置接口
    public interface AsyncCallback {
        void Error(int errorcode, String message);

        void Succorce(String result);
    }

}
