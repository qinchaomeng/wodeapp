package com.example.lianxi.v;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.lianxi.R;
import com.example.lianxi.contract.ContractInteface;

public class MainActivity extends AppCompatActivity implements ContractInteface.ProductInteface {

    private ListView list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
         list_view = findViewById(R.id.list_view);
    }

    @Override
    public void ShowDisplay(Object obj) {

    }
}
