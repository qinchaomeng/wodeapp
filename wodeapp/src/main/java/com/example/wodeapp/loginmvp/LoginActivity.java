package com.example.wodeapp.loginmvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wodeapp.MainActivity;
import com.example.wodeapp.R;
import com.example.wodeapp.bean.LoginBean;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity implements LoginContract.IloginView{

    public static final String BaseLoginUrl="http://172.17.8.100/small/user/v1/login";
    private LoginPreSenter loginPreSenter;
    private EditText nameEt,pswdEt;
    private Button button;
    private CheckBox checkBox;
    private String musername,mpswd;
    private Gson gson;
    private LoginBean loginBean;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPreSenter=new LoginPreSenter();
        loginPreSenter.attch(this);
        init();
    }

    private void init() {
        nameEt = findViewById(R.id.login_name_et);
        pswdEt=findViewById(R.id.login_pswd_et);
        button=findViewById(R.id.login_bt);
        checkBox=findViewById(R.id.login_cb);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 musername = nameEt.getText().toString();
            mpswd=pswdEt.getText().toString();

                if (!musername.isEmpty()&&!mpswd.isEmpty()){
                    loginPreSenter.login(BaseLoginUrl,musername,mpswd);

                }

            }
        });
    }

    @Override
    public void getPreDate(String data) {
        gson = new Gson();
        if(data!=null){
            loginBean = gson.fromJson(data, LoginBean.class);
            Toast.makeText(this,loginBean.getMessage(),Toast.LENGTH_LONG).show();
            if(loginBean.getStatus().equals("0000")){

                intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPreSenter.detch();
    }
}
