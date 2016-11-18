package com.ptlearnpoint.mathtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LotteryActivity extends AppCompatActivity {

    private EditText etNumberOne , etNumberTwo ;
    private TextView txtResult , txtBalance;
    private Button btnSee;
    int balence=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottery);
        toolbarSetup();
        initializeViews();


        btnSee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberOne = etNumberOne.getText().toString();
                String numberTwo = etNumberTwo.getText().toString();
                String digit = numberOne.concat(numberTwo);
                int dis=Integer.parseInt(digit);
                int number=Integer.parseInt(numberOne);

                int lottery=(int) (Math.random()*100);
                int lotterydisit=lottery/10;
                int lotterydisit2=lottery%10;
                int guessnumber1=number/10;
                int guessnumber2=number%10;
                //sout lottery
                if(lottery==number){
                    //sout
                    txtResult.setText("you won the lottery 10000");
                    balence=balence+10000;

                }
                else if(guessnumber2==lotterydisit && guessnumber1==lotterydisit2){
                    //sout
                    txtResult.setText("you win the lottery 3000");
                    balence=balence+3000;

                }
                else if(guessnumber1==lotterydisit ||
                        guessnumber2==lotterydisit ||
                        guessnumber1== lotterydisit2 ||
                        guessnumber2== lotterydisit2){
                    //sout
                    txtResult.setText("you win the lottery 1000");
                    balence=balence+1000;

                }
                else{
                    txtResult.setText("sorry don't match try again ");
                    balence=balence-2000;

                }
                txtBalance.setText(String.valueOf(balence));

            }
        });

    }

    private void initializeViews() {
        etNumberOne = (EditText) findViewById(R.id.et_number_one);
        etNumberTwo = (EditText) findViewById(R.id.et_number_two);
        txtBalance = (TextView) findViewById(R.id.txt_balance);
        txtResult = (TextView) findViewById(R.id.txt_lottery_result);
        btnSee = (Button) findViewById(R.id.btnSee);
    }

    public void toolbarSetup(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
