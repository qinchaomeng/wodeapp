package com.example.lianxi.util;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Time:2019/4/13
 * Author:秦超蒙
 * Description:
 */
public class HttpUtil {

    //请求数据
    public static String getData(String dataUrl){
        try {
            URL url=new URL(dataUrl);
            HttpURLConnection connection =(HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int code = connection.getResponseCode();
            if (code==200){
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
               StringBuilder builder=new StringBuilder();
               String str="";
               while ((str=reader.readLine())!=null){
                   builder.append(str);
               }
               return builder.toString();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    //接口回调
    public interface MyCallBack{
        //方法
        public void getData(String str);
    }

    public static void MyTask(String url, final MyCallBack myCallBack){

        new AsyncTask<String ,Void,String >(){
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                myCallBack.getData(s);
            }

            @Override
            protected String doInBackground(String... strings) {
                String data = HttpUtil.getData(strings[0]);


                return data;
            }
        }.execute(url);
    }
}
