package com.example.nideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nideapp.bean.LoginBean;
import com.example.nideapp.loginmvp.LoginContract;
import com.example.nideapp.loginmvp.LoginPresenter;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements LoginContract.ILoginView {

    private Button btn_login;
    private EditText login_pwd,login_phone;
    private LoginPresenter presenter;
    public static final String BaseLoginUrl="http://172.17.8.100/small/user/v1/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter=new LoginPresenter();
        presenter.attch(this);

        init();
    }

    private void init() {
        login_phone=findViewById(R.id.login_phone);
         login_pwd = findViewById(R.id.login_pwd);
        btn_login = findViewById(R.id.btn_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phones = login_phone.getText().toString();
                String pwds = login_pwd.getText().toString();
if (!phones.isEmpty() && !pwds.isEmpty()){
    presenter.toLogin(BaseLoginUrl,phones,pwds);
}

            }
        });
    }

    @Override
    public void getXinxi(String data) {
        Gson gson=new Gson();
        if(data!=null){
            LoginBean loginBean = gson.fromJson(data, LoginBean.class);
            if (loginBean.getStatus().equals("0000")){
//                Intent intent=new Intent(MainActivity.this,ShowActivity.class);
//                startActivity(intent);
                Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
