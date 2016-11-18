package com.ptlearnpoint.mathtest;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class TossActivity extends AppCompatActivity {

    FloatingActionButton btnToss ;
    TextView tossResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss);
        toolbarSetup();
        btnToss = (FloatingActionButton) findViewById(R.id.btn_toss);
        tossResult = (TextView) findViewById(R.id.txt_toss_result);

        btnToss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int toss=(int)(Math.random()*2);
                if(toss==0)
                    tossResult.setText("Head");
                else
                    tossResult.setText("Tail");
            }
        });


    }

    public void toolbarSetup(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
